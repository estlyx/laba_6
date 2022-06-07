package Commands;

import ForCity.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Fill collection.
 *
 */
public class FillCollection implements AnyCommand{
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String execute(Object fileName) throws IOException {
        CityCollection cityCollection = new CityCollection();
        /*char c;
        InputStreamReader sr = new InputStreamReader(new FileInputStream("D:\\test.txt"));
        c = (char)sr.read();
        String[] strArr = new String[5];
        while (c!='.'){
            System.out.println(c);
            c=(char)sr.read();
        }*/
        try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream((String) fileName)));
                StringBuffer buffer = new StringBuffer();
                CityCollection collection = new CityCollection();
                while (reader.ready()) {
                    City city = new City();
                    String a = reader.readLine();
                    String[] words = a.split(";");
                    city.setId(Integer.parseInt(words[0]));
                    city.setName(words[1]);
                    Coordinates coordinates = new Coordinates();
                    coordinates.setX(Integer.parseInt(words[2]));
                    coordinates.setY(Integer.parseInt(words[3]));
                    city.setCoordinates(coordinates);
                    city.setCreationDate(LocalDate.parse(words[4]));
                    city.setAreaSize(Long.parseLong(words[5]));
                    city.setPopulation(Long.parseLong(words[6]));
                    city.setMetersAboveSeaLevel(Float.parseFloat(words[7]));
                    city.setEstablishmentDate(LocalDate.parse(words[8]));
                    city.setTelephoneCode(Integer.parseInt(words[9]));
                    city.setGovernment(Government.valueOf(words[10]));
                    Human governor = new Human();
                    governor.setHeight(Integer.parseInt(words[11]));
                    city.setGovernor(governor);
                    collection.add(city);
                }

        } catch (java.util.InputMismatchException | NumberFormatException e) {
            System.out.println("Файл не сущствует");
            exit(123);
        }

        return "Коллекция заполнена элементами из файла";
    }
    @Override
    public String getName(){return "FillCollection";}

}
