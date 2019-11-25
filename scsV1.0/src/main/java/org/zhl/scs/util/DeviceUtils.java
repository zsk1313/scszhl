package org.zhl.scs.util;

/**
 * 设备工具类，16进制转换等
 * @author lzs
 * @version 1.0
 */
public class DeviceUtils {

    /**
     * 把指定的字符串转换成byte数组
     * @param order 需要转换的字符串
     * @return 返回转换后的byte数组
     */
    public static byte[] stringToByte(String order) {
        // 去除空格(FE 08 01 0C FF FF 01 XX)
        order = order.replaceAll(" ", "");
        // 定义一个字节数组，保存解析后的字节数据
        byte[] buf = new byte[order.length() / 2];
        int index = 0; //数组下标
        // 循环遍历字符串，每次循环获取两个字符
        for (int i = 0; i < order.length(); i += 2) {
            // 根据下标获取字符串中每一个字符
            String hexString = order.substring(i, i + 2);
            // 把字符解析成字节数据
            int hexVal = Integer.parseInt(hexString, 16);
            // 把字节数据保存在数组buf里面
            buf[index] = (byte) hexVal;
            index++;
        }
        return buf;
    }

    /**
     * 把字节数转换成16进制的字符串
     * @param b 字节数组
     * @return 返回该字节数组对应的字符串
     */
    public static String printHexString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.substring(0, sb.length());
    }

}
