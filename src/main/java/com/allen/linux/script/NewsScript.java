package com.allen.linux.script;

import com.allen.bo.AndroidDriverStatus;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * 包: com.allen.linux.script
 * 源文件:NewsScript.java
 *
 * @author Allen  Copyright 2016 成都创行, Inc. All rights reserved.2018年01月15日
 */
public class NewsScript
{
    private AndroidDriverStatus androidDriverStatus;

    private AndroidDriver driver;

    private String chromeDriverId;

    public NewsScript(AndroidDriverStatus androidDriverStatus)
    {
        this.androidDriverStatus = androidDriverStatus;
        this.driver=androidDriverStatus.getAndroidDriver();
        this.chromeDriverId=androidDriverStatus.getServicePid();
    }


    public void operateProcess(){
        try
        {
            List<WebElement> elements = driver
                    .findElementsById("com.martian.hbnews:id/news_summary_title_tv");//获取对话内容列表

            for(WebElement webElement:elements){
                webElement.click();
                swipeTest();
                driver.findElementByClassName("android.widget.ImageButton").click();
                Thread.sleep(1000);
            }

        }catch (Exception e){}
    }

    public void swipeTest(){
        long startTime=System.currentTimeMillis();
        while (true){
            driver.swipe(100,800,100,200,10);
            long endTime=System.currentTimeMillis();
            if(endTime-startTime > 30000)
                return;
        }
    }

    private boolean operateX5Web() throws InterruptedException, IOException {
        /*try {
            //切换webView
            chromeDriverId = changeWebViewContext();
            return true;
        } catch (Exception e) {
            //切换webview失败,删除chromeDriver
            e.printStackTrace();
            System.out.println("XXXX: clean chrome");
            Thread.currentThread().sleep(2 * 1000);
            Process process2 = Runtime.getRuntime().exec("pstree " + pid + " -p");
            process2.waitFor();
            Scanner in3 = new Scanner(process2.getInputStream());
            while (in3.hasNext()) {
                String processInf = in3.nextLine();
                if (processInf.contains("chromedriver_64")) {
                    String id = processInf.trim().split("chromedriver_64")[1];
                    id = id.split("-\\+-")[0];
                    id = id.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……& ;*（）——+|{}【】‘；：”“’。，、？|-]", "");
                    chromeDriverId = id;
                }
            }
            Thread.currentThread().sleep(3 * 1000);
            if (chromeDriverId != null) {
                if (!chromeDriverId.equals("")) {
                    Process process = Runtime.getRuntime().exec("kill -s 9 " + chromeDriverId);
                    process.waitFor();
                }
                chromeDriverId = "";
                //切换失败回退到聊天页面
                driver.context("NATIVE_APP");
                driver.swipe(60, 100, 60, 100, 10);
                return false;
            }else {
                chromeDriverId = "";
                driver.swipe(60, 100, 60, 100, 10);
                return false;
            }
        }*/
        return false;
    }
}
