package org.zhl.scs.service.monitoring;

/**
 * 安防监控
 */
public interface IMonitoringService {

    //--------安防监控设备---------

    /**
     * 读取安防监控设备信息（未实现）
     *
     * @return
     */
    Object readMonitoring();

    //--------报警与排险----------

    /**
     * 报警（未实现）
     *
     * @return
     */
    Object police();

    /**
     * 排险（未实现）
     *
     * @return
     */
    Object zone();

    /**
     * 危险请求（未实现）
     * 根据请求类型选择对应的应急方案
     *
     * @return
     */
    Object dangerousRequest(Object request);

}
