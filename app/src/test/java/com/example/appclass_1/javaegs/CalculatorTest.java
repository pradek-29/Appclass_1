package com.example.appclass_1.javaegs;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator calci;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calci =new Calculator();
    }

    public void testAdd() {
        int exp=30;
        int act=calci.add(10,20);
        assertEquals(exp,act);
    }

    @Override
    protected void tearDown() throws Exception {

    }

    public void testMultiply() {
        int expect=20;
        int actu= calci.multiply(5,4);
        assertEquals(expect,actu);
    }
}