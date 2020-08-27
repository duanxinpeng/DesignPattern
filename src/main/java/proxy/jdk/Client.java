package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();
        System.out.println(producer.getClass().getClassLoader());
    /*
    动态代理：
        特点：字节码随用随创建，随用随加载
        作用：不修改源码的基础上对方法进行增强
        分类：
            基于接口
            基于子类
        如何创建代理对象：
            使用Proxy类中的newProxyInstance方法
        要求：
            被代理对象至少实现一个接口
        参数:
            ClassLoader: 类加载器
                用于加载代理对象字节码的，和代理对象使用相同的类加载器
            Class[]： 字节码数组
                让代理对象和被代理对象都有相同的方法，即代理对象和被代理对象都实现相同的接口！
            InvocationHandler
                如何代理
     */
        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法（起到拦截的作用）
                     * @param proxy   代理对象的引用
                     * @param method  当前执行的方法
                     * @param args    当前执行方法所需参数
                     * @return        和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        int money = (int)args[0];
                        if ("sale".equals(method.getName())) {
                            returnValue = method.invoke(producer, money-200);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.sale(1000);

    }

}



