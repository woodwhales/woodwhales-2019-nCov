package org.woodwhales.ncov.entity;

import java.util.Date;
import java.util.Objects;

import org.woodwhales.ncov.controller.params.NewsCreateParam;
import org.woodwhales.ncov.controller.params.NewsUpdateParam;
import org.woodwhales.ncov.enums.NewsTypeEnum;
import org.woodwhales.ncov.utils.DateUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value = "ncov_news")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
	
	@TableId(type = IdType.AUTO)
	private Long id;
	
	private String code;
	private String title;
	private Byte newsType;
	private String content;
	private Date publishTime;
	private String fromMedia;
	private String fromUrl;
	private Date gmtCreated;
	private Date gmtModified;
	
	public void update(NewsUpdateParam param) {
		if(Objects.isNull(param)) {
			throw new RuntimeException("不允许更新对象为空");
		}
		
		this.title = param.getTitle();
		this.content = param.getContent();
		this.fromMedia = param.getFromMedia();
		this.fromUrl = param.getFromUrl();
		this.publishTime = DateUtils.convertMiddleDate(param.getPublishTime());
		this.gmtModified = DateUtils.getNowDate();
	}
	
	public static News create(NewsCreateParam param) {
		if(Objects.isNull(param)) {
			throw new RuntimeException("不允许创建对象为空");
		}
		
		News news = new News();
		news.setCode(IdWorker.getIdStr());
		news.setTitle(param.getTitle());
		news.setNewsType(NewsTypeEnum.valueOf(param.getNewsType()).getTypeValue());
		news.setContent(param.getContent());
		news.setFromMedia(param.getFromMedia());
		news.setFromUrl(param.getFromUrl());
		news.setPublishTime(DateUtils.convertMiddleDate(param.getPublishTime()));
		news.setGmtCreated(DateUtils.getNowDate());
		return news;
	}

}
