package com.zp;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 *
 * @Author zp
 * @create 2020/12/3 17:47
 */
public class MetaspaceOOMTest {
    public static void main(final String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("run")) {
                    System.out.println("before car run....");
                }
                return methodProxy.invokeSuper(o, objects);
            }
        });

        int cnt = 0;
        while (true) {
            Car o = (Car) enhancer.create();
            cnt++;
            System.out.println("第" + cnt + "个对象");
        }

    }

    static class Car {
        public void run() {
            System.out.println("car run....");
        }
    }
}
