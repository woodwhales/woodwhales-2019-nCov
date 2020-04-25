package org.woodwhales.ncov.controller.params;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

	@NotBlank(message = "用户名不允许为空")
	private String userName;

	@NotBlank(message = "密码不允许为空")
	private String password;
	
	private String checkCode;
	
}
