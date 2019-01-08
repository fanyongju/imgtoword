package com.fyj.practice.proxy.entity;

/**
 * @author fanyongju
 * @Title: Dog
 * @date 2018/12/27 15:15
 */
public class Dog implements Animal{
    @Override
    public void huXi() {
        System.out.println("狗狗呼吸");
    }

    public void voice(){
        System.out.println("汪汪汪");
    }
}
