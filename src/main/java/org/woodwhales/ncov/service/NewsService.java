package org.woodwhales.ncov.service;

import org.woodwhales.ncov.controller.params.NewsCreateParam;
import org.woodwhales.ncov.controller.params.NewsUpdateParam;
import org.woodwhales.ncov.dto.BaseDTO;
import org.woodwhales.ncov.dto.NewsDTO;
import org.woodwhales.ncov.dto.PageDTO;
import org.woodwhales.ncov.enums.NewsTypeEnum;

public interface NewsService {

	PageDTO<NewsDTO> pageNews(long current, long size, NewsTypeEnum newsTypeEnum);

	BaseDTO<String> deleteNewsByCode(String newsCode);
	
	NewsDTO getNewsDTOByCode(String newsCode);

	BaseDTO<String> updateNews(NewsUpdateParam param);

	BaseDTO<String> createNews(NewsCreateParam param);

}
