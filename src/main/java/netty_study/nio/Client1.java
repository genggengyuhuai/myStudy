package netty_study.nio;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author lihaoyu
 * @date 2019/11/15 20:13
 */
public class Client1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(new String(new byte[]{97,97,13,10}));
        Socket socket = new Socket("localhost",12345);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        pw.println("aa");
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer));

        socket.close();

    }
}
