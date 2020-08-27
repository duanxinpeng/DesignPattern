package proxy.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();
    /*
    动态代理：
        特点：字节码随用随创建，随用随加载
        作用：不修改源码的基础上对方法进行增强
        分类：
            基于子类
        如何创建代理对象：
            设计的类：Enhancer
            cglib
            Enhancer类中的create方法
        要求：
            被代理对象不能是最终类
        create参数:
            Class：指定被代理对象的字节码
            Callback：一个接口，用于提供增强代码
                它是让我们写如何代理的，我们一般都是写一个该接口的实现类
                此接口的实现类都是谁用谁写。
                一般用：MethodInterceptor
     */
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 起到拦截的作用。
             * @param o
             * @param method
             * @param objects
             * 以上三个参数和基于接口的相同！
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                int money = (int)objects[0];
                if ("sale".equals(method.getName())) {
                    returnValue = method.invoke(producer, money-100);
                }
                return returnValue;
            }
        });
        cglibProducer.sale(1000);
    }

}
