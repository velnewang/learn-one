package win.velne.learnone.grapheme;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;

public class Grapheme {

    public static int getGraphemeLength(String value) {
        BreakIterator it = BreakIterator.getCharacterInstance();
        it.setText(value);
        int count = 0;
        while (it.next() != BreakIterator.DONE) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strings = { "😃", "❤️", "नमस्ते" };
//        String[] strings = { "😃", "❤️", "नमस्ते", "﷽" };
        ArrayList<String> sList = new ArrayList<>();
        Arrays.asList(strings).forEach(s -> {
            sList.add(s);
            sList.add(new StringBuilder(s).reverse().toString());
        });
        sList.add(String.join("", strings));
        sList.add(
                new StringBuilder(String.join("", strings)).reverse().toString()
        );

        System.out.println(
                "grapheme\t" + "codePoint\t" + "char\t\t" + "byte\t\t"
                        + "string"
        );
        sList.forEach(s -> {
            ArrayList<Integer> info = new ArrayList<>();
            info.add(getGraphemeLength(s));
            info.add((int) s.codePoints().count());
            info.add(s.toCharArray().length);
            info.add(s.getBytes().length);
            info.forEach(k -> System.out.print(k + "\t\t"));
            System.out.println(s);
        });

    }

}
