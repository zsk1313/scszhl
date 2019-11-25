package org.zhl.scs.util.common.devices;

/**
 * 窗帘控制枚举类
 * @author lzs
 * @version v1.0
 */
public enum Curtain {

    //关
    CLOSE(""),
    //拉一半
    HALF(""),
    //拉满
    FULL("");

    private String cmd;

    public String getCmd() {
        return cmd;
    }

    Curtain(String cmd) {
        this.cmd = cmd;
    }

}
