package Commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static java.lang.String.valueOf;

/**
 * The type Execute script.
 */
public class ExecuteScript implements AnyCommand{

    /**
     * @param o название файла
     */
    @Override
    public String execute(Object o){
        try {
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = valueOf(o);
            //System.out.println(fileName);
            String path = "D:\\";
            BufferedReader reader = new BufferedReader(new FileReader(path + fileName));
            Commands commands = new Commands();
            while (reader.ready()) {
                String a = reader.readLine();
                String[] cmnds = a.split(";");
                for (int i = 0; i < cmnds.length; i++) {
                    if (Objects.equals(cmnds[i], "help") || Objects.equals(cmnds[i], "info") || Objects.equals(cmnds[i], "show") || Objects.equals(cmnds[i], "clear") || Objects.equals(cmnds[i], "save") ||
                            Objects.equals(cmnds[i], "exit") || Objects.equals(cmnds[i], "shuffle") || Objects.equals(cmnds[i], "reorder") || Objects.equals(cmnds[i], "average_of_telephone_code") ||
                            Objects.equals(cmnds[i], "print_field_ascending_telephone_code")){
                        System.out.println(commands.executeCommand(cmnds[i]));
                    }
                    else{
                        String[] cmnds1 = cmnds[i].split(" ");
                        commands.getCommand(cmnds1[0]).execute(cmnds1[1]);
                    }
                }
            }
            return "Скрипт из файла "+ fileName + " выполнен";
            }
        catch (FileNotFoundException ex) {
            return ("Указанный файл не найден.");
        } catch (IOException e) {
            return ("Что-то не так");
        }
    }

    @Override
    public String getName(){return "execute_script";}
}
