package proxy.cglib.multiproxy;


public interface Point {
    Object proceed(Chain chain) throws InterruptedException;
}
