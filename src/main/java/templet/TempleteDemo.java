package templet;

public class TempleteDemo {
    public static void main(String[] args) {
        /**
         * 1. 本质是有一些方法逻辑是固定的，但是其固定逻辑中的某一个part可以由使用者重写以实现不同的功能。
         * 2. 实现也很简单：一个抽象类，其中逻辑固定不变的方法声明为final，可以重写的部分声明为抽象方法或者
         */
        Cricket cricket = new Cricket();
        cricket.play();
    }
}
