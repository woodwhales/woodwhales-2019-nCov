package org.woodwhales.ncov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO<T> {
	
	private Integer code;
	private String msg;
	private T data;
	
	public static <T> BaseDTO<T> success(String msg, T data) {
		BaseDTO<T> baseDTO = new BaseDTO<>();
		baseDTO.setCode(0);
		baseDTO.setMsg(msg);
		baseDTO.setData(data);
		return baseDTO;
	}
	
	public static <T> BaseDTO<T> returnResp(int result, int expectedResult, T data) {
		if(result == expectedResult) {
			return BaseDTO.success("success", data);
		}
		
		return BaseDTO.fail(-1, "fail", data);
	}
	
	public static <T> BaseDTO<T> fail(Integer code, String msg, T data) {
		BaseDTO<T> baseDTO = new BaseDTO<>();
		baseDTO.setCode(code);
		baseDTO.setMsg(msg);
		baseDTO.setData(data);
		return baseDTO;
	}
	
	public boolean isFail() {
		return !isSuccess();
	}
	
	public boolean isSuccess() {
		if(code == 0) {
			return true;
		}

		return false;
	}
}
