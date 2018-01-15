package com.allen.task;

import com.allen.bo.AndroidDriverStatus;
import com.allen.driver.DriverManager;
import com.allen.linux.script.NewsScript;

/**
 * 包: com.allen.task
 * 源文件:NewsTask.java
 *
 * @author Allen  Copyright 2016 成都创行, Inc. All rights reserved.2018年01月15日
 */
public class NewsTask
{
    private DriverManager driverManager;

    private AndroidDriverStatus androidDriverStatus;

    public void excute(){

        driverManager = DriverManager.getInstance();
        androidDriverStatus = driverManager.getEnableDriver();
        if (androidDriverStatus == null) {
            System.out.println("XXXX: location_mcss : 没有可用设备");
            return;
        }
        NewsScript newsScript = new NewsScript(androidDriverStatus);

        try {

            //广告页等待5秒
            Thread.sleep(5000);

            newsScript.operateProcess();
            //释放设备
            boolean isRelease = driverManager.releaseDriver(androidDriverStatus.getDeviceName());
            if (!isRelease) {
                System.out.println("XXXX: 回收设备失败");
            }
        } catch (Exception e) {
            //所有抓取中没有哦处理到的异常
            //删除该appium server,清楚残余adb ,chromeDriver
            System.out.println("XXXX: location_mcss : all error: " + e.toString());
            boolean isKill = driverManager.stopAppium(androidDriverStatus);
            if (isKill) {
                //处理DriverManager.driverList设备状态
                //重启该id,db的appium server
                //driverManager.restartDriver(androidDriverStatus.getDeviceName());
            }
        }
    }
}
