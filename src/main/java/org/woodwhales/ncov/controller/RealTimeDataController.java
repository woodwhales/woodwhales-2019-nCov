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
import org.woodwhales.ncov.controller.params.DatasCreateParam;
import org.woodwhales.ncov.controller.params.DatasDeleteParam;
import org.woodwhales.ncov.controller.params.DatasUpdateParam;
import org.woodwhales.ncov.controller.vo.BaseVO;
import org.woodwhales.ncov.controller.vo.PageVO;
import org.woodwhales.ncov.dto.BaseDTO;
import org.woodwhales.ncov.dto.PageDTO;
import org.woodwhales.ncov.dto.RealTimeDataDTO;
import org.woodwhales.ncov.enums.RealTimeDataTypeEnum;
import org.woodwhales.ncov.service.RealTimeDataService;

@RestController
@RequestMapping("/datas")
public class RealTimeDataController {

	@Autowired
	private RealTimeDataService realTimeDataService;

	@Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/")
	public RealTimeDataDTO getRealTimeData(@RequestParam(name="type", defaultValue="DOMESTIC") String type) {
		RealTimeDataTypeEnum realTimeDataTypeEnum = RealTimeDataTypeEnum.valueOf(type);
		return realTimeDataService.getDataByDataType(realTimeDataTypeEnum);
	}
	
	@Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/list")
	public PageVO<RealTimeDataDTO> pageNews(@RequestParam(name="page", defaultValue="1") long page, 
			@RequestParam(name="limit", defaultValue="5") long limit, 
			@RequestParam(name="type", defaultValue="DOMESTIC") String type) {
		
		RealTimeDataTypeEnum realTimeDataTypeEnum = RealTimeDataTypeEnum.valueOf(type);
		
		PageDTO<RealTimeDataDTO> pageResult = realTimeDataService.pageDatas(page, limit, realTimeDataTypeEnum);
		PageVO<RealTimeDataDTO> pageVO = new PageVO<RealTimeDataDTO>();
		pageVO.setCode(0);
		pageVO.setMsg(StringUtils.EMPTY);
		pageVO.setCount(pageResult.getCount());
		pageVO.setLimit(pageResult.getLimit());
		pageVO.setPages(pageResult.getPages());
		pageVO.setData(pageResult.getRecords());
		return pageVO;
	}

	/**
	 * 更新
	 * @param param
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN"})
	@PostMapping("/update")
	public BaseVO<String> update(@Valid @RequestBody DatasUpdateParam param) {
		BaseDTO<String> result =  realTimeDataService.updateDatas(param);
		return BaseVO.returnResp(result);
	}

	/**
	 * 详情
	 * @param datasCode
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/detail")
	public BaseVO<RealTimeDataDTO> detail(@RequestParam(name="datasCode") String datasCode) {
		RealTimeDataDTO realTimeDataDTO =  realTimeDataService.getDataDTOByCode(datasCode);
		return BaseVO.returnResp(realTimeDataDTO);
	}

	/**
	 * 创建
	 * @param param
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN"})
	@PostMapping("/create")
	public BaseVO<String> create(@Valid @RequestBody DatasCreateParam param) {
		BaseDTO<String> result =  realTimeDataService.createData(param);
		return BaseVO.returnResp(result);
	}

	/**
	 * 更新
	 * @param param
	 * @return
	 */
	@Secured(value = {"ROLE_ADMIN"})
	@PostMapping("/delete")
	public BaseVO<String> delete(@Valid @RequestBody DatasDeleteParam param) {
		BaseDTO<String> result =  realTimeDataService.deleteDataByCode(param.getDatasCode());
		return BaseVO.returnResp(result);
	}
}
