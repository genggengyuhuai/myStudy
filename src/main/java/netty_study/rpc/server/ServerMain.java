package netty_study.rpc.server;

import netty_study.rpc.client.Idemo;

/**
 * @author lihaoyu
 * @date 2/21/2020 10:13 AM
 */
public class ServerMain {
    public static void main(String[] args) {
        ProviderServer server = new ProviderServer(8090);
        RpcRegister.buildRegist().regist(Idemo.class.getName(), new DemoImp());
        new Thread(server).start();
    }
}
