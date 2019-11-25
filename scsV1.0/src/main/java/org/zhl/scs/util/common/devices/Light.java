package org.zhl.scs.util.common.devices;

/**
 * 灯光控制枚举类
 * @author lzs
 * @version v1.0
 */
public enum Light {

    //开
    ON(""),
    //换
    OFF(""),
    //增加亮度
    ADD(""),
    //减少亮度
    REDUCE("");

    private String cmd;

    public String getCmd() {
        return cmd;
    }

    Light(String cmd) {
        this.cmd = cmd;
    }

}
