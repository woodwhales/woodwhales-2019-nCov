package org.woodwhales.ncov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionInfoDTO {
	private String code;
	private String version;
	private String publishTime;
	private String description;
	private String gmtCreated;
	private String gmtModified;
}