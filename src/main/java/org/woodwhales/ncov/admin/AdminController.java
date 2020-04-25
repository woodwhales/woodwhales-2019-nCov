package org.woodwhales.ncov.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.woodwhales.ncov.dto.NewsDTO;
import org.woodwhales.ncov.dto.RealTimeDataDTO;
import org.woodwhales.ncov.enums.NewsTypeEnum;
import org.woodwhales.ncov.enums.RealTimeDataTypeEnum;
import org.woodwhales.ncov.service.NewsService;
import org.woodwhales.ncov.service.RealTimeDataService;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	private RealTimeDataService realTimeDataService;
	
	@Autowired
	private NewsService newsService;

	// =========
	// 首页
	// =========
	@Secured(value={"ROLE_USER"})
	@GetMapping({"/", "/index"})
	public String index() {
		return "admin/index";
	}

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	// =========
	// 欢迎页
	// =========
	@Secured(value={"ROLE_USER"})
	@GetMapping({"/welcome"})
	public String welcome(Model model) {
		RealTimeDataDTO domesticData = realTimeDataService.getDataByDataType(RealTimeDataTypeEnum.DOMESTIC);
		RealTimeDataDTO foreignData = realTimeDataService.getDataByDataType(RealTimeDataTypeEnum.FOREIGN);
		model.addAttribute("domesticData", domesticData);
		model.addAttribute("foreignData", foreignData);
		return "admin/welcome";
	}

	// =========
	// 实时新闻
	// user: 列表展示，详情
	// admin: 列表展示，添加，更新，删除
	// =========

	/**
	 * 实时新闻-列表展示
	 * @param type
	 * @param model
	 * @return
	 */
	@Secured(value={"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/newsList")
	public String domesticNews(@RequestParam(name="type") String type, Model model) {
		model.addAttribute("type", checkNewsType(type));
		
		if(NewsTypeEnum.FOREIGN == NewsTypeEnum.valueOf(type)) {
			return "admin/news-foreign-list";
		}
		
		return "admin/news-domestic-list";
	}

	/**
	 * 实时新闻-添加
	 * @param type
	 * @param model
	 * @return
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/newsAdd")
 	public String newsAdd(@RequestParam(name="type") String type, Model model) {
		model.addAttribute("type", checkNewsType(type));
		return "admin/news-add";
	}

	/**
	 * 实时新闻-查询详情
	 * @param model
	 * @param newsCode
	 * @param type
	 * @return
	 */
	@Secured(value={"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/newsDetail")
	public String domesticNewsDetail(Model model, @RequestParam(name = "newsCode") String newsCode,
			@RequestParam(name="type") String type) {
		NewsDTO newsDTO = newsService.getNewsDTOByCode(newsCode);

		model.addAttribute("news", newsDTO);
		model.addAttribute("type", checkNewsType(type));
		return "admin/news-detail";
	}

	/**
	 * 实时新闻-更新
	 * @param model
	 * @param newsCode
	 * @param type
	 * @return
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/newsUpdate")
	public String domesticNewsUpdate(Model model, @RequestParam(name = "newsCode") String newsCode,
			@RequestParam(name="type") String type) {
		NewsDTO newsDTO = newsService.getNewsDTOByCode(newsCode);
		
		model.addAttribute("news", newsDTO);
		model.addAttribute("type", checkNewsType(type));
		return "admin/news-update";
	}
	
	// =========
	// 实时数据
	// user: 可以展示列表
	// admin: 展示，添加，更新，删除
	// =========

	/**
	 * 实时数据-列表展示
	 * @param type
	 * @param model
	 * @return
	 */
	@Secured(value={"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/realTimeDataList")
	public String realTimeDataList(@RequestParam(name="type") String type, Model model) {
		model.addAttribute("type", checkRealTimeDataType(type));
		
		if(RealTimeDataTypeEnum.FOREIGN == RealTimeDataTypeEnum.valueOf(type)) {
			return "admin/real-time-data-foreign-list";
		}
		
		return "admin/real-time-data-domestic-list";
	}

	/**
	 * 实时数据-添加
	 * @param type
	 * @param model
	 * @return
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/realTimeDataAdd")
 	public String realTimeDataAdd(@RequestParam(name="type", defaultValue="DOMESTIC") String type, Model model) {
		model.addAttribute("type", checkRealTimeDataType(type));
		return "admin/real-time-data-add";
	}

	/**
	 * 实时数据-查询详情
	 * @param model
	 * @param datasCode
	 * @param type
	 * @return
	 */
	@Secured(value={"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/realTimeDataDetail")
	public String realTimeDataDetail(Model model, @RequestParam(name = "datasCode") String datasCode,
			@RequestParam(name="type") String type) {
		RealTimeDataDTO realTimeDataDTO = realTimeDataService.getDataDTOByCode(datasCode);
		
		model.addAttribute("datas", realTimeDataDTO);
		model.addAttribute("type", checkRealTimeDataType(type));
		return "admin/real-time-data-detail";
	}

	/**
	 * 实时数据-更新
	 * @param model
	 * @param datasCode
	 * @param type
	 * @return
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/realTimeDataUpdate")
	public String realTimeDataUpdate(Model model, @RequestParam(name = "datasCode") String datasCode,
			@RequestParam(name="type") String type) {
		
		RealTimeDataDTO realTimeDataDTO = realTimeDataService.getDataDTOByCode(datasCode);
		
		model.addAttribute("datas", realTimeDataDTO);
		model.addAttribute("type", checkRealTimeDataType(type));
		return "admin/real-time-data-update";
	}
	
	private String checkRealTimeDataType(String type) {
		return RealTimeDataTypeEnum.valueOf(type).name();
	}
	
	private String checkNewsType(String type) {
		return NewsTypeEnum.valueOf(type).name();
	}
}
