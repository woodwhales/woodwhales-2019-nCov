package org.woodwhales.ncov.entity;

import java.util.Date;
import java.util.Objects;

import org.woodwhales.ncov.controller.params.DatasCreateParam;
import org.woodwhales.ncov.controller.params.DatasUpdateParam;
import org.woodwhales.ncov.enums.RealTimeDataTypeEnum;
import org.woodwhales.ncov.utils.DateUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value = "ncov_real_time_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealTimeData {

	@TableId(type = IdType.AUTO)
	private Long id;
	
	private String code;
	
	private Byte dataType;
	
	// 确诊
	private Long confirmed;
	
	// 疑似
	private Long suspected;
	
	// 治愈
	private Long healed;
	
	// 死亡
	private Long dead;
	
	private Date publishTime;
	
	private Date gmtCreated;
	
	private Date gmtModified;

	public static RealTimeData createData(DatasCreateParam param) {
		if(Objects.isNull(param)) {
			throw new RuntimeException("不允许创建对象为空");
		}
		
		RealTimeData realTimeData = new RealTimeData();
		realTimeData.setCode(IdWorker.getIdStr());
		realTimeData.setConfirmed(param.getConfirmed());
		realTimeData.setSuspected(param.getSuspected());
		realTimeData.setHealed(param.getHealed());
		realTimeData.setDead(param.getDead());
		realTimeData.setPublishTime(DateUtils.convertDate(param.getPulishTime()));
		realTimeData.setDataType(RealTimeDataTypeEnum.valueOf(param.getDataType()).getTypeValue());
		realTimeData.setGmtCreated(DateUtils.getNowDate());
		return realTimeData;
	}

	public void update(DatasUpdateParam param) {
		if(Objects.isNull(param)) {
			throw new RuntimeException("不允许更新对象为空");
		}
		
		this.confirmed = param.getConfirmed();
		this.suspected = param.getSuspected();
		this.healed = param.getHealed();
		this.dead = param.getDead();
		this.publishTime = DateUtils.convertDate(param.getPulishTime());
		this.gmtModified = DateUtils.getNowDate();
	}
}
