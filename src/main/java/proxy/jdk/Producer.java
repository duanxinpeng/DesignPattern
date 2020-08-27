package proxy.jdk;

public class Producer implements IProducer {
    @Override
    public void sale(int money) {
        System.out.println("销售，并拿到钱："+money);
    }

    @Override
    public void afterService(int money) {
        System.out.println("售后，并拿到钱："+money);
    }
}
