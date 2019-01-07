package com.gyb.mybatis.baseknow;

import java.lang.reflect.Method;

/**
 * @author gengyuanbo
 * 2019/01/07
 */
public class ReflectTest {
    public void say(String mess){
        System.out.println("say: "+mess);
    }

    public String  get(String str){
        return str;
    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName(ReflectTest.class.getName());
        Object o = aClass.newInstance();

        Method say = aClass.getMethod("say", String.class);
        say.invoke(o, "hello");

        Method get = aClass.getMethod("get", String.class);
        Object hi = get.invoke(o, "Hi");
        System.out.println(hi);


    }
}
