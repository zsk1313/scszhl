package org.zhl.scs.util.common.devices;

/**
 * 设备控制枚举类
 * @author lzs
 * @version v1.0
 */
public enum DeviceControl {

    //灯光控制
    LIGHT("照明"),
    //窗帘控制
    CURTAIN("窗帘"),
    //风扇控制
    FAN("风扇"),
    //空调控制
    AIR_CONDITIONER("空调");

    private String type;

    public String getType() {
        return type;
    }

    DeviceControl(String type) {
        this.type = type;
    }

}
