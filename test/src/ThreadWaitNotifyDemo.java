/*
题目：两个线程，可以操作初始值为零的一个变量
     实现一个线程对该变量加1，一个线程对该变量减1
     实现交替，10轮，变量初始值为0

     注：防止虚假唤醒用while
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner{
    private int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();//相当于钥匙

    public  void increment() throws InterruptedException {
        lock.lock();  //上锁
        try {
            while(number!=0){
                //判断
                //this.wait();
                condition.await();
            }
            //干活
            ++number;
            System.out.println(Thread.currentThread().getName()+"\t "+number);
            //通知
            //this.notifyAll();
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //释放锁
        }

    }
    public  void decrement() throws InterruptedException {
        lock.lock();  //上锁
        try {
            while(number==0){
                //判断
                //this.wait();
                condition.await();
            }
            //干活
            --number;
            System.out.println(Thread.currentThread().getName()+"\t "+number);
            //通知
            //this.notifyAll();
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //释放锁
        }
    }






   /* public  synchronized void increment() throws InterruptedException {
        while(number!=0){
            //判断
            this.wait();
        }
        //干活
        ++number;
        System.out.println(Thread.currentThread().getName()+"\t "+number);
        //通知
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while(number==0){
            //判断
            this.wait();
        }
        //干活
        --number;
        System.out.println(Thread.currentThread().getName()+"\t "+number);
        //通知
        this.notifyAll();
    }
*/
}



public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {

        AirConditioner airConditioner=new AirConditioner();
         new Thread(()->{
             for (int i = 1; i <=10 ; i++) {
                 try {
                     Thread.sleep(200);
                     airConditioner.increment();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         },"A").start();


        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    Thread.sleep(300);
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();


        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    Thread.sleep(400);
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    Thread.sleep(500);
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}
