package org.woodwhales.ncov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealTimeDataDTO {
	
	private String code;

	// 确诊
	private Long confirmed;
	
	// 疑似
	private Long suspected;
	
	// 治愈
	private Long healed;
	
	// 死亡
	private Long dead;
	
	private String publishTime;
	
	private String gmtCreated;
	
	private String gmtModified;
	
	public static RealTimeDataDTO newEmpty() {
		return RealTimeDataDTO.builder().build();
	}
	
}
