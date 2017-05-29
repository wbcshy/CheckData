package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wbcwhy
 * @email wbc0128@163.com
 * @date 2017-05-02 01:25:22
 */
public class WdataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String tem;
	//
	private String humi;
	//
	private String mq;
	//
	private String datestr;
	//
	private String date;

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
	public void setDatestr(String datestr) {
		this.datestr = datestr;
	}
	/**
	 * 获取：
	 */
	public String getDatestr() {
		return datestr;
	}
	/**
	 * 设置：
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 获取：
	 */
	public String getDate() {
		return date;
	}
}
