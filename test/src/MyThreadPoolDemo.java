import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);//一池多线程
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();//一池一线程
        //ExecutorService threadPool= Executors.newCachedThreadPool();//一池一线程

        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
                );


        try {
            for (int i = 1; i <=12 ; i++) {
                final int tempI=i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 卖出第:"+tempI);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
