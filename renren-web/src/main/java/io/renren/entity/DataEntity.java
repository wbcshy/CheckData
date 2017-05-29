package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-04-30 17:15:30
 */
public class DataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String tem;
	//
	private String humi;
	//
	private String mq;
	//
	private String dtime;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setTem(String tem) {
		this.tem = tem;
	}
	/**
	 * 获取：
	 */
	public String getTem() {
		return tem;
	}
	/**
	 * 设置：
	 */
	public void setHumi(String humi) {
		this.humi = humi;
	}
	/**
	 * 获取：
	 */
	public String getHumi() {
		return humi;
	}
	/**
	 * 设置：
	 */
	public void setMq(String mq) {
		this.mq = mq;
	}
	/**
	 * 获取：
	 */
	public String getMq() {
		return mq;
	}
	/**
	 * 设置：
	 */
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	/**
	 * 获取：
	 */
	public String getDtime() {
		return dtime;
	}
}
