package org.zhl.scs.util.common.devices;

/**
 * 空调控制枚举类
 * @author lzs
 * @version v1.0
 */
public enum AirConditioner {

    //增氧
    ADD_OXYGEN("FE 0A 01 0A FF FF 19 0E 04 12"),
    //加湿
    ADD_HUMIDITY("FE 0A 01 0A FF FF 19 0E 01 17"),
    //加热
    HEATING("FE 0A 01 0A FF FF 19 0E 02 14"),
    //制冷
    COOLING(""),
    //抽风
    CONVULSIONS("FE 0A 01 0A FF FF 19 0E 03 15"),
    //睡眠
    SLEEP("FE 0A 01 0A FF FF 19 0E 06 10"),
    //调节温度
    TEMPERATURE("FE 0A 01 0A FF FF ");

    private String cmd;

    public String getCmd() {
        return cmd;
    }

    AirConditioner(String cmd) {
        this.cmd = cmd;
    }


}
