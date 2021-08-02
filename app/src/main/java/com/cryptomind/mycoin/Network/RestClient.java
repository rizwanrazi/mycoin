package com.cryptomind.mycoin.Network;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



@SuppressWarnings("ALL")
public class RestClient {
    Retrofit builder;

    public RestClient(Context context) {

        String API_BASE_URL = "https://min-api.cryptocompare.com/data/";



        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest;

                newRequest = chain.request().newBuilder().addHeader("Content-Type", "application/json").addHeader("authorization", "Apikey 525fa1933d3246c3bbd6a8ec96207baf3104c80d12b95a4b4cf9196ece4d3728")
                        .build();

                return chain.proceed(newRequest);
            }
        };

// Add the interceptor to OkHttpClient
        OkHttpClient.Builder httpbuilder = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES).readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);
        httpbuilder.interceptors().add(interceptor);
        OkHttpClient client = httpbuilder.build();



//        OkHttpClient shortHttpClient = httpbuilder.readTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30, TimeUnit.SECONDS).connectTimeout(20, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        builder = new Retrofit.Builder().
                baseUrl(API_BASE_URL).
               //GsonConverterFactory.create()).
                // .addConverterFactory(MoshiConverterFactory.create().asLenient()).
//                           addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create()).
                        addConverterFactory(GsonConverterFactory.create(gson)).
                        client(client).
                        build();

//        final String API_BASE_URL_QA = "https://e-homewide.com/api/";//"http://varloops.com/homewide/api/";
//        final String API_BASE_URL_LIVE = "https://homewideuae.com/api/";//"http://varloops.com/homewide/api/";
       // OkHttpClient.Builder httpClient = new OkHttpClient.Builder();



      /*if (BuildConfig.DEBUG && SharedPreferenceManager.getSharedInstance().getStringFromPreferances(AppConstants.SharedPreferenceKeys.QA_MODE.getKey()).equals("yes")) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            httpClient.addInterceptor(logging);
        }*/

//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        httpClient.addInterceptor(logging);
//        Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);

//        httpClient.addNetworkInterceptor(new Interceptor() {
//            @NotNull
//            @Override
//            public Response intercept(@NotNull Chain chain) throws IOException {
//                Request newRequest;
//                if (isLogin) {
//                    LoginModel model = new Gson().fromJson(Utils.getclass(context, LoginModel.class), LoginModel.class);
//                    String token = model.getPayload().getToken();
//                    try {
//
//
//                    } catch (Exception e) {
//
//                    }
//                    Request originalRequest = chain.request();
//                     newRequest = originalRequest.newBuilder()
//                             .addHeader("Content-Type", "application/json")
//                             .addHeader("Accept", "application/json")
////                             .addHeader("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.IjE3Ig.PNID7vqEkP7utkR3S5Zuhba_mssRP1ZEL_vPm-bjbrA")
//                            .build();
//                }else {
//                    Request originalRequest = chain.request();
//                    newRequest  = originalRequest.newBuilder()
//                            .build();
//                }
//
//
//
//                return chain.proceed(newRequest);
//               // return null;
//            }
//        });

      //  if (!isInterceptor)
//        {
//            httpClient.addNetworkInterceptor(new Interceptor() {
//                @Override
//                @NonNull
//                public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {
//                    Request original = chain.request();
//                   // Request.Builder requestBuilder = original.newBuilder();
//
//                    Request request=null;
//                    if (isLogin) {
//                        LoginModel model = new Gson().fromJson(Utils.getclass(context, LoginModel.class), LoginModel.class);
//                        try {
//                            String token= model.getPayload().getToken();
////                            requestBuilder.addHeader("Authorization", token);
////                            requestBuilder.addHeader("accept", "application/json");
////                            requestBuilder.addHeader("Content-Type", "application/json");
//
//                             request = original.newBuilder()
//                                    .addHeader("Authorization", token)
//                                    .addHeader("Content-Type", "application/json")
//                                    .method(original.method(), original.body())
//                                    .build();
//                        } catch (Exception e) {
//                            Log.e("network error", e.getMessage());
//                            request = original.newBuilder()
//                                    .header("Content-Type", "application/json")
//                                    .method(original.method(), original.body())
//                                    .build();
//                        }
//
//                    }else {
//                        request = original.newBuilder()
//                                .addHeader("Content-Type", "application/json")
//                                .method(original.method(), original.body())
//                                .build();
//                    }
//                    //  requestBuilder.header("accept", "application/json");
//                 //   requestBuilder.addHeader("Content-Type", "application/json");
//                    // requestBuilder.addHeader("AppId", "[{H@ME}(w!de$)]");
//                    if (false) {
////                        String token = Singleton.myid.getAccessToken();
////                        String bearer = Singleton.myid.getToken_type();
////
////                        if (AppUtils.getAppUtils(null).isNullOrEmpty(token) && SharedPreferenceManager.getSharedInstance().getUserDataFromPreferences() != null) {
////                            token = SharedPreferenceManager.getSharedInstance().getUserDataFromPreferences().getAccessToken();
////                            bearer = SharedPreferenceManager.getSharedInstance().getUserDataFromPreferences().getToken_type();
////                        }
//                        //   requestBuilder.addHeader("Authorization", bearer + " " + token);
//                    }
////                    requestBuilder.addHeader("consumer-key", "iskan-android-key");
////                    requestBuilder.addHeader("consumer-secret", "iskan-android-secret");
////                    requestBuilder.addHeader("Connection", "close");
//                   // Request request = requestBuilder.build();
//
//
//                    Response response = null;
//                    try {
//                        response = chain.proceed(request);
//                    } catch (Error | NullPointerException e2) {
//                        Log.v("ROME parse error2 ", "unknown: 2" + e2.toString());
//                    }
//                    return response;
//                }
//            });
//        }

    }


    //https://api.ipify.org
    public <S> S createService(Class<S> serviceClass) {
        return builder.create(serviceClass);
    }
}