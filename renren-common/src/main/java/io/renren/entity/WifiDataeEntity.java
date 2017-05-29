package io.renren.entity;

/**
 * Created by 汪本成
 * email: wbc0128@163.com
 * csdn博客: blog.csdn.net/wbcshy
 * github: https://github.com/wbcshy
 * 2017/4/27
 */

//wifi数据表
public class WifiDataeEntity {
    private Long id;   //主键
    private float tem;   //温度
    private float humi;   //湿度
    private float mq;     //co2浓度
    private int state;    //



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTem() {
        return tem;
    }

    public void setTem(float tem) {
        this.tem = tem;
    }

    public float getHumi() {
        return humi;
    }

    public void setHumi(float humi) {
        this.humi = humi;
    }

    public float getMq() {
        return mq;
    }

    public void setMq(float mq) {
        this.mq = mq;
    }
}
