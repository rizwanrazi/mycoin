package com.cryptomind.mycoin.Network.Networkinterface;

import com.cryptomind.mycoin.models.ROD.RODModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface GetService {

    @GET(".")
    Call<String> getPublicIP();

    @GET("histohour?fsym=BTC&tsym=USDT&limit=600&aggregate=1&extraParams=CoinBit")
    Call<RODModel> getCOD();
}
