package org.woodwhales.ncov.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.woodwhales.ncov.dto.ProductionInfoDTO;
import org.woodwhales.ncov.entity.ProductionInfo;
import org.woodwhales.ncov.repository.ProductionInfoRespository;
import org.woodwhales.ncov.service.ProductionInfoServcie;
import org.woodwhales.ncov.utils.BeanTools;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service
public class ProductionInfoServcieImpl implements ProductionInfoServcie {
	
	@Autowired
	private ProductionInfoRespository productionInfoRespository;
	
	@Override
	public List<ProductionInfoDTO> listProductionInfos() {
		LambdaQueryWrapper<ProductionInfo> queryWrapper = Wrappers.<ProductionInfo>lambdaQuery().orderByDesc(ProductionInfo::getSort);
		
		List<ProductionInfo> data = productionInfoRespository.selectList(queryWrapper);
		
		if(CollectionUtils.isEmpty(data)) {
			return Collections.emptyList();
		}
		
		return data.stream().map(BeanTools::convert).collect(Collectors.toList());
		
	}

}
