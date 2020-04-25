package org.woodwhales.ncov.service;

import org.woodwhales.ncov.controller.params.DatasCreateParam;
import org.woodwhales.ncov.controller.params.DatasUpdateParam;
import org.woodwhales.ncov.dto.BaseDTO;
import org.woodwhales.ncov.dto.PageDTO;
import org.woodwhales.ncov.dto.RealTimeDataDTO;
import org.woodwhales.ncov.enums.RealTimeDataTypeEnum;

public interface RealTimeDataService {

	RealTimeDataDTO getDataByDataType(RealTimeDataTypeEnum realTimeDataTypeEnum);

	PageDTO<RealTimeDataDTO> pageDatas(long page, long limit, RealTimeDataTypeEnum realTimeDataTypeEnum);

	BaseDTO<String> deleteDataByCode(String datasCode);

	RealTimeDataDTO getDataDTOByCode(String datasCode);

	BaseDTO<String> createData(DatasCreateParam param);

	BaseDTO<String> updateDatas(DatasUpdateParam param);

}
