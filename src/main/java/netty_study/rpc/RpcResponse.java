package netty_study.rpc;

import lombok.Data;

/**
 * 返回实体类
 * @author lihaoyu
 * @date 2/21/2020 9:18 AM
 */

@Data
public class RpcResponse {
    /**请求流水号*/
    private String requestId;
    /**异常*/
    private Exception exception;
    /**返回结果**/
    private Object result;
}