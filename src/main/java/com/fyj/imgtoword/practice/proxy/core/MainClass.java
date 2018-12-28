package com.fyj.imgtoword.practice.proxy.core;

import com.fyj.imgtoword.practice.proxy.entity.Animal;
import com.fyj.imgtoword.practice.proxy.entity.Dog;

/**
 * @author fanyongju
 * @Title: MainClass
 * @date 2018/12/28 11:41
 */
public class MainClass {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal dogProxy = (Animal) InvocationHandlerImpl.getProxy(dog);
        dogProxy.huXi();
    }
}
