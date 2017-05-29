package io.po;



import java.io.Serializable;

/**
 * Created by 汪本成 on 2017/4/18.
 */

//采集数据的javaBean
public class TemCo2 implements Serializable {

    //每组数据的划分id号
    private int ID;
    //温度值
    private String tem;
    //co2浓度值
    private String co2;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }
}
