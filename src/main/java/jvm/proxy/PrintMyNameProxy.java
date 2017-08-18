package jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PrintMyNameProxy implements InvocationHandler {

    private Object targetObj;

    Object newProxy(Object targetObj) {
        this.targetObj = targetObj;
        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),
                targetObj.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("My name is ....");
        return method.invoke(targetObj, args);
    }
}
