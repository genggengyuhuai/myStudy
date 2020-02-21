package netty_study.rpc.client;

import netty_study.rpc.RpcInitFactory;

/**
 * @author lihaoyu
 * @date 2/21/2020 9:56 AM
 */
public class ClientMain {
    public static void main(String[] args) {
        RpcInitFactory initFactory=  new RpcInitFactory("127.0.0.1",8090);
        Idemo demo = new DemoRemoteImpl(new CommonClient(initFactory));
        System.out.println(demo.add(2, 1));
    }
}
