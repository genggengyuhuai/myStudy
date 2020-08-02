package netty_study.rpc;

import lombok.Data;

/**
 * 初始化工厂类
 * @author lihaoyu
 * @date 2/21/2020 9:51 AM
 */
@Data
public class RpcInitFactory {
    /**
     * 客户端连接远程ip地址
     **/
    private String ip;
    /***远程端口*/
    private int port;


    public RpcInitFactory(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}