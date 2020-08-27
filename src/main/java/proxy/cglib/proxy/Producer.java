package proxy.cglib.proxy;

public class Producer {

    public void sale(int money) {
        System.out.println("销售，并拿到钱："+money);
    }


    public void afterService(int money) {
        System.out.println("售后，并拿到钱："+money);
    }
}
