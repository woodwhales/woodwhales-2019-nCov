package org.woodwhales.ncov.utils;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.woodwhales.ncov.dto.NewsDTO;
import org.woodwhales.ncov.dto.ProductionInfoDTO;
import org.woodwhales.ncov.dto.RealTimeDataDTO;
import org.woodwhales.ncov.entity.News;
import org.woodwhales.ncov.entity.ProductionInfo;
import org.woodwhales.ncov.entity.RealTimeData;


public class BeanTools {
	
	private BeanTools() {}
	
	public static NewsDTO convert(News news) {
		Objects.requireNonNull(news);
		NewsDTO newsDTO = new NewsDTO();
		BeanUtils.copyProperties(news, newsDTO);
		newsDTO.setPublishTime(DateUtils.formatMiddleIfNull(news.getPublishTime()));
		newsDTO.setGmtCreated(DateUtils.formatIfNull(news.getGmtCreated()));
		newsDTO.setGmtModified(DateUtils.formatIfNull(news.getGmtModified()));
		return newsDTO;
	}
	
	public static ProductionInfoDTO convert(ProductionInfo productionInfo) {
		Objects.requireNonNull(productionInfo);
		ProductionInfoDTO productionInfoDTO = new ProductionInfoDTO();
		BeanUtils.copyProperties(productionInfo, productionInfoDTO);
		productionInfoDTO.setPublishTime(DateUtils.formatSimpleIfNull(productionInfo.getPublishTime()));
		productionInfoDTO.setGmtCreated(DateUtils.formatIfNull(productionInfo.getGmtCreated()));
		productionInfoDTO.setGmtModified(DateUtils.formatIfNull(productionInfo.getGmtModified()));
		return productionInfoDTO;
	}
	
	public static RealTimeDataDTO convert(RealTimeData realTimeData) {
		Objects.requireNonNull(realTimeData);
		RealTimeDataDTO realTimeDataDTO = new RealTimeDataDTO();
		BeanUtils.copyProperties(realTimeData, realTimeDataDTO);
		realTimeDataDTO.setPublishTime(DateUtils.formatMiddleIfNull(realTimeData.getPublishTime()));
		realTimeDataDTO.setGmtCreated(DateUtils.formatIfNull(realTimeData.getGmtCreated()));
		realTimeDataDTO.setGmtModified(DateUtils.formatIfNull(realTimeData.getGmtModified()));
		return realTimeDataDTO;
	}
}
