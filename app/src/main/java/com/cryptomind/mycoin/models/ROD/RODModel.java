package com.cryptomind.mycoin.models.ROD;

import java.util.List;

/**
 * Created by Rizwan Ahmed on 26/07/2021.
 * MHAO
 */
public class RODModel {

    public String Response;
    public Integer Type;
    public Boolean Aggregated;
    public Integer TimeTo;
    public Integer TimeFrom;
    public Boolean FirstValueInArray;
    public ConversionType ConversionType;
    public List<Datum> Data = null;
    public RateLimit RateLimit;
    public Boolean HasWarning;


    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Boolean getAggregated() {
        return Aggregated;
    }

    public void setAggregated(Boolean aggregated) {
        Aggregated = aggregated;
    }

    public Integer getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(Integer timeTo) {
        TimeTo = timeTo;
    }

    public Integer getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(Integer timeFrom) {
        TimeFrom = timeFrom;
    }

    public Boolean getFirstValueInArray() {
        return FirstValueInArray;
    }

    public void setFirstValueInArray(Boolean firstValueInArray) {
        FirstValueInArray = firstValueInArray;
    }

    public com.cryptomind.mycoin.models.ROD.ConversionType getConversionType() {
        return ConversionType;
    }

    public void setConversionType(com.cryptomind.mycoin.models.ROD.ConversionType conversionType) {
        ConversionType = conversionType;
    }

    public List<Datum> getData() {
        return Data;
    }

    public void setData(List<Datum> data) {
        Data = data;
    }

    public com.cryptomind.mycoin.models.ROD.RateLimit getRateLimit() {
        return RateLimit;
    }

    public void setRateLimit(com.cryptomind.mycoin.models.ROD.RateLimit rateLimit) {
        RateLimit = rateLimit;
    }

    public Boolean getHasWarning() {
        return HasWarning;
    }

    public void setHasWarning(Boolean hasWarning) {
        HasWarning = hasWarning;
    }
}
