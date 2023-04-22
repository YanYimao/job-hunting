
class STest{

    private final Object object = new Object();
    public void print(){
        synchronized (object){
            System.out.println("xxxx");
        }
    }
}

public class SynchronizeMain {

    public static void main(String[] args) throws InterruptedException {

        STest sTest = new STest();

        // Thread 1
        Thread t1 = new Thread(() -> {
            sTest.print();
        });

        // Thread 2
       Thread t2 = new Thread(() -> {

           try {
               synchronized (sTest){
                   while (true);
               }
           } catch (Exception e) {
               System.out.println("Exception="+e.getMessage());
           }

        });

       t2.start();
       Thread.sleep(1000);
       t1.start();
    }
}

