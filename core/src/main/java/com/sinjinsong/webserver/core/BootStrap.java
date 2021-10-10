package com.sinjinsong.webserver.core;

import com.sinjinsong.webserver.core.network.endpoint.Endpoint;
import com.sinjinsong.webserver.core.util.PropertyUtil;

import java.util.Scanner;

/**
 * @author sinjinsong
 * @date 2018/3/6
 */
public class BootStrap {

    /**
     * 服务器启动入口
     * 用户程序与服务器的接口
     */
    public static void run() {
        // TODO 从配置文件中读取端口号
        String port = PropertyUtil.getProperty("server.port");


        if(port == null) {
            throw new IllegalArgumentException("server.port 不存在");
        }
        // TODO 从配置文件中获取连接方式的字段
        String connector = PropertyUtil.getProperty("server.connector");

        if(connector == null || (!connector.equalsIgnoreCase("bio") && !connector.equalsIgnoreCase("nio") && !connector.equalsIgnoreCase("aio"))) {
            throw new IllegalArgumentException("server.network 不存在或不符合规范");
        }

        // TODO 根据传入的配置获取服务器实例
        Endpoint server = Endpoint.getInstance(connector);
        server.start(Integer.parseInt(port));
        Scanner scanner = new Scanner(System.in);
        String order;
        while (scanner.hasNext()) {
            order = scanner.next();
            if (order.equals("EXIT")) {
                server.close();
                System.exit(0);
            }
        }
    }
}
