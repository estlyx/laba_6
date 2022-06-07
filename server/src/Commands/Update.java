package Commands;

import ForCity.City;
import ForCity.CityCollection;
import Tools.CityCreater;

/**
 * The type Update.
 */
public class Update implements AnyCommand{
    /**
     * @param o the id
     */
    @Override
    public String execute(Object o) {
        CityCollection collection = new CityCollection();
        try {
            if (collection.isIndexBusy(Integer.parseInt((String) o))) {
                int id=Integer.parseInt((String) o);
                City updCity = collection.getCollection().stream().filter(x->x.getId()==id).findFirst().get();
                collection.add((new CityCreater()).create( (String) o));
                CityCollection.getCollection().remove(updCity);
                return ("Город [id:" + o + "] успешно обновлен.");
            } else return ("Элемента с таким id не существует.");
        } catch (Exception e) {
            return ("Элемента с таким id не существует.");
        }
    }

    @Override
    public String getName() {
        return "update";
    }
}
