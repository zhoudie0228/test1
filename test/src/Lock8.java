import java.util.concurrent.TimeUnit;

/* 多线程8锁
1.标准访问，先打印邮件还是短信  --->邮件
2.email方法新增暂停3秒，先打印邮件还是短信  ----->邮件
3.新增普通的hello方法，先打印邮件还是hello  ----->hello
4.两部手机，先打印邮件还是短信  ----->短信
5.两个静态同步方法，1部手机，先打印邮件还是短信  ----->邮件
6.两个静态同步方法，2部手机，先打印邮件还是短信  ----->邮件
7.1个普通同步方法，1个静态方法，1部手机，先打印邮件还是短信  ----->短信
8.1个普通同步方法，1个静态方法，2部手机，先打印邮件还是短信  ----->短信

 */



class Phone{
    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);//暂停4秒
        System.out.println("***sendEmail");
    }
    public  synchronized void sendSMS(){
        System.out.println("***sendSMS");
    }
    public void hello(){
        System.out.println("***hello");
    }
}


public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone=new Phone(); //this01
        Phone phone2=new Phone();  //this02
         new Thread(()->{
             try {
                 phone.sendEmail();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         },"A").start();
         Thread.sleep(100);

        new Thread(()->{
            try {
                //phone.sendSMS();
                //phone.hello();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }
}
