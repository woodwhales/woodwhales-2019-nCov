package org.woodwhales.ncov.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.woodwhales.ncov.controller.params.NewsCreateParam;
import org.woodwhales.ncov.controller.params.NewsUpdateParam;
import org.woodwhales.ncov.dto.BaseDTO;
import org.woodwhales.ncov.dto.NewsDTO;
import org.woodwhales.ncov.dto.PageDTO;
import org.woodwhales.ncov.entity.News;
import org.woodwhales.ncov.enums.NewsTypeEnum;
import org.woodwhales.ncov.repository.NewsRepository;
import org.woodwhales.ncov.service.NewsService;
import org.woodwhales.ncov.utils.BeanTools;
import org.woodwhales.ncov.utils.DateUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public PageDTO<NewsDTO> pageNews(long current, long size, NewsTypeEnum newsTypeEnum) {
		LambdaQueryWrapper<News> queryWrapper = Wrappers.<News>lambdaQuery()
														.eq(News::getNewsType, newsTypeEnum.getTypeValue())
														.orderByDesc(News::getPublishTime);
		Page<News> page = new Page<News>(current, size);
		IPage<News> pageResult = newsRepository.selectPage(page, queryWrapper);
		
		List<News> data = pageResult.getRecords();
		long total = pageResult.getTotal();
		long pages = pageResult.getPages();
		PageDTO<NewsDTO> pageDTO = new PageDTO<NewsDTO>();
		pageDTO.setLimit(size);
		pageDTO.setCount(total);
		pageDTO.setPages(pages);
		pageDTO.setRecords(convertDTO(data));
		return pageDTO;
	}

	private List<NewsDTO> convertDTO(List<News> data) {
		if(CollectionUtils.isEmpty(data)) {
			return Collections.emptyList();
		}
		
		return data.stream().map(BeanTools::convert).collect(Collectors.toList());
	}

	@Override
	@Transactional(rollbackFor = {Error.class, Exception.class})
	public BaseDTO<String> deleteNewsByCode(String newsCode) {
		News news = getNewsByCode(newsCode);
		
		if(Objects.isNull(news)) {
			return BaseDTO.fail(-1, "要删除的数据不存在", newsCode);
		}
		
		return BaseDTO.returnResp(newsRepository.deleteById(news.getId()), 1, newsCode);
	}
	
	@Override
	public NewsDTO getNewsDTOByCode(String newsCode) {
		News news = getNewsByCode(newsCode);
		if(Objects.isNull(news)) {
			return null;
		}
		return BeanTools.convert(news);
	}
	
	private News getNewsByCode(String newsCode) {
		LambdaQueryWrapper<News> queryWrapper = Wrappers.<News>lambdaQuery().eq(News::getCode, newsCode);
		return newsRepository.selectOne(queryWrapper);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public BaseDTO<String> updateNews(NewsUpdateParam param) {
		String newsCode = param.getCode();
		News oldNews = getNewsByCode(newsCode);
		if(Objects.isNull(oldNews)) {
			return BaseDTO.fail(-1, "要更新的数据不存在", newsCode);
		}
		
		if(StringUtils.equals(oldNews.getContent(), param.getContent())
				&& StringUtils.equals(oldNews.getFromMedia(), param.getFromMedia())
				&& StringUtils.equals(oldNews.getFromUrl(), param.getFromUrl())
				&& StringUtils.equals(DateUtils.formatMiddleIfNull(oldNews.getPublishTime()), param.getPublishTime())
				&& StringUtils.equals(oldNews.getTitle(), param.getTitle())) {
			return BaseDTO.success("更新成功", newsCode);
		}
		
		oldNews.update(param);
		
		return BaseDTO.returnResp(newsRepository.updateById(oldNews), 1, newsCode);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public BaseDTO<String> createNews(NewsCreateParam param) {
		News newNews = News.create(param);
		return BaseDTO.returnResp(newsRepository.insert(newNews), 1, newNews.getCode());
	}
}
