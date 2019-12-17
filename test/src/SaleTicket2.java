import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
题目：三个售票员，卖三十张票(企业级的多线程程序)
1.线程 操作 资源类(高内聚低耦合)

 */

class Ticket {
    private int number = 30;

    private Lock lock = new ReentrantLock();

    public synchronized void sale() {

        lock.lock();  //上锁
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第:" + (number--) + "\t还剩下" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //释放锁
        }
    }
}





public class SaleTicket2 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        try {
            for (int i = 1; i <=30; i++) {
                    final int tempI=i;
                threadPool.execute(()->{
                       ticket.sale();
                    });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

