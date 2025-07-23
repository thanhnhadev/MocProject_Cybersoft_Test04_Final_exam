package utils.Helper;

import java.io.File;

public class SystemHelper {
    //lấy vị trí file
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
