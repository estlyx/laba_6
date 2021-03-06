package Commands;

/**
 * The type Help.
 */
public class Help implements CommandWithNoArg{
    @Override
    public String execute(Object o){
        return ("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)\n" +
                "shuffle : перемешать элементы коллекции в случайном порядке\n" +
                "reorder : отсортировать коллекцию в порядке, обратном нынешнему\n" +
                "average_of_telephone_code : вывести среднее значение поля telephoneCode для всех элементов коллекции\n" +
                "print_field_ascending_telephone_code : вывести значения поля telephoneCode всех элементов в порядке возрастания\n" +
                "print_field_descending_meters_above_sea_level : вывести значения поля metersAboveSeaLevel всех элементов в порядке убывания");
    }
    @Override
    public String getName(){return "help";}
}
