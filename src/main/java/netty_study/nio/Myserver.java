package netty_study.nio;

import com.google.common.primitives.Bytes;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2019/11/15 19:50
 */
public class Myserver {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(12345));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            System.out.println("111");
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (!key.isValid()) {
                    continue;
                }
                if (key.isAcceptable())//代码①
                {
                    System.out.println("接受连接");
                    //这里的channel和上文的serverSocketChannel是相同对象
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = channel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable())//代码②
                {
                    ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    int read = clientChannel.read(buffer);
                    if (read == -1)//关闭分支
                    {
                        //通道连接关闭，可以取消这个注册键，后续不在触发。
                        System.out.println("关闭连接");
                        key.cancel();
                        clientChannel.close();
                    } else//读写分支
                    {
                        System.out.println("read and write");
                        System.out.println(read +"  "+ new String(buffer.array()));
                        buffer.flip();
                        clientChannel.write(buffer);
                    }
                }
                iterator.remove();
            }
        }
    }
}