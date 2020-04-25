package org.woodwhales.ncov.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value = "ncov_production_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionInfo {
	@TableId(type = IdType.AUTO)
	private Long id;
	private String code;
	private String version;
	private Date publishTime;
	private String description;
	private Integer sort;
	private Date gmtCreated;
	private Date gmtModified;
}
