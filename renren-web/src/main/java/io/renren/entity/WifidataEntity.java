package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-04-30 00:50:34
 */
public class WifidataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//温度值
	private Float tem;
	//湿度值
	private Float humi;
	//co2浓度值
	private Float mq;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setTem(Float tem) {
		this.tem = tem;
	}
	/**
	 * 获取：
	 */
	public Float getTem() {
		return tem;
	}
	/**
	 * 设置：
	 */
	public void setHumi(Float humi) {
		this.humi = humi;
	}
	/**
	 * 获取：
	 */
	public Float getHumi() {
		return humi;
	}
	/**
	 * 设置：
	 */
	public void setMq(Float mq) {
		this.mq = mq;
	}
	/**
	 * 获取：
	 */
	public Float getMq() {
		return mq;
	}
}
