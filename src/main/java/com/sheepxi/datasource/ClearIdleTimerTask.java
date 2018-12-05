package com.sheepxi.datasource;

import java.util.TimerTask;

/**
 * @author: 喜🐑
 * @create: 2018-12-04 16:59
 * 清除空闲连接任务
 */

public class ClearIdleTimerTask extends TimerTask {
    public void run() {
       DDSHolder.instance().clearIdleDDS();
    }
}
