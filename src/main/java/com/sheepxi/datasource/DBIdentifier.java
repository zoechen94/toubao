package com.sheepxi.datasource;

/**
 * @author: 喜🐑
 * @create: 2018-12-04 15:51
 * 数据库标识管理类。用于区分数据源链接的不同数据库
 */

public class DBIdentifier {

    /**
     * 用不同的工程编码来区分数据库
     */
    private static ThreadLocal<String> projectCode = new ThreadLocal<String>();

    public static String getProjetCode(){
        return projectCode.get();
    }

    public static void setProjectCode(String code){
        projectCode.set(code);
    }
}
