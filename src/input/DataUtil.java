package input;

import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;

public class DataUtil {

    @Nullable
    public static BufferedReader getFile(String fileName) {
        try {
            return new BufferedReader(new FileReader(String.format("src/input/%s", fileName)));
        } catch (Exception e)  {
            System.out.println(e);
            return null;
        }
    }
}
