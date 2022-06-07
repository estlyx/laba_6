package Commands;

import ForCity.City;

import java.util.Comparator;

/**
 * The type Meters comparator.
 */
public class Meters_comparator implements Comparator<City> {
    @Override
    public int compare(City c1, City c2){
        if (c1.getMetersAboveSeaLevel() == c2.getMetersAboveSeaLevel()){return 0;}
        if (c1.getMetersAboveSeaLevel() < c2.getMetersAboveSeaLevel()){return 1;}
        return -1;
    }
}
