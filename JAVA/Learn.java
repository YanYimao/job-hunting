import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Learn {
    public static void main(String[] args) {
        // Integer
        Integer integer = 3;
        Integer integer2 = Integer.MAX_VALUE;
        
        System.out.println(integer.intValue());

        // String
        // String 不能用for each
        String str = "fedcba";
        System.out.println(str.length());
        System.out.println(str.indexOf("f", 1));
        String subStr = str.substring(0);
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
        String tmpStr = new String("fedcba");
        System.out.println(str.equals(tmpStr));
        char[] str1 = str.toCharArray();
        Arrays.sort(str1);
        for (char c : str1) {
            System.out.print(c);
        }
        char[] str2 = "abcdef".toCharArray();
        System.out.print(Arrays.equals(str1, str2));
        str1.equals(str2);
        String str3 = new String(str);
        System.out.println("str3 == str: " + (str3 == str));
        System.out.println("str3.equals(str): " + str3.equals(str));

        StringBuffer sb = new StringBuffer();
        sb.append("test");
        sb.append(": hello!");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hello");
        sb2.append(" world!");
        sb2.substring(1);
        String sb3 = new String(sb);
        System.out.println(sb);
        System.out.println(sb2);
        System.out.println(sb3);

        // ListNode
        // 判断ListNode为空不能用!
        ListNode node = null;
        if (node == null) {
            node = new ListNode(0);
        }

        // Java只有Arrays.sort, Collections.reverse, Collections.sort, 没有swap, 可以用异或实现swap. 
        // 判断任何引用类型是否相等用 a.equals(b).
        // 深拷贝引用类型对象直接用new新建.

        // array
        int[] arr1 = new int[]{0, 1, 2};
        int[][] arr2 = new int[][]{{1,1,2}, {2,3,1}, {3,4,0}};
        Arrays.sort(arr2, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < arr2.length; i++) System.out.println(Arrays.toString(arr2[i]));

        // List
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.set(0, 3);
        int tmp = list.get(0);
        list.remove(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.addAll(list);
        List<Integer> list4 = new ArrayList<Integer>();
        Collections.addAll(list4, 1, 2);
        list.retainAll(list4);
        Integer[] tmpArray = list.toArray(new Integer[list.size()]);
        List<Integer> tmpList = List.of(tmpArray);
        tmpList.equals(list);
        Collections.sort(list, (a, b) -> b - a);
        for (int n : list) System.out.println(n);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.removeLast();

        // Stack
        Deque<Integer> st = new LinkedList<>();
        st.push(1);
        tmp = st.peek();
        tmp = st.pop();
        boolean flag = st.isEmpty();

        // Queue
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        tmp = que.peek();
        tmp = que.poll();
        flag = que.isEmpty();
        int size = que.size();

        PriorityQueue<int[]> que2 = new PriorityQueue<>((pair1, pair2) -> pair1[0]-pair2[0]);
        que2.offer(new int[]{2, 2});
        que2.offer(new int[]{1, 1});
        int[] tmp2 = que2.poll();
        System.out.println(Arrays.toString(tmp2));

        // Deque
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addFirst(0);
        tmp = deque.getFirst();
        System.out.println(tmp);
        tmp = deque.getLast();
        System.out.println(tmp);
        deque.removeFirst();
        deque.removeLast();

        // Set
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.remove(1);
        flag = set.contains(1);
        
        // Map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(0, map.getOrDefault(0, 0) + 1);
        map.get(0);
        map.put(1, 2);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        flag = map.containsKey(0);
        map.remove(0);

        // other
        Random random = new Random();
        int rand = random.nextInt(10);

        int maxNum = Math.max(0, 1);

        String StrLearn = " abcdef-ghi";
        System.out.println(StrLearn.trim());
        System.out.println(Arrays.toString(StrLearn.split("-")));

        // Scanner scanner = new Scanner(System.in);
        // while (scanner.hasNextLine()) {
        //     String line = scanner.nextLine();
        //     String[] numbers = line.split(" ");
        //     int[] intArr = new int[numbers.length];
        //     for (int i = 0; i < numbers.length; i++) {
        //         intArr[i] = Integer.parseInt(numbers[i]);
        //     }
        //     System.out.println(Arrays.toString(intArr));
        // }

        ConcurrentHashMap<Integer, Integer> map3 = new ConcurrentHashMap<>();
        Integer int3 = Integer.valueOf(3);
        int i = int3.intValue();
        int i2 = Integer.parseInt("12");
        System.out.println(i2);
        String str4 = int3.toString();

        String testNum = "012";
        int testN = Integer.parseInt(testNum);
        System.out.println(testN);

    }
}