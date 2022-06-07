package Commands;

import ForCity.City;

import java.util.Comparator;

public class NameComparator implements Comparator <City> {
    @Override
    public int compare(City c1, City c2){
        if (c1.getName() == c2.getName()){return 0;}
        if (c1.getName().length() > c2.getName().length()){return 1;}
        return -1;
    }
}
