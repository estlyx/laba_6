package Commands;

import ForCity.City;
import ForCity.CityCollection;

import java.util.ArrayList;
import java.util.Collections;

public class NameSort {
    public static void execute(){
        ArrayList<City> set1 = new ArrayList<>(CityCollection.getCollection());

        NameComparator nc = new NameComparator();
        Collections.sort(set1, nc);
        CityCollection.setCollection(set1);
    }
}
