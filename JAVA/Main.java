import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

class MyRunnable extends Thread {
    @Override
    public void run() {
        System.out.println("myRunnable is running.");
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
    }
}

class Tool {
    public void test() {
        System.out.println("hello world.");
    }

    public static void help(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
    }
}

// class Solution {
//     private int n;
//     private double d;
//     private boolean flag;
//     private String str;

//     public void printMember() {
//         System.out.println(n);
//         System.out.println(d);
//         System.out.println(flag);
//         System.out.println(str);
//     }
// }
class Father {
    private void test() {
        System.out.println("hello");
    }

    public void invokeTest() {
        test();
    }
}

class Child extends Father {
    public void test() {
        System.out.println("hello world");
    }
}

public class Main {
    public static int n;
    public final static String str1 = "abc";
    public final static String str2 = "def";
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("不只Java-1", 1);
        concurrentHashMap.put("不只Java-2", 2);
        concurrentHashMap.put("不只Java-3", 3);

        ReentrantLock

        Set set = concurrentHashMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            concurrentHashMap.put("下次循环正常执行", 4);
        }
        System.out.println("程序结束");
        System.out.println(concurrentHashMap.size());
        
        // String str1 = "abc";
        // String str2 = "def";
        // System.out.println(str1.equals(str2));
        // System.out.println(str1.hashCode());

        // List<String> list = new ArrayList<>();
        // list.add("abc");
        // list.add("def");
        // list.add("ghi");
        // // for (String s : list) {
        // //     list.remove(s);
        // // }
        // Iterator<String> it = list.iterator(); 
        // while(it.hasNext()){ 
        //     String ele = it.next(); 
        //     it.remove(); 
        // } 
        // System.out.println(list.size());
        
        // Father f = new Father();
        // f.invokeTest();
        // Child c = new Child();
        // c.test();
        // Father f2 = c;
        // f2.invokeTest();
        // f2.test();

        // Class clz = Tool.class;
        // Tool tool = (Tool) clz.newInstance();
        // Method method = clz.getMethod("test");
        // method.invoke(tool);

        // Integer b = 12;
        // Integer c = 12;
        // System.out.println(a==b);
        // System.out.println(b==c);

        // String a = new String("ab") + new String("c");
        // a.intern();
        // String b = "abc";
        // System.out.println(a==b);

        // String str3 = str1 + str2;
        // String str4 = "abcdef";
        // System.out.println(str3 == str4);
        // System.out.println(n);

        // Stream<String> stream1 = Arrays.stream(new String[] { "A", "B", "C" });
        // Stream<String> stream2 = List.of("X", "Y", "Z").stream();
        // stream1.forEach(System.out::println);
        // stream2.forEach(System.out::println);

        // String[] array = new String[] { " 2019-12-31 ", "2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01",
        // " 2025-01 -01" };
        // // 请使用map把String[]转换为LocalDate并打印:
        // Arrays.stream(array)
        // .map(str-> str.replaceAll(" ",""))
        // // .map(LocalDate::parse)
        // .forEach(System.out::println);

        // int[] arr = new int[10];
        // System.out.println(Arrays.toString(arr));
        // System.out.println(arr[0] + " hello world");

        // int[] arr = new int[]{1, 2, 3};
        // int[] tmp = arr;
        // // int[] tmp = Arrays.copyOf(arr, arr.length);
        // tmp[0] = -1;
        // System.out.println(Arrays.toString(arr));

        // Solution solution = new Solution();
        // solution.printMember();

        // String str3 = "a我𝄞";
        // // // String str4 = str1 + str2;
        // System.out.println(str3.length());
        // System.out.println(str3.toCharArray().length);

        // System.out.println(str3.getBytes().length);
        // System.out.println(str3.getBytes(StandardCharsets.UTF_8).length);
        // System.out.println(str3.getBytes(StandardCharsets.UTF_16).length);

        // String str = "abc";
        // str = new StringBuffer(str).reverse().toString();
        // System.out.println(str);

        // String a = "a";
        // String b = "b";
        // String c = "ab";
        // String d = a + b;
        // String e = "a" + new String("b");
        // String f = "a" + "b";
        // System.out.println(c == f);

        // Scanner input = new Scanner(System.in);
        // String line = input.nextLine();
        // String[] strs = line.trim().split(" ");
        // int[] nums = new int[strs.length];
        // for (int i = 0; i < strs.length; i++) {
        //     nums[i] = Integer.parseInt(strs[i]);
        // }
        // Tool.help(nums);
        // for (int n : nums) System.out.print(n + " ");
        // int a = 1;
        // int b = 2;
        // swap(a, b);
        // System.out.println("a: ", a, "b: ", b);
        // MyRunnable mRunnable = new MyRunnable();
        // Thread thread1 = new Thread(mRunnable);
        // Thread thread2 = new Thread(mRunnable);
        // thread1.start();
        // thread2.start();
        // System.out.println(Thread.currentThread().getName());
        // String str1 = new String("test");
        // String str2 = new String("test");
        // System.out.println(str1 == str2);
        // System.out.println(str1.hashCode() == str2.hashCode());
        
    }
}

// class Solution {
//     public void sortVec3(List<Integer> nums) {
//         int size = nums.size();
//         int gap = 1;
//         while (gap < size / 3) {
//             gap = gap * 3 + 1;
//         }
    
//         while (gap > 0) {
//             for (int i = gap; i < size; i++) {
//                 int j = i;
//                 int tmp = nums.get(i);
//                 while (j >= gap && nums.get(j-gap) > tmp) {
//                     nums.set(j, nums.get(j-gap));
//                     j -= gap;
//                 }
//                 nums.set(j, tmp);
//             }
//             gap /= 3;
//         }
//     }
// }