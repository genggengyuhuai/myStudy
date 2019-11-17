package netty_study.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author lihaoyu
 * @date 2019/11/15 20:13
 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",12345);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        pw.println("hello");

    }
}
