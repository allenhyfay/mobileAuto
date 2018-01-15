package com.allen.web.controller;

import com.allen.task.NewsTask;
import com.jeeframework.testframework.AbstractSpringBaseControllerTest;
import org.junit.Test;

/**
 * 包: com.allen.web.controller
 * 源文件:MyDriverManagerTest.java
 *
 * @author Allen  Copyright 2016 成都创行, Inc. All rights reserved.2018年01月15日
 */
public class MyDriverManagerTest extends AbstractSpringBaseControllerTest
{
    @Test
    public void ManagerTest(){
        NewsTask task=new NewsTask();
        task.excute();
    }
}
