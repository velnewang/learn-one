package learnone.java.algorithm;

import java.util.Arrays;
import java.util.BitSet;

public class IntervalPick {

    public static String[] pokerInterval(int length) throws Exception {
        if (length < 0 || length > 13) {
            throw new Exception("Out of poker's range.");
        }
        String[] poker = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] queue = new String[length];
        BitSet bs = new BitSet(length);
        boolean turn = true;
        int index = 0;
        int times = 0;
        for (int i = 0; i < length;) {
            times++;
            index = bs.nextClearBit(index);
            if (index < length) {
                if (turn) {
                    bs.set(index);
                    queue[index] = poker[i];
                    i++;
                }
                index++;
                turn = !turn;
            } else {
                index = 0;
            }
        }
        System.out.println("length: " + length);
        System.out.println("loops : " + times);
        System.out.println("queue : " + Arrays.toString(queue));
        return queue;
    }

    public static void main(String[] args) {
        try {
            pokerInterval(13);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
