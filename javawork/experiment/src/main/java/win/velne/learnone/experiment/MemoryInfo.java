package win.velne.learnone.experiment;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public class MemoryInfo {

    public static final int BIT = 10;
    public static final String GMKiB = "Kib";
    public static final int WIDTH = 8;
    public static final String LEFT = "|";
    public static final String MID = "  ";
    public static final String RIGHT = "|";
    public static final String SPACE = " ";

    private static final String BLOCK = "%" + WIDTH + "s";
    private static final String FORMAT = BLOCK + SPACE + BLOCK + SPACE + BLOCK;
    private static final StringBuilder DIV_LINE = new StringBuilder();
    private static final int AMOUNT_WIDTH = 6 * WIDTH + 4 * SPACE.length() + LEFT.length() + MID.length()
            + RIGHT.length();

    public static void title() {
        MemoryUsage heap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        MemoryUsage nonHeap = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        for (int i = 0; i < AMOUNT_WIDTH; i++) {
            DIV_LINE.append("-");
        }
        StringBuilder sb = new StringBuilder();

        sb.append(DIV_LINE).append("\n");

        sb.append(LEFT);
        sb.append(String.format(FORMAT, "", "Heap", "")).append(MID);
        sb.append(String.format(FORMAT, "", "NonHeap", "")).append(RIGHT + "\n");

        sb.append(LEFT);
        sb.append(String.format(FORMAT, "Max", "Init", "Unit")).append(MID);
        sb.append(String.format(FORMAT, "Max", "Init", "Unit")).append(RIGHT + "\n");

        sb.append(LEFT);
        sb.append(String.format(FORMAT, heap.getMax() >> BIT, heap.getInit() >> BIT, GMKiB)).append(MID);
        sb.append(String.format(FORMAT, nonHeap.getMax() >> BIT, nonHeap.getInit() >> BIT, GMKiB)).append(RIGHT + "\n");

        sb.append(DIV_LINE).append("\n");

        sb.append(LEFT);
        sb.append(String.format(FORMAT, "Used", "Total", "Percent")).append(MID);
        sb.append(String.format(FORMAT, "Used", "Total", "Percent")).append(RIGHT + "\n");

        System.out.print(sb);
    }

    public static void print() {
        MemoryUsage heap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        MemoryUsage nonHeap = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        StringBuilder sb = new StringBuilder();
        long hu = heap.getUsed();
        long hc = heap.getCommitted();
        long nu = nonHeap.getUsed();
        long nc = nonHeap.getCommitted();
        sb.append(LEFT);
        sb.append(String.format(FORMAT, String.valueOf(hu >> BIT), String.valueOf(hc >> BIT),
                String.format("%.2f%%", 1.0 * hu / hc * 100))).append(MID);
        sb.append(String.format(FORMAT, String.valueOf(nu >> BIT), String.valueOf(nc >> BIT),
                String.format("%.2f%%", 1.0 * nu / nc * 100))).append(RIGHT + "\n");
        System.out.print(sb);
    }

}