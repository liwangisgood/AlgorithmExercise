package cn.ahpu.juc;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) {
        String result=null;
        ExecutorService executor= Executors.newSingleThreadExecutor();
        FutureTask<String> future =
                new FutureTask<String>(new Callable<String>() {//使用Callable接口作为构造参数
                    public String call() {
                        System.out.println("......");
                        return "....";
                        //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                    }});
        executor.execute(future);
//在这里可以做别的任何事情
        try {
            result = future.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
            System.out.println(result);
        } catch (InterruptedException e) {
            future.cancel(true);
        } catch (ExecutionException e) {
            future.cancel(true);
        } catch (TimeoutException e) {
            future.cancel(true);
        } finally {
            executor.shutdown();
        }
    }

}
