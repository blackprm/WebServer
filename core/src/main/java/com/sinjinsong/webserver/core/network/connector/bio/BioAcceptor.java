package com.sinjinsong.webserver.core.network.connector.bio;

import com.sinjinsong.webserver.core.network.dispatcher.bio.BioDispatcher;
import com.sinjinsong.webserver.core.network.endpoint.bio.BioEndpoint;
import com.sinjinsong.webserver.core.network.wrapper.bio.BioSocketWrapper;
import com.sinjinsong.webserver.core.util.LogUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

/**
 * @author sinjinsong
 * @date 2018/5/4
 */
@Slf4j
public class BioAcceptor implements Runnable {

    // 拥有Server
    private BioEndpoint server;
    // 拥有Dispatcher
    private BioDispatcher dispatcher;

    public BioAcceptor(BioEndpoint server,BioDispatcher dispatcher) {
        this.server = server;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        LogUtil.log.info("开始监听");
        // TODO 开启一个线程去监听服务端连接
        while (server.isRunning()) {
            Socket client;
            try {
                //TCP的短连接，请求处理完即关闭
                client = server.accept();
                LogUtil.log.info("client:{}", client);
                dispatcher.doDispatch(new BioSocketWrapper(client));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
