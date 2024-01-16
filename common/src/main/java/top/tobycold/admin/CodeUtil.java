package top.tobycold.admin;

import java.util.Random;

public class CodeUtil {
    public static int getRandomCode() {
        Random random = new Random();
        return random.nextInt(100000, 1000000);
    }
}
