package proxy.cglib.multiproxy;

public class Test {
    public static void main(String[] args) {
        Object proxy = ProxyFactory.create().getProxy(new SayHello());
        proxy.toString();
    }
    static class SayHello {
        @Override
        public String toString() {
            return "hello cglib";
        }
    }
}
