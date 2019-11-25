package org.zhl.scs.util.common.devices;

/**
 * 风扇控制枚举类
 * @author lzs
 * @version v1.0
 */
public enum Fan {

    //关
    CLOSE(""),
    //一档
    STEP_ONE(""),
    //两档
    STEP_TWO(""),
    //三档
    STEP_THREE("");

    private String cmd;

    public String getCmd() {
        return cmd;
    }

    Fan(String cmd) {
        this.cmd = cmd;
    }

}
