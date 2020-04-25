package org.woodwhales.ncov.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Links {
	private Long id;
	private String code;
	private String url;
	private String linkName;
	private String media;
	private Date gmtCreated;
	private Date gmtModified;
	
}
