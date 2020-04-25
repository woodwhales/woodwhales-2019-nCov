package org.woodwhales.ncov.enums;

public enum RealTimeDataTypeEnum {
	// 国内实时数据
	DOMESTIC, 
	// 国外实时数据
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
