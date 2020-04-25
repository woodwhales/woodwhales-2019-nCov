package org.woodwhales.ncov.controller.params;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewsUpdateParam {
	
	@NotBlank(message = "编号不允许为空")
	private String code;
	
	@NotBlank(message = "标题不允许为空")
	private String title;
	
	@NotBlank(message = "内容不允许为空")
	private String content;
	
	@NotBlank(message = "发布时间不允许为空")
	private String publishTime;
	
	@NotBlank(message = "媒体来源不允许为空")
	private String fromMedia;

	@NotBlank(message = "链接不允许为空")
	private String fromUrl;

	public String getCode() {
		return StringUtils.trimToEmpty(code);
	}

	public String getTitle() {
		return StringUtils.trimToEmpty(title);
	}

	public String getContent() {
		return StringUtils.trimToEmpty(content);
	}

	public String getPublishTime() {
		return StringUtils.trimToEmpty(publishTime);
	}

	public String getFromMedia() {
		return StringUtils.trimToEmpty(fromMedia);
	}

	public String getFromUrl() {
		return StringUtils.trimToEmpty(fromUrl);
	}
	
	
}
