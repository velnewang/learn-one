package win.velne.learnone.experiment;

import java.lang.management.ManagementFactory;

public class ArgumentsInfo {

    public static void print() {
        ManagementFactory.getRuntimeMXBean().getInputArguments().forEach(System.out::println);
    }

}
