import Commands.CommandWithNoArg;
import ForCity.*;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class ClientTools {
    Scanner in;
    InetAddress host;
    int port;
    Message ms;
    public ClientTools(Scanner in, InetAddress host, int port){
        this.in = in;
        this.host = host;
        this.port = port;
    }




    public void setName(City city){
        System.out.println("Введите имя города.");
        System.out.print("~ ");
        String name = in.nextLine();
        if (name.equals("") || name.equals("null")) {
            this.setName(city);
        } else city.setName(name);
    }

    /**
     * Sets coordinate x.
     *
     * @param coords the coords
     */
    public void setCoordinateX(Coordinates coords) {
        try {
            System.out.println("Введите координату x:");
            System.out.print("~ ");
            String x = in.nextLine();
            if (x.equals("") || x.equals(null)) this.setCoordinateX(coords);
            else {
                int xn = Integer.parseInt(x);
                if (xn > -400) {
                    coords.setX(xn);
                } else {
                    System.out.println("Минимальное значение поля: -400");
                    this.setCoordinateX(coords);
                }
                coords.setX(xn);
            }
        } catch (java.util.InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Значение должно быть типа:\"integer\".");
            this.setCoordinateX(coords);
        }
    }

    /**
     * Sets coordinate y.
     *
     * @param coords the coords
     */
    public void setCoordinateY(Coordinates coords) {
        try {
            System.out.println("Введите координату y:");
            System.out.print("~ ");
            String y = in.nextLine();
            if (y.equals("") || y.equals(null)) this.setCoordinateY(coords);
            else {
                int xn = Integer.parseInt(y);
                coords.setY(xn);
            }
        } catch (java.util.InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"integer\".");
            this.setCoordinateY(coords);
        }
    }

    /**
     * Sets area size.
     *
     * @param city the city
     */
    public void setAreaSize(City city) {
        try {
            System.out.println("Введите площадь города:");
            System.out.print("~ ");
            String x = in.nextLine();
            int xn = Integer.parseInt(x);
            if (xn<=0) {
                System.out.println("Значение поля должно быть больше 0,попробуйте ещё раз.");
                this.setAreaSize(city);
            }
            else city.setAreaSize(xn);
        } catch (java.util.InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"integer\".");
            this.setAreaSize(city);
        }
    }

    /**
     * Sets population size.
     *
     * @param city the city
     */
    public void setPopulation(City city) {
        try {
            System.out.println("Введите число жителей города:");
            System.out.print("~ ");
            String x = in.nextLine();
            int xn = Integer.parseInt(x);
            if (xn<=0) {
                System.out.println("Значение поля должно быть больше 0,попробуйте ещё раз.");
                this.setAreaSize(city);
            }
            else city.setAreaSize(xn);
        } catch (java.util.InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"integer\".");
            this.setAreaSize(city);
        }
    }

    /**
     * Sets meters above sea level.
     *
     * @param city the city
     */
    public void setMetersAboveSeaLevel(City city) {
        try {
            System.out.println("Введите уровень города над морем:");
            System.out.print("~ ");
            String x = in.nextLine();
            float xn = Float.parseFloat(x);
            city.setMetersAboveSeaLevel(xn);
        } catch (java.util.InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"float\".");
            this.setAreaSize(city);
        }
    }

    /**
     * Sets establishment date.
     *
     * @param city the city
     */
    public void setEstablishmentDate(City city) {
        try {
            System.out.println("Введите дату учреждения города:");
            System.out.print("~ ");
            String x = in.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            java.time.LocalDate xn = java.time.LocalDate.parse(x, formatter);
            city.setEstablishmentDate(xn);
        } catch (java.util.InputMismatchException | DateTimeParseException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"LocalDate(yyyy-mm-dd)\".");
            this.setEstablishmentDate(city);
        }
    }

    /**
     * Sets telephone code.
     *
     * @param city the city
     */
    public void setTelephoneCode(City city) {
        try {
            System.out.println("Введите телефонный код:");
            System.out.print("~ ");
            String x = in.nextLine();
            int xn = Integer.parseInt(x);
            if (xn < 10000) {
                city.setTelephoneCode(xn);
            } else {
                System.out.println("Максимальное значение поля: 10000");
                this.setTelephoneCode(city);
            }
            city.setTelephoneCode(xn);
        } catch (java.util.InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Значение должно быть типа:\"integer\".");
            this.setTelephoneCode(city);
        }
    }

    /**
     * Sets government.
     *
     * @param city the city
     */
    public void setGovernment(City city){
        try {
            System.out.println("Введите власти города:ARISTOCRACY или GERONTOCRACY или THEOCRACY");
            System.out.print("~ ");
            String x = in.nextLine();
            if (!x.equals("")){
                Government xn = Government.valueOf(x);
                city.setGovernment(xn);
            }
        } catch (java.util.InputMismatchException | IllegalArgumentException e) {
            System.out.println("Значение должно быть типа:\"Government\".");
            this.setGovernment(city);
        }
    }

    /**
     * Sets governor.
     *
     * @param city the city
     */
    public void setGovernor(City city){
        try {
            System.out.println("Введите рост губернатора:");
            System.out.print("~ ");
            String x = in.nextLine();
            if (!x.equals("")){
                int xn = Integer.parseInt(x);
                if (xn<=0) {
                    System.out.println("Значение поля должно быть больше 0,попробуйте ещё раз.");
                    this.setGovernor(city);
                }
                else {
                    Human h = new Human();
                    h.setHeight(xn);
                    city.setGovernor(h);
                }}
        } catch (java.util.InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"integer\".");
            this.setGovernor(city);
        }
    }


    public void go() throws IOException, ClassNotFoundException {
        while (true) {
            Boolean f = true;
            String commandName = in.nextLine();
            String[] nameAndArgument = commandName.trim().split(" ");
            commandName = nameAndArgument[0];
            if (commandName.equals("add")){
                City city = new City();
                city.setId((int) CityCollection.getFreeId());
                city.setCreationDate(java.time.LocalDate.now());
                this.setName(city);
                Coordinates coordinates = new Coordinates();
                this.setCoordinateX(coordinates);
                this.setCoordinateY(coordinates);
                city.setCoordinates(coordinates);
                this.setAreaSize(city);
                this.setPopulation(city);
                this.setMetersAboveSeaLevel(city);
                this.setEstablishmentDate(city);
                this.setTelephoneCode(city);
                this.setGovernment(city);
                this.setGovernor(city);
                ms = new Message(commandName, city);
            }
            else if(commandName.equals("help") || commandName.equals("info") || commandName.equals("show") || commandName.equals("clear") ||
                    commandName.equals("exit") || commandName.equals("shuffle") || commandName.equals("reorder") || commandName.equals("average_of_telephone_code") ||
                    commandName.equals("print_field_ascending_telephone_code")){
                ms = new Message(commandName);
            }
            else if (nameAndArgument.length == 2){
                ms = new Message(commandName, nameAndArgument[1]);
            }
            else{
                f = false;
                System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
            }
            if (f){
            send(ms);
            }

        }
    }
    public void send(Message ms) throws IOException, ClassNotFoundException {
        //System.out.println(ms.getCommand());
        ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(ms);
        byte arr[] = baos.toByteArray();
        SocketAddress addr;
        addr = new InetSocketAddress(host,port);
        DatagramChannel dc;
        dc = DatagramChannel.open();
        ByteBuffer buf = ByteBuffer.wrap(arr);
        dc.send(buf, addr);

        arr = new byte[4096];
        int len = arr.length;
        buf = ByteBuffer.wrap(arr);
        addr = dc.receive(buf);
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        ObjectInputStream oin = new ObjectInputStream(bis);
        ms = (Message) oin.readObject();
        if (ms.getCommand().equals("Завершаю работу.")){
            System.out.println("Завершаю работу.");
            System.exit(0);
        }
        else{
            System.out.println(ms.getCommand());
        }
    }
}
