import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Testing normal string
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 1000000; i++) {
            s += r.nextInt(2);
        }
        System.out.println(System.currentTimeMillis() - start);
        // Testing stringbuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start);
        // Testing stringbuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sbf.append(r.nextInt(2));
        }
        s = sbf.toString();
        System.out.println(System.currentTimeMillis() - start);
    }
}