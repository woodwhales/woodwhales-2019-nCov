package org.woodwhales.ncov.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO<T> {
	// 当前分页总页数
	private long pages;
	// 每页显示条数
	private long limit;
	// 总条数
	private long count;
	// 分页记录列表
	private List<T> records;
}
