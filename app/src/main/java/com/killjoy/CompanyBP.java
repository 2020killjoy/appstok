package com.killjoy;

import java.util.SplittableRandom;

public class CompanyBP {
    private String Name;
    private String Value0;
    private String Value1;
    private String Value2;

    public CompanyBP(String name, String value0, String value1, String value2) {
        Name = name;
        Value0 = value0;
        Value1 = value1;
        Value2 = value2;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue0() {
        return Value0;
    }

    public void setValue0(String value0) {
        Value0 = value0;
    }

    public String getValue1() {
        return Value1;
    }

    public void setValue1(String value1) {
        Value1 = value1;
    }

    public String getValue2() {
        return Value2;
    }

    public void setValue2(String value2) {
        Value2 = value2;
    }
}
