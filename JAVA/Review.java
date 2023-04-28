import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Review {
    public static void main(String[] args) {
        // Integer
        int n = Integer.valueOf("017");
        int tmp = Integer.MAX_VALUE;
        // String
        String str = 123 + "abcdef ";
        StringBuilder sb = new StringBuilder(); sb.append(str); sb.reverse();
        String str2 = new String(sb).substring(0, 4);
        str2 = str2.trim(); String[] strArr = str.split("c");
        int index = str.indexOf("def");
        System.out.println(str.equals(str2));
        for (int i = 0; i < str2.length(); i++) System.out.print(str2.charAt(i));
        char[] arr = str.toCharArray();
        // array
        int[][] arr2 = new int[][]{{1,1,2}, {2,3,1}, {3,4,0}};
        Arrays.sort(arr2, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < arr2.length; i++) System.out.println(Arrays.toString(arr2[i]));
        // List
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.set(0, 3);
        tmp = list.get(0);
        list.remove(0);
        Collections.sort(list, (a, b) -> b - a);
        // stack peek pop push
        // queue peek offer poll
        // deque getFirst getLast addFirst addLast removeFirst removeLast
        PriorityQueue<int[]> que = new PriorityQueue<>((pair1, pair2) -> pair1[0]-pair2[0]);
        // set add contains remove
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, map.getOrDefault(0, 0) + 1);
        if (map.containsKey(0)) map.get(0);
        map.remove(0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        // other
        int random = (int) (Math.random() * 10);

    }
}
