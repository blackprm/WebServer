package com.sinjinsong.webserver.core.network.endpoint;

import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * TODO 一个抽象类 ：可以代表三种不同I/O类型的服务器实现，BIO,NIO,AIO
 *
 */
public abstract class Endpoint {
    /**
     * 启动服务器
     * @param port
     */
    public abstract void start(int port);

    /**
     * 关闭服务器
     */
    public abstract void close();

    /**
     * TODO 根据配置文件中的connector参数实例化具体的服务器类型
     * @param connector
     * @return
     */
    public static Endpoint getInstance(String connector) {
        StringBuilder sb = new StringBuilder();
        // TODO 反射的方式
        sb.append("com.sinjinsong.webserver.core.network.endpoint")
                .append(".")
                .append(connector)
                .append(".")
                .append(StringUtils.capitalize(connector))
                .append("Endpoint");
        try {
            return (Endpoint) Class.forName(sb.toString()).getDeclaredConstructor().newInstance();

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException(connector);
    }
}
