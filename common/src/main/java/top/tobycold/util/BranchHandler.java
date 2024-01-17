package top.tobycold.util;

@FunctionalInterface
public interface BranchHandler {
    void trueOrFalseHandler(Runnable trueHandler, Runnable falseHandler);
}
