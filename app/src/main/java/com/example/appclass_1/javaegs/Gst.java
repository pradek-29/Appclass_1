package com.example.appclass_1.javaegs;

public class Gst  extends IncomeTax{
    @Override
    public int cacciTax(int income) {
        int oldtax= super.cacciTax(income);
        int newtax=1000;
        int gst=oldtax+newtax;
        return gst;
    }

}
