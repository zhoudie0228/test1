import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
题目：三个售票员，卖三十张票(企业级的多线程程序)
1.线程 操作 资源类(高内聚低耦合)

 */
class Ticket1{
    private int number=30;

    private Lock lock=new ReentrantLock();
      public  synchronized void sale(){

          lock.lock();  //上锁
          try {
              if(number>0){
                  System.out.println(Thread.currentThread().getName()+"\t 卖出第:"+(number--)+"\t还剩下"+number);
              }
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              lock.unlock();  //释放锁
          }
      }


   /* public  synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"\t 卖出第:"+(number--)+"\t还剩下"+number);
        }
    }*/

}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket1 ticket=new Ticket1();

          new Thread(()->{for (int i = 1; i <=35; i++)  ticket.sale();},"A").start();
          new Thread(()->{for (int i = 1; i <=35; i++)  ticket.sale();},"A").start();
          new Thread(()->{for (int i = 1; i <=35; i++)  ticket.sale();},"A").start();


       /* new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <=35; i++) {
                    ticket.sale();
                }

            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=35; i++) {
                    ticket.sale();
                }

            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=35; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();*/

    }
}

