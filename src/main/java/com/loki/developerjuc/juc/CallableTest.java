package com.loki.developerjuc.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author xujs
 * 创建执行线程的方式三:实现Callable接口.相较于实现Runnable接口的方式,方法可以有返回值,并且可以抛出异常.
 * 执行Callable方式,需要FutureTask实现类的支持,接收运算结果.FutureTask 是 Future接口的实现类.
 */
public class CallableTest {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();

        // 执行Callable方式,需要FutureTask实现类的支持,接收运算结果.
        FutureTask<Integer> result = new FutureTask<>(demo);
        new Thread(result).start();

        // 接收线程运算后的结果
        try {
            // FutureTask 可用于 闭锁
            Integer sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class ThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
