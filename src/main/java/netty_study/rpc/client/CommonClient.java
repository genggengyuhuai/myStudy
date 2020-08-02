package netty_study.rpc.client;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import netty_study.rpc.RpcConstant;
import netty_study.rpc.RpcInitFactory;
import netty_study.rpc.RpcResponse;
import netty_study.rpc.RpcRquest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.UUID;

/**
 * 通用客户端
 * @author lihaoyu
 * @date 2/21/2020 9:52 AM
 */
@Data
public  class CommonClient {
    private RpcInitFactory factory;

    public CommonClient(RpcInitFactory factory) {
        this.factory = factory;
    }

    public <T> T invoke(RpcRquest req) {
        RpcResponse response = null;
        req.setRequestId(UUID.randomUUID().toString());
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(factory.getIp(), factory.getPort()));
            ByteBuffer buf1 = ByteBuffer.allocate(2048);
            buf1.put(JSONObject.toJSON(req).toString().getBytes());
            buf1.put(RpcConstant.PROTOCOL_END.getBytes());
            buf1.flip();
            if (buf1.hasRemaining())
                socketChannel.write(buf1);
            buf1.clear();

            // 这里有个疑问， req  写入 channel 之后，什么时候进行的处理？

            ByteBuffer body = ByteBuffer.allocate(2048);
            socketChannel.read(body);
            body.flip();
            if (body.hasRemaining()) {
                response = JSONObject.parseObject(new String(body.array()), RpcResponse.class);
            }
            body.clear();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) response;
    }
    }