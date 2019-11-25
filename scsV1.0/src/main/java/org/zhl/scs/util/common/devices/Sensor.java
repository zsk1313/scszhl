package org.zhl.scs.util.common.devices;

/**
 * 传感器枚举类
 */
public enum Sensor {

    //温湿度
    HUMIDITY("温湿度传感器"),
    //烟
    SMOKE("烟雾传感器"),
    //光照度
    LIGHT("光照传感器"),
    //PM2.5
    PM25("PM2.5传感器");

    private String type;

    public String getType() {
        return type;
    }

    Sensor(String type) {
        this.type = type;
    }

}
