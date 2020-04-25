package org.woodwhales.ncov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.woodwhales.ncov.dto.LinksDTO;
import org.woodwhales.ncov.dto.RealTimeDataDTO;
import org.woodwhales.ncov.enums.RealTimeDataTypeEnum;
import org.woodwhales.ncov.service.LinksService;
import org.woodwhales.ncov.service.RealTimeDataService;

@Controller
public class IndexController {
	
	@Autowired
	private LinksService linksService;
	
	@Autowired
	private RealTimeDataService realTimeDataService;
	
	@GetMapping({"index", "/"})
	public String index(Model model) {
		List<LinksDTO> links = linksService.listLinks();
		
		RealTimeDataDTO domesticData = realTimeDataService.getDataByDataType(RealTimeDataTypeEnum.DOMESTIC);
		RealTimeDataDTO foreignData = realTimeDataService.getDataByDataType(RealTimeDataTypeEnum.FOREIGN);
		model.addAttribute("domesticData", domesticData);
		model.addAttribute("foreignData", foreignData);
		model.addAttribute("links", links);
		return "index";
	}
	
}
