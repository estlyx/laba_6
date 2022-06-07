package Commands;

import ForCity.CityCollection;

import java.util.Collections;

/**
 * The type Shuffle.
 */
public class Shuffle implements CommandWithNoArg{
    @Override
    public String execute(Object o){
        Collections.shuffle(CityCollection.getCollection());
        return "Коллекция отсортирована в случайном порядке";
    }

    @Override
    public String getName(){return "shuffle";}
}
