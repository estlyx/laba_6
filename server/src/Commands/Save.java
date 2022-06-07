package Commands;

import ForCity.City;
import ForCity.CityCollection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * The type Save.
 */
public class Save implements CommandWithNoArg{
    @Override
    public String execute(Object o){
        String outputFileName = "file.txt";
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName, false))) {
            writter.write("");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        CityCollection cityCollection = new CityCollection();
        ArrayList<City> collection = cityCollection.getCollection();
        for (City city : collection){
            String[] array = new String[12];
            array[0] = valueOf(city.getId());
            array[1] = city.getName();
            array[2] = valueOf(city.getCoordinates().getX());
            array[3] = valueOf(city.getCoordinates().getY());
            array[4] = valueOf(city.getCreationDate());
            array[5] = valueOf(city.getAreaSize());
            array[6] = valueOf(city.getPopulation());
            array[7] = valueOf(city.getMetersAboveSeaLevel());
            array[8] = valueOf(city.getEstablishmentDate());
            array[9] = valueOf(city.getTelephoneCode());
            array[10] = valueOf(city.getGovernment());
            array[11] = valueOf(city.getGovernor().getHeight());
            try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName, true))) {
                for (String value : array) {
                    writter.write(value + ";");
                }
                writter.write("\n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Коллекция сохранена в файл '" + outputFileName+"'";
    }

    @Override
    public String getName(){return "save";}
}
