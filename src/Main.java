import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
   /*     Long[] l = new Long[]{1l, 2l, 5l, 25l};
        //   System.out.println(recursionFact(6000, new HashMap()));
        System.out.println("" + Arrays.toString(targetsum(100, l, new HashMap())));

        int a = 12, b = 25;
        System.out.println("Output " + (a ^ b));
*/
        /**
         * 2
         * 1 2 -1
         * 3 0
         */

        Node<Integer> minus = new Node<Integer>(-1);
        Node<Integer> one = new Node<Integer>(2);
        Node<Integer> two = new Node<Integer>(-1);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> four = new Node<Integer>(4);


        Node<Integer> mHead = new Node<Integer>(1);
        mHead.next = one;
        one.next = two;
       // two.next = three;
      ////  three.next = four;
      //  four.next = minus;

        Node temp = insert(mHead, 2, 0, 3);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }


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

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // N =5
    // List [1,1,2,3,4,-1]
    // val= 2
    // pos = 1
    // output-> 1-> 2 -> 1 -> 2 -> 3 -> 4

    static Node insert(Node head, int n, int pos, int val) {
        // Write your code here.
        int currentpos = 0;
        Node mMainNode = head;
        Node mHead = head;
        Node tempNode;
        if (pos == 0) {
            Node<Object> node = new Node<>(val);
            node.next = mMainNode;
            mMainNode = node;
        }
        int position = pos;
        if (pos > 0) pos = pos - 1;
        while (mHead != null && position > 0) {
            if (pos == currentpos) {
                Node<Object> node = new Node<>(val);
                tempNode = mHead.next;
                mHead.next = node;
                node.next = tempNode;
                break;
            }
            mHead = mHead.next;
            currentpos++;
        }
        mHead = mMainNode;
        currentpos = 0;
        while (mHead != null) {
            if (currentpos == n) {
                mHead.next = null;
                break;
            }
            mHead = mHead.next;
            currentpos++;
        }
        return mMainNode;
    }

}