package netty_study.unix_io;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author lihaoyu
 * @date 2019/11/14 20:56
 */
public class IOTest1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(12345));
        InputStream inputStream = socket.getInputStream();
        byte[]      content     = new byte[128];
        int         bytesOfRead = inputStream.read(content);
    }
}
