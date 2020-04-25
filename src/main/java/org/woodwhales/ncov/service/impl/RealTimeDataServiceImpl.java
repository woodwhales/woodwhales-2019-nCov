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
import org.woodwhales.ncov.controller.params.DatasCreateParam;
import org.woodwhales.ncov.controller.params.DatasUpdateParam;
import org.woodwhales.ncov.dto.BaseDTO;
import org.woodwhales.ncov.dto.PageDTO;
import org.woodwhales.ncov.dto.RealTimeDataDTO;
import org.woodwhales.ncov.entity.RealTimeData;
import org.woodwhales.ncov.enums.RealTimeDataTypeEnum;
import org.woodwhales.ncov.repository.RealTimeDataRespository;
import org.woodwhales.ncov.service.RealTimeDataService;
import org.woodwhales.ncov.utils.BeanTools;
import org.woodwhales.ncov.utils.DateUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class RealTimeDataServiceImpl implements RealTimeDataService {

	@Autowired
	private RealTimeDataRespository realTimeDataRespository;
	
	@Override
	public RealTimeDataDTO getDataByDataType(RealTimeDataTypeEnum realTimeDataTypeEnum) {
		LambdaQueryWrapper<RealTimeData> queryWrapper = Wrappers.<RealTimeData>lambdaQuery()
												.eq(RealTimeData::getDataType, realTimeDataTypeEnum.getTypeValue())
												.orderByDesc(RealTimeData::getPublishTime);
		
		IPage<RealTimeData> data = realTimeDataRespository.selectPage(new Page<>(1, 1), queryWrapper);
		if(CollectionUtils.isEmpty(data.getRecords())) {
			return RealTimeDataDTO.newEmpty();
		}
		
		return BeanTools.convert(data.getRecords().get(0));
	}

	@Override
	public PageDTO<RealTimeDataDTO> pageDatas(long current, long size, RealTimeDataTypeEnum realTimeDataTypeEnum) {
		LambdaQueryWrapper<RealTimeData> queryWrapper = Wrappers.<RealTimeData>lambdaQuery()
				.eq(RealTimeData::getDataType, realTimeDataTypeEnum.getTypeValue())
				.orderByDesc(RealTimeData::getPublishTime);
		Page<RealTimeData> page = new Page<RealTimeData>(current, size);
		IPage<RealTimeData> pageResult = realTimeDataRespository.selectPage(page, queryWrapper);
		
		List<RealTimeData> data = pageResult.getRecords();
		long total = pageResult.getTotal();
		long pages = pageResult.getPages();
		PageDTO<RealTimeDataDTO> pageDTO = new PageDTO<RealTimeDataDTO>();
		pageDTO.setLimit(size);
		pageDTO.setCount(total);
		pageDTO.setPages(pages);
		pageDTO.setRecords(convertDTO(data));
		return pageDTO;
	}
	
	private List<RealTimeDataDTO> convertDTO(List<RealTimeData> data) {
		if(CollectionUtils.isEmpty(data)) {
			return Collections.emptyList();
		}
		
		return data.stream().map(BeanTools::convert).collect(Collectors.toList());
	}

	@Override
	@Transactional(rollbackFor = {Error.class, Exception.class})
	public BaseDTO<String> deleteDataByCode(String datasCode) {
		RealTimeData data = getRealTimeDataByCode(datasCode);
		if(Objects.isNull(data)) {
			return BaseDTO.fail(-1, "要删除的数据不存在", datasCode);
		}
		
		return BaseDTO.returnResp(realTimeDataRespository.deleteById(data.getId()), 1, datasCode);
	}
	
	private RealTimeData getRealTimeDataByCode(String datasCode) {
		LambdaQueryWrapper<RealTimeData> queryWrapper = Wrappers.<RealTimeData>lambdaQuery().eq(RealTimeData::getCode, datasCode);
		return realTimeDataRespository.selectOne(queryWrapper);
	}

	@Override
	public RealTimeDataDTO getDataDTOByCode(String datasCode) {
		RealTimeData data = getRealTimeDataByCode(datasCode);
		if(Objects.isNull(data)) {
			return null;
		}

		return BeanTools.convert(data);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public BaseDTO<String> createData(DatasCreateParam param) {
		RealTimeData realTimeData = RealTimeData.createData(param);
		return BaseDTO.returnResp(realTimeDataRespository.insert(realTimeData), 1, realTimeData.getCode());
	}

	@Override
	public BaseDTO<String> updateDatas(DatasUpdateParam param) {
		String datasCode = param.getCode();
		RealTimeData oldRealTimeData = getRealTimeDataByCode(datasCode);
		if(Objects.isNull(oldRealTimeData)) {
			return BaseDTO.fail(-1, "要更新的数据不存在", datasCode);
		}
		
		if(oldRealTimeData.getConfirmed() == param.getConfirmed()
				&& oldRealTimeData.getHealed() == param.getHealed()
				&& oldRealTimeData.getDead() == param.getDead()
				&& (Objects.nonNull(oldRealTimeData.getSuspected()) && oldRealTimeData.getSuspected() == param.getSuspected())
				&& StringUtils.equals(DateUtils.formatMiddleIfNull(oldRealTimeData.getPublishTime()), param.getPulishTime())) {
			return BaseDTO.success("更新成功", datasCode);
		}
		
		oldRealTimeData.update(param);
		return BaseDTO.returnResp(realTimeDataRespository.updateById(oldRealTimeData), 1, datasCode);
	}
	
}
