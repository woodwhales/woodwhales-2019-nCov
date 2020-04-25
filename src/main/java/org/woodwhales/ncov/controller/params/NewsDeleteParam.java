package org.woodwhales.ncov.controller.params;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDeleteParam {

	@NotBlank(message="新闻编号不允许为空")
	private String newsCode;

}
