package com.sheepxi.datasource;


import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * @author: 喜🐑
 * @create: 2018-12-04 16:39
 * 动态数据源定时器管理，长时间无访问的数据库连接关闭
 */

public class DDSTimer {

    /**
     * 空闲时间周期，超过这个市长没有访问的数据库连接将被释放。
     * 默认为10分钟
     */
    private static long idlePeriodTime = 10 * 60 * 1000;

    /**
     * 动态数据源
     */
    private DataSource dds;

    /**
     * 上一次访问的时间
     */
    private long lastUseTime;

    public DDSTimer(DataSource ds){
        this.dds = dds;
        this.lastUseTime = System.currentTimeMillis();
    }

    /**
     * 更新最近访问时间
     */
    public void refreshTime(){
        lastUseTime = System.currentTimeMillis();
    }

    /**
     * 检测数据连接是否超时
     * true 超时 false 未超时
     * @return
     */
    public boolean checkAndClose(){
        if(System.currentTimeMillis()-lastUseTime>idlePeriodTime){
            dds.close();
            return true;
        }
        return false;
    }

    public DataSource getDds(){
        return dds;
    }
}
