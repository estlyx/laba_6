package Commands;

import ForCity.CityCollection;
import Tools.CityCreater;

/**
 * The type Add.
 */

public class Add implements CommandWithNoArg{
    @Override
    public String execute(Object o) {
        CityCollection collection = new CityCollection();
        collection.add(new CityCreater().create("don't know"));
        return ("Город успешно добавлен.");
    }

    @Override
    public String getName() {
        return "add";
    }
}
