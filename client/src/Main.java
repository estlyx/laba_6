import Commands.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        InetAddress host = InetAddress.getLocalHost();
        int port=1338;
        ClientTools cc = new ClientTools(in, host, port);
        cc.go();
        /*
        byte arr[] = {0,1,2,3,4,5,6,7,8,9};
        int len = arr.length;
        DatagramChannel dc; ByteBuffer buf;
        SocketAddress addr;
        addr = new InetSocketAddress(host,port);
        dc = DatagramChannel.open();
        buf = ByteBuffer.wrap(arr);
        dc.send(buf, addr);
        buf.clear();
        addr = dc.receive(buf);
        for (byte j : arr) {
            System.out.println(j);
        }*/

    }
}
