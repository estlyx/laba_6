package Commands;

import java.io.IOException;

public interface AnyCommand {
    String execute(Object o) throws IOException;

    String getName();
}
