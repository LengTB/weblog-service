package top.tobycold.util;

import java.util.Random;

public class ColdUtil {
    public static int getRandomCode() {
        Random random = new Random();
        return random.nextInt(100000, 1000000);
    }

    public static BranchHandler isNull(Object obj) {
        return obj == null ? (trueHandler, falseHandler) -> {
            trueHandler.run();
        } : (trueHandler, falseHandler) -> {
            falseHandler.run();
        };
    }
}
