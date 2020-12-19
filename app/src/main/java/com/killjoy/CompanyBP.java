package com.killjoy;

import java.util.SplittableRandom;

public class CompanyBP {
    private final String Name;
    private final String Details;
    private final String MarketCap;
    private final String WeekRange52;
    private final String Price;
    private final String PE_ratio;
    private final String EPS;
    private final String CAGR;
    private final String Beta;
    private final String Dividend;
    public CompanyBP(String name, String details, String marketCap, String weekRange52, String price, String PE_ratio, String EPS, String CAGR, String beta, String dividend) {
        this.Name = name;
        this.Details = details;
        this.MarketCap = marketCap;
        this.WeekRange52 = weekRange52;
        this.Price = price;
        this.PE_ratio = PE_ratio;
        this.EPS = EPS;
        this.CAGR = CAGR;
        this. Beta = beta;
        this.Dividend = dividend;
    }

    public String getName() {
        return Name;
    }

    public String getDetails() {
        return Details;
    }

    public String getMarketCap() {
        return MarketCap;
    }

    public String getWeekRange52() {
        return WeekRange52;
    }

    public String getPrice() {
        return Price;
    }

    public String getPE_ratio() {
        return PE_ratio;
    }

    public String getEPS() {
        return EPS;
    }

    public String getCAGR() {
        return CAGR;
    }

    public String getBeta() {
        return Beta;
    }

    public String getDividend() {
        return Dividend;
    }
}
