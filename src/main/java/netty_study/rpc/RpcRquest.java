package netty_study.rpc;

import lombok.Data;

/**
 * 请求实体类
 * @author lihaoyu
 * @date 2/21/2020 9:14 AM
 */

@Data
public class RpcRquest {
    /**请求id*/
    private String requestId;
    /**请求接口名*/
    private String interfaceName;
    /**服务版本**/
    private String serviceVersion;
    /**方法名*/
    private String methodName;
    /**参数类型*/
    private Class<?>[] parameterTypes;
    /**参数*/
    private Object[] parameters;
}