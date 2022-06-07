package Commands;

import ForCity.City;

import java.util.Comparator;

/**
 * The type Phone code comparator.
 */
public class Phone_code_comparator implements Comparator<City> {
    @Override
    public int compare(City c1, City c2){
        if (c1.getTelephoneCode() == c2.getTelephoneCode()){return 0;}
        if (c1.getTelephoneCode() > c2.getTelephoneCode()){return 1;}
        return -1;
    }
}
