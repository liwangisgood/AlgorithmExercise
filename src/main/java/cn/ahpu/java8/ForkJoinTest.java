package cn.ahpu.java8;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinTest extends RecursiveTask<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 13475679780L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000L; //临界值

    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;

        if (length <= THRESHOLD) {
            long sum = 0;

            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinTest left = new ForkJoinTest(start, middle);
            left.fork(); //拆分，并将该子任务压入线程队列

            ForkJoinTest right = new ForkJoinTest(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }

    }

}

class ForkJoin {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        Instant start1 = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinTest(0L, 10000000000L);

        long sum = pool.invoke(task);
        System.out.println(sum);

        long end = System.currentTimeMillis();
        Instant end1 = Instant.now();
        System.out.println("耗费的时间为: " + (end - start)); //112-1953-1988-2654-2647-20663-113808
        System.out.println("耗费的时间:"+ Duration.between(start1,end1).getNano());//纳秒 毫秒 秒 分 时 天
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();

        long sum = 0L;

        for (long i = 0L; i <= 100; i++) {
            sum += i;
        }

        System.out.println(sum);

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start)); //34-3174-3132-4227-4223-31583
    }

    @Test
    public void test3() {
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10000000000L).sequential().sum();//3538ms
//        Long sum = LongStream.rangeClosed(0L, 10000000000L).parallel().sum();//541ms

        System.out.println(sum);

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926
    }

}


