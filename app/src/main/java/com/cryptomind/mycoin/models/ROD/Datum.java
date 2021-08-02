package com.cryptomind.mycoin.models.ROD;

/**
 * Created by Rizwan Ahmed on 26/07/2021.
 * MHAO
 */
public class Datum {

    public Integer time;
    public Float high;
    public Float low;
    public Float open;
    public Float volumefrom;
    public Float volumeto;
    public Float close;
    public String conversionType;
    public String conversionSymbol;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getOpen() {
        return open;
    }

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getVolumefrom() {
        return volumefrom;
    }

    public void setVolumefrom(Float volumefrom) {
        this.volumefrom = volumefrom;
    }

    public Float getVolumeto() {
        return volumeto;
    }

    public void setVolumeto(Float volumeto) {
        this.volumeto = volumeto;
    }

    public Float getClose() {
        return close;
    }

    public void setClose(Float close) {
        this.close = close;
    }

    public String getConversionType() {
        return conversionType;
    }

    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    public String getConversionSymbol() {
        return conversionSymbol;
    }

    public void setConversionSymbol(String conversionSymbol) {
        this.conversionSymbol = conversionSymbol;
    }
}
