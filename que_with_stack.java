import java.io.*;
import java.util.*;

public class Solution {
    int top1=-1;
    int top2=-1;
    public static void main(String[] args) {
        
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) {               
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) {        
                queue.dequeue();
            } else if (operation == 3) {        
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
    public static class MyQueue<Integer> {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();
        
        public void enqueue(Integer num) {
            s1.push(num);
        }
        
        public Integer dequeue() {
            if (size() == 0) {
                return null;
            }
            if (s2.isEmpty()) {
                shiftStacks();
            }
            return s2.pop();
        }
        
        public Integer peek() {
            if (size() == 0) {
                return null;
            }
            if (s2.isEmpty()) {
                shiftStacks();
            }
            return s2.peek();
        }
        
        private void shiftStacks() {
            if (s2.isEmpty()) { 
                while ( ! s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
        
        public int size() {
            return s1.size() + s2.size();
        }
    }
}
