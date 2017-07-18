package com.taotao.common.pojo;

public class A extends B {
    static
    {
        System.out.println("Load A");
    }
    public A()
    {
        System.out.println("Create A");
    }
}
