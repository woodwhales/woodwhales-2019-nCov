package org.woodwhales.ncov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {
	
	private String code;
	private String title;
	private String content;
	private String publishTime;
	private String fromMedia;
	private String fromUrl;
	private String gmtCreated;
	private String gmtModified;
	
}
