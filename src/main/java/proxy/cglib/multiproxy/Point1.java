package proxy.cglib.multiproxy;

public class Point1 implements Point {

    @Override
    public Object proceed(Chain chain) throws InterruptedException {
        System.out.println("point 1 before");
        Thread.sleep(20);
        Object result = chain.proceed();
        Thread.sleep(20);
        System.out.println("point 1 after");
        return result;
    }
}
