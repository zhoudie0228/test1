import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(3);

        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 3L, TimeUnit.SECONDS));
        //System.out.println(blockingQueue.offer("x", 3L, TimeUnit.SECONDS));false

        System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));




        /*blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("x");阻塞

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());阻塞*/







        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.offer("x"));false

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //System.out.println(blockingQueue.poll());null*/





        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));*/
       // System.out.println(blockingQueue.add("x"));  java.lang.IllegalStateException: Queue full

      /*  System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/
        //System.out.println(blockingQueue.remove());  java.util.NoSuchElementException


    }
}
