package org.woodwhales.ncov.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.woodwhales.ncov.controller.params.NewsCreateParam;
import org.woodwhales.ncov.controller.params.NewsDeleteParam;
import org.woodwhales.ncov.controller.params.NewsUpdateParam;
import org.woodwhales.ncov.controller.vo.BaseVO;
import org.woodwhales.ncov.controller.vo.PageVO;
import org.woodwhales.ncov.dto.BaseDTO;
import org.woodwhales.ncov.dto.NewsDTO;
import org.woodwhales.ncov.dto.PageDTO;
import org.woodwhales.ncov.enums.NewsTypeEnum;
import org.woodwhales.ncov.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;

	@GetMapping("/list")
	public PageVO<NewsDTO> pageNews(@RequestParam(name="page", defaultValue="1") long page, 
			@RequestParam(name="limit", defaultValue="5") long limit, @RequestParam(name="type", defaultValue="DOMESTIC") String type) {
		
		NewsTypeEnum newsTypeEnum = NewsTypeEnum.valueOf(type);
		
		PageDTO<NewsDTO> pageResult = newsService.pageNews(page, limit, newsTypeEnum);
		PageVO<NewsDTO> pageVO = new PageVO<NewsDTO>();
		pageVO.setCode(0);
		pageVO.setMsg(StringUtils.EMPTY);
		pageVO.setCount(pageResult.getCount());
		pageVO.setLimit(pageResult.getLimit());
		pageVO.setPages(pageResult.getPages());
		pageVO.setData(pageResult.getRecords());
		return pageVO;
	}

	/**
	 * 详情
	 * @param newsCode
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/detail")
	public BaseVO<NewsDTO> detail(@RequestParam(name="newsCode") String newsCode) {
		NewsDTO newsDTO =  newsService.getNewsDTOByCode(newsCode);
		return BaseVO.returnResp(newsDTO);
	}

	/**
	 * 更新
	 * @param param
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN"})
	@PostMapping("/update")
	public BaseVO<String> update(@Valid @RequestBody NewsUpdateParam param) {
		BaseDTO<String> result =  newsService.updateNews(param);
		return BaseVO.returnResp(result);
	}

	/**
	 * 创建
	 * @param param
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN"})
	@PostMapping("/create")
	public BaseVO<String> create(@Valid @RequestBody NewsCreateParam param) {
		BaseDTO<String> result =  newsService.createNews(param);
		return BaseVO.returnResp(result);
	}

	/**
	 * 删除
	 * @param param
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN"})
	@PostMapping("/delete")
	public BaseVO<String> delete(@Valid @RequestBody NewsDeleteParam param) {
		BaseDTO<String> result =  newsService.deleteNewsByCode(param.getNewsCode());
		return BaseVO.returnResp(result);
	}
	
}
