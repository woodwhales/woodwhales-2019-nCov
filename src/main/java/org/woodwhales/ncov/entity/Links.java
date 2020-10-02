package org.woodwhales.ncov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Links {
	@TableId(type = IdType.AUTO, value = "${column.dbName}")
	private Long id;
	@TableField(value = "${column.dbName}")
	private String code;
	private String url;
	private String linkName;
	private String media;
	private Date gmtCreated;
	private Date gmtModified;
	
}
