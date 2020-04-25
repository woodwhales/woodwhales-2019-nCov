package org.woodwhales.ncov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinksDTO {
	
	private String code;
	private String url;
	private String linkName;
	private String media;
	private String gmtCreated;
	private String gmtModified;
	
	public LinksDTO(String code, String url, String linkName, String media) {
		super();
		this.code = code;
		this.url = url;
		this.linkName = linkName;
		this.media = media;
	}
}