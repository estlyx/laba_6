package Commands;

import ForCity.City;
import ForCity.CityCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * The type Print descending meters above sea level.
 */
public class PrintDescendingMeters implements CommandWithNoArg{
    @Override
    public String execute(Object o){
        StringBuilder result=new StringBuilder("---------------------------\n");
        CityCollection collection = new CityCollection();
        if (collection.getSize() == 0) return ("Коллекция пуста");
        else {
            System.out.println("Элементы в порядке возрастания телефонного кода:");
            ArrayList<City> set1 = new ArrayList<>(CityCollection.getCollection());
            Meters_comparator mc = new Meters_comparator();
            Collections.sort(set1, mc);
            set1.stream().forEachOrdered(x->result.append(x.getMetersAboveSeaLevel()).append("\n---------------------------\n"));
            return result.toString();

        }

    }

    @Override
    public String getName(){return "print_field_ascending_telephone_code";}
}
