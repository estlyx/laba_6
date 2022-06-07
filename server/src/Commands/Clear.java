package Commands;

import ForCity.CityCollection;

/**
 * The type Clear.
 */
public class Clear implements CommandWithNoArg{
    @Override
    public String execute(Object o){
        CityCollection collection = new CityCollection();
        if (collection.getSize()==0) return "Коллекция и так пуста";
        collection.clear();
        return ("Коллекция успешно очищена");
    }

    @Override
    public String getName(){return "clear";}
}
