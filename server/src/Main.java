import ForCity.CityCollection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServConnection serv = new ServConnection(1338, new CityCollection(), args[0]);
        serv.go();
        /*byte arr[] = new byte[10];
        int len = arr.length;
        DatagramSocket ds; DatagramPacket dp;
        InetAddress host = InetAddress.getLocalHost(); int port = 1337;
        ds = new DatagramSocket(port);
        dp = new DatagramPacket(arr,len);
        ds.receive(dp);
        for (int j = 0; j < len; j++) {
            //System.out.println(arr[j]);
            arr[j] *= 1;
        }
        host = dp.getAddress();
        port = dp.getPort();
        dp = new DatagramPacket(arr,len,host,port);
        ds.send(dp);*/
    }
}