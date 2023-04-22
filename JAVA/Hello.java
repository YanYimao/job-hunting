import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.NumberFormat.Style;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Hello {

    public static void main(String[] args) throws Exception {
        String str = "Hello World";
        System.out.println("Before: " + str);
        Integer testInteger = Integer.valueOf("123");
        System.out.println(testInteger);

    }
}
