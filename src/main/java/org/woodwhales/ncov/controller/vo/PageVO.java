package org.woodwhales.ncov.controller.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> {
	private Integer code;
	private String msg;
	private long pages;
	private long limit;
	private long count;
	private List<T> data;
}
