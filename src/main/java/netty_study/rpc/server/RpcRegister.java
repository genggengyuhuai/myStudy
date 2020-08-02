package netty_study.rpc.server;

import java.util.HashMap;

/**
 * 服务发现
 * 这里利用一个map存提供服务的实例，后续再在服务端只需要通过接口就可以查找到对应的实现类。
 * @author lihaoyu
 * @date 2/21/2020 9:18 AM
 */

public class RpcRegister {
    /**存储注册的服务提供实现类*/
    private HashMap<String, Object> registMap = new HashMap<>();
    private  static  RpcRegister register=new RpcRegister();
    public static  RpcRegister buildRegist(){
        return register;
    }
    public RpcRegister regist(String interfaceName,Object obj){
        registMap.put(interfaceName,obj);
        return this;
    }
    public Object findServier(String interfaceName){
        return  registMap.get(interfaceName);
    }
}