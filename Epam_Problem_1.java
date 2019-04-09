import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
public class Epam_Problem_1 {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }


    static boolean hasCycle(SinglyLinkedListNode head) {

        //using hashing...
        /*HashSet<SinglyLinkedListNode> s = new HashSet<SinglyLinkedListNode>();
        while (head != null) 
        { 
            if (s.contains(head)) 
                return true; 
            s.add(head);    
            head = head.next; 
        } 
        return false; 
*/

//using traversing fast pointer and slow pointer
        Node s = head, f = head; 
        while (s != null && f != null && f.next != null) { 
            s = s.next; 
            f = f.next.next; 
            if (s == f) { 
                //System.out.println("Found loop"); 
                return true; 
            } 
        } 
        return false; 
    }

    private static final Scanner scanner = new Scanner(System.in);
