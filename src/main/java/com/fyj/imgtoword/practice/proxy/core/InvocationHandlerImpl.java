package com.fyj.imgtoword.practice.proxy.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fanyongju
 * @Title: InvocationHandlerImpl
 * @date 2018/12/27 15:17
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    public static Object getProxy(Object target) {
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("之前");
        Object result = method.invoke(target, args);
        System.out.println("之后");
        return result;
    }
}
