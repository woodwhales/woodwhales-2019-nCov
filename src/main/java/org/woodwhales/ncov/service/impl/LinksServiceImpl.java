package org.woodwhales.ncov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.woodwhales.ncov.dto.LinksDTO;
import org.woodwhales.ncov.service.LinksService;

import com.google.common.collect.Lists;

@Service
public class LinksServiceImpl implements LinksService {

	@Override
	public List<LinksDTO> listLinks() {
		ArrayList<LinksDTO> result = Lists.newArrayList();
		result.add(new LinksDTO("1", "https://ncov.dxy.cn/ncovh5/view/pneumonia", "全国新型肺炎疫情实时动态", "丁香园·丁香医生"));
		result.add(new LinksDTO("1", "https://news.qq.com/zt2020/page/feiyan.htm", "实时更新：新冠肺炎疫情最新动态", "腾讯新闻"));
		result.add(new LinksDTO("1", "https://voice.baidu.com/act/newpneumonia/newpneumonia/", "实时更新：新型冠状病毒肺炎疫情地图", "百度"));
		result.add(new LinksDTO("1", "https://www.zhihu.com/special/19681091", "感染肺炎疫情实时动态", "知乎"));
		result.add(new LinksDTO("1", "https://news.163.com/special/epidemic/", "新型肺炎疫情地图", "网易"));
		result.add(new LinksDTO("1", "https://news.sina.cn/zt_d/yiqing0121", "新型冠状病毒肺炎全国疫情地图", "新浪"));
		result.add(new LinksDTO("1", "https://broccoli.uc.cn/apps/pneumonia/routes/index", "新冠肺炎疫情实时动态", "夸克AI搜索"));
		result.add(new LinksDTO("1", "http://m.medsci.cn/wh.asp", "新型冠状病毒感染肺炎疫情实时动态", "梅斯医学"));
		result.add(new LinksDTO("1", "https://news.ifeng.com/c/special/7tPlDSzDgVk", "新型肺炎疫情实时动态", "凤凰网"));
		result.add(new LinksDTO("1", "http://health.people.com.cn/GB/26466/431463/431576/index.html", "新型冠状病毒感染的肺炎疫情动态", "人民网"));
		result.add(new LinksDTO("1", "https://coronavirus.1point3acres.com/", "肺炎疫情实时动态 · 北美", "一亩三分地"));
		result.add(new LinksDTO("1", "https://ncov.shanyue.tech/", "肺炎疫情实时动态 · 地级市", "shfshanyue/2019-ncov"));
		result.add(new LinksDTO("1", "http://2019ncov.nosugartech.com/", "新型冠状病毒感染的肺炎确诊患者同行程查询工具", "nosugartech.com"));
		result.add(new LinksDTO("1", "https://vp.fact.qq.com/home", "较真查证平台 - 新型冠状病毒肺炎实时辟谣", "腾讯新闻"));
		return result;
	}

}
