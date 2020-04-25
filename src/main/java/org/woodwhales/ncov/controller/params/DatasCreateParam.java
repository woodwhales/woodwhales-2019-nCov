package org.woodwhales.ncov.controller.params;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatasCreateParam {
	
	@Min(value = 0, message="不允许为负数")
	private Long confirmed;
	
	@Min(value = 0, message="不允许为负数")
	private Long suspected;
	
	@Min(value = 0, message="不允许为负数")
	private Long healed;
	
	@Min(value = 0, message="不允许为负数")
	private Long dead;

	@NotBlank(message = "发布时间不允许为空")
	private String pulishTime;
	
	@NotBlank(message = "数据类型不允许为空")
	private String dataType;

	public String getPulishTime() {
		return StringUtils.trimToEmpty(pulishTime);
	}

}
