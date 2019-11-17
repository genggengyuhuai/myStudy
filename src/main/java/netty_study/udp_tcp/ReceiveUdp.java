package netty_study.udp_tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author lihaoyu
 * @date 2019/11/14 21:32
 */
public class ReceiveUdp {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);

        byte[] receiveBytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(receiveBytes,receiveBytes.length);
        while(true){
            socket.receive(packet);
            String res = new String(packet.getData(),0,packet.getLength());
            System.out.println("我收到了：  "+res);
            if("exit".equals(res)){
                break;
            }
        }

    }
}
