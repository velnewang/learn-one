package win.velne.learnone.experiment;

/**
 * JVM Arguments: -server -Xms20m -Xmx20m -XX:+PrintGC -XX:+DoEscapeAnalysis
 *
 */

public class Escape {

    private static void alloc() {
        String[] strings = new String[16];
        strings[0] = ("0123456789abcde");
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        MemoryInfo.title();
        MemoryInfo.print();
        MemoryInfo.print();
        MemoryInfo.print();
        MemoryInfo.print();
        MemoryInfo.print();
        for (int i = 0; i < 1024 * 1024 * 1024; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        MemoryInfo.print();
        System.out.println("Time:\t" + (end - begin));
        ArgumentsInfo.print();
    }
}