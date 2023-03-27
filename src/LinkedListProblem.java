public class LinkedListProblem {

    public static void main(String[] args) {
        Node<Integer> minus = new Node<Integer>(-1);
        Node<Integer> one = new Node<Integer>(2);
        Node<Integer> two = new Node<Integer>(-1);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> mHead = new Node<Integer>(1);
        mHead.next = one;
        one.next = two;

        // two.next = three;
        //  three.next = four;
        //  four.next = minus;

        Node temp = insert(mHead, 2, 0, 3);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
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
