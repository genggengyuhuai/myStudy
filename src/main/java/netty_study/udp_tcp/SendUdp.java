package netty_study.udp_tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/14 21:28
 */
public class SendUdp {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String nextLine = scanner.nextLine();
            InetAddress ip = InetAddress.getByName("localhost");
            byte[] bytes = nextLine.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length,ip,12345);
            socket.send(packet);
            if("exit".equals(nextLine)){
                break;
            }
        }
    }
}
