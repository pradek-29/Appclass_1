package com.example.appclass_1.javaegs;

public class DemoLamdas {
    public static void main(String[] args) {

    onClickImpl onclkimpl=new onClickImpl();
    onclkimpl.onClick(12);
    onClickListener onclkListener =(v)->{
        System.out.println("handling lamda click");
    };
    onclkListener.onClick(121);
}
}

