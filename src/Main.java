import java.util.*;

/**
 * Dynamic Programming Examples...
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Long[] l = new Long[]{1l, 2l, 5l, 25l};
        //   System.out.println(recursionFact(6000, new HashMap()));
        System.out.println("" + Arrays.toString(targetsum(100, l, new HashMap())));
        int a = 12, b = 25;
        System.out.println("Output " + (a ^ b));
    }

    // Dynamic programming....
    public static long recursionFact(long n, HashMap<Long, Long> map) {
        if (n == 1 || n == 2) return 1;
        if (map.containsKey(n)) return map.get(n);
        long val = (recursionFact(n - 1, map) + recursionFact(n - 2, map));
        map.put(n, val);
        return val;
    }

    // target sum problem 100,[1,2,5,25] //25,25,25,25
    public static Long[] targetsum(long targetsum, Long[] l, HashMap<Long, Long[]> map) {
        if (map.containsKey(targetsum)) return map.get(targetsum);
        if (targetsum == 0) return new Long[]{};
        if (targetsum < 0) return null;

        Long[] shortCob = null;

        for (int i = 0; i < l.length; i++) {
            long remainder = targetsum - l[i];
            Long[] list = targetsum(remainder, l, map);
            if (list != null) {
                List<Long> list1 = new ArrayList<>(Arrays.stream(list).toList());
                list1.add(l[i]);
                // System.out.println(list1);
                if (shortCob == null || list1.size() < shortCob.length) {
                    System.out.println(list1);
                    shortCob = list1.toArray(new Long[list1.size()]);
                }
            }
        }
        map.put(targetsum, shortCob);
        return shortCob;
    }


}