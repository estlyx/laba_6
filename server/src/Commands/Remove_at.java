package Commands;

import ForCity.City;
import ForCity.CityCollection;

import java.util.Iterator;

/**
 * The type Remove at index.
 */
public class Remove_at implements AnyCommand{
    @Override
    public String execute(Object o){
        try{
            CityCollection collection = new CityCollection();
            if (collection.getSize()==0) return("Коллекция пуста");
            else{
                boolean isRemoved = false;
                int numtodel = 0;
                try {
                    numtodel = Integer.parseInt((String) o);
                } catch (NumberFormatException exp) {
                    return "Неверно указан аргумент.";
                }

                Iterator<City> it = (Iterator<City>) CityCollection.getCollection().iterator();
                int num = 0;
                while (it.hasNext()) {
                    City city = (City) it.next();
                    if (numtodel == num) {
                        it.remove();
                        isRemoved = true;
                        return ("Город успешно удален.");
                    }
                    num+=1;
                }
                if (!isRemoved) return ("Элемента с таким номером не существует.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getName(){return "remove_at";}
}
