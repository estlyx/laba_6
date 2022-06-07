import Commands.*;
import ForCity.City;
import ForCity.CityCollection;
import Tools.CityCreater;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class ServConnection {
    private SocketAddress addr;
    private int port;
    private CityCollection citycollection;
    private Commands commands = new Commands();
    public ServConnection(int port, CityCollection citycollection, String filewithcollection) throws IOException {
        this.port = port;
        this.citycollection = citycollection;
        this.addr = new InetSocketAddress(port);
        commands.regist(new Add(), new AveragePhoneCode(), new Clear(), new ExecuteScript(), new Exit(), new FillCollection(), new Help(),
                new Info(), new PrintAscendingPhone(), new Remove(), new Remove_at(), new Reorder(), new Save(), new Show(), new Shuffle(),
                new Update(), new PrintDescendingMeters());
        commands.getCommand("FillCollection").execute(filewithcollection);
        NameSort.execute();
    }

    public void SetCollection(String[] args){

    }
    public void go() throws IOException, ClassNotFoundException {
        /*Scanner sc = new Scanner(System.in);
        DatagramChannel dc;
        dc = DatagramChannel.open();
        dc.bind(addr);*/

        DatagramSocket ds = new DatagramSocket(port);
        while (true) {
            byte[] ars = new byte[4096];
            DatagramPacket dpr = new DatagramPacket(ars, ars.length);
            ds.receive(dpr);
            int port2 = dpr.getPort();
            InetAddress host2 = dpr.getAddress();
            ByteArrayInputStream bis = new ByteArrayInputStream(ars);
            ObjectInputStream oin = new ObjectInputStream(bis);
            Message ms = (Message) oin.readObject();
            //System.out.println(ms.getCommand());

            Message msout;
            if (ms.getCity() != null) {
                msout = new Message("Город успешно добавлен.");
                citycollection.add(ms.getCity());
            } else if (ms.getArg() != null) {
                msout = new Message(commands.getCommand(ms.getCommand()).execute(ms.getArg()));
                //System.out.println(commands.getCommand(ms.getCommand()).execute(ms.getArg()));
            } else {
                if (ms.getCommand().equals("exit")){
                    commands.getCommand("save").execute("null");
                    msout = new Message("Завершаю работу.");
                }
                else{
                    msout = new Message(commands.getCommand(ms.getCommand()).execute("null"));
                }
                //System.out.println(commands.getCommand(ms.getCommand()).execute("null"));
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(msout);
            byte[] arr = baos.toByteArray();
            DatagramPacket dps = new DatagramPacket(arr, arr.length, host2, port2);
            ds.send(dps);




            /*
            byte arr[] = new byte[4096];

            int len = arr.length;

            ByteBuffer buf;
            buf = ByteBuffer.wrap(arr);
            addr = dc.receive(buf);

            ByteArrayInputStream bis = new ByteArrayInputStream(arr);
            ObjectInputStream oin = new ObjectInputStream(bis);
            Message ms = (Message) oin.readObject();

            Message msout;
            if (ms.getCity() != null) {
                msout = new Message("Город успешно добавлен.");
                citycollection.add(ms.getCity());
            } else if (ms.getArg() != null) {
                msout = new Message(commands.getCommand(ms.getCommand()).execute(ms.getArg()));
                //System.out.println(commands.getCommand(ms.getCommand()).execute(ms.getArg()));
            } else {
                msout = new Message(commands.getCommand(ms.getCommand()).execute("null"));
                //System.out.println(commands.getCommand(ms.getCommand()).execute("null"));
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(msout);
            arr = baos.toByteArray();
            buf = ByteBuffer.wrap(arr);
            dc.send(buf, addr);*/
        }
    }
}
