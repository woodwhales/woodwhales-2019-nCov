package org.woodwhales.ncov.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NewsTypeEnum {
	// 国内新闻
	DOMESTIC, 
	// 国外新闻
	FOREIGN;
	
	public byte getTypeValue() {
		if(this == DOMESTIC) {
			return (byte)1;
		}
		
		if(this == FOREIGN) {
			return (byte)2;
		}
		
		throw new RuntimeException("获取新闻类型数值非法");
	}
}
