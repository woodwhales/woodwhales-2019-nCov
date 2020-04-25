package org.woodwhales.ncov.controller.vo;


import java.util.Objects;

import org.woodwhales.ncov.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseVO<T> {
	
	private Integer code;
	private String msg;
	private T data;
	
	public static <T> BaseVO<T> success(String msg, T data) {
		BaseVO<T> baseVO = new BaseVO<>();
		baseVO.setCode(0);
		baseVO.setMsg(msg);
		baseVO.setData(data);
		return baseVO;
	}
	
	public static <T> BaseVO<T> fail(Integer code, String msg, T data) {
		BaseVO<T> baseVO = new BaseVO<>();
		baseVO.setCode(code);
		baseVO.setMsg(msg);
		baseVO.setData(data);
		return baseVO;
	}
	
	public static <T> BaseVO<T> returnResp(T data) {
		if(Objects.isNull(data)) {
			return fail(-1, "请求非法", data);
		}
		
		return BaseVO.success("success", data);
	}

	public static <T> BaseVO<T> returnResp(BaseDTO<T> result) {
		Objects.requireNonNull(result);
		
		if(result.isSuccess()) {
			return BaseVO.success("success", result.getData());
		}
		
		return BaseVO.fail(result.getCode(), result.getMsg(), result.getData());
	}
}
