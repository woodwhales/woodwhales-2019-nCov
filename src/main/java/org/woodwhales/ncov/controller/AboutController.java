package org.woodwhales.ncov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.woodwhales.ncov.config.AppConfig;
import org.woodwhales.ncov.dto.ProductionInfoDTO;
import org.woodwhales.ncov.service.ProductionInfoServcie;

@Controller
public class AboutController {
	
	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	private ProductionInfoServcie productionInfoServcie;

	@GetMapping("/about")
	public String about(Model model) {
		List<ProductionInfoDTO> listProductionInfos = productionInfoServcie.listProductionInfos();
		model.addAttribute("productionInfos", listProductionInfos);
		model.addAttribute("productionName", appConfig.getProductionName());
		return "about";
	}
}
