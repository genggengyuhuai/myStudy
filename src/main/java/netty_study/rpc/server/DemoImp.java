package netty_study.rpc.server;

import netty_study.rpc.client.Idemo;

/**
 * 服务端接口实现类
 * @author lihaoyu
 * @date 2/21/2020 9:55 AM
 */

public class DemoImp implements Idemo{
    @Override
    public Integer add(Integer i, Integer j) {
        return i+j;
    }
}