package com.cryptomind.mycoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cryptomind.mycoin.Network.Networkinterface.GetService;
import com.cryptomind.mycoin.Network.Networkinterface.PostService;
import com.cryptomind.mycoin.Network.RestClient;
import com.cryptomind.mycoin.models.ROD.RODModel;
import com.cryptomind.mycoin.util.Constants;
import com.cryptomind.mycoin.util.Utils;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.ll_layout_progressbar)
    LinearLayout progressLayout;

//    @BindView(R.id.tv_1)
//    TextView tv_1;
//
//    @BindView(R.id.tv_2)
//    TextView tv_2;
//
//    @BindView(R.id.tv_3)
//    TextView tv_3;
//
//    @BindView(R.id.tv_4)
//    TextView tv_4;
//
//    @BindView(R.id.tv_5)
//    TextView tv_5;


    @BindView(R.id.tvv)
    TextView tvv;

    @BindView(R.id.tvv3)
    TextView tvv3;





    @BindView(R.id.btn_1)
    Button btn_1;

    @BindView(R.id.btn_2)
    Button btn_2;

    @BindView(R.id.btn_3)
    Button btn_3;


    @BindView(R.id.btn_call)
    Button btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        btn_call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getCOD();
//            }
//        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCOD(1);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCOD(2);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCOD(3);
            }
        });
    }


    private void getCOD(int i) {
        if (new Utils().isOnline(this)) {

            Utils.hideKeyboardFromActivity(this);
            Call<RODModel> getAddress;
            progressLayout.setVisibility(View.VISIBLE);
            getAddress = new RestClient(this).createService(GetService.class).getCOD();
            getAddress.enqueue(new Callback<RODModel>() {
                @Override
                public void onResponse(Call<RODModel> call, Response<RODModel> response) {
                    progressLayout.setVisibility(View.GONE);
                    String erro = response.message();
                    try {
                        if ((response.code() == Constants.REQUEST_CODE_TWO_HUNDRED || response.code() == Constants.REQUEST_CODE_TWO_HUNDRED_ONE) && response.body() != null) {

                            RODModel rodModel = response.body();
                            double cod7 = ((rodModel.getData().get(rodModel.getData().size() - 2).getClose() - rodModel.getData().get(433).getClose()) / rodModel.getData().get(433).getClose()) * 100;
                            double cod14 = ((rodModel.getData().get(rodModel.getData().size() - 2).getClose() - rodModel.getData().get(265).getClose()) / rodModel.getData().get(265).getClose()) * 100;
                            double cod25 = ((rodModel.getData().get(rodModel.getData().size() - 2).getClose() - rodModel.getData().get(0).getClose()) / rodModel.getData().get(0).getClose()) * 100;

                            if (i==1){
                                tvv.setText(Html.fromHtml(epochToIso8601(rodModel.getData().get(rodModel.getData().size() - 2).getTime()) + " : close = "
                                        + rodModel.getData().get(rodModel.getData().size() - 2).getClose() + "<br><br>" +
                                        epochToIso8601(rodModel.getData().get(433).getTime()) + " : close = "
                                        + rodModel.getData().get(433).getClose()));
                                if (cod7 > 0)
                                    tvv3.setText("7 Days - ↗ " + cod7);
                                else
                                    tvv3.setText("7 Days - ↘ " + cod7);
                            }else if (i==2){
                                tvv.setText(Html.fromHtml(  epochToIso8601(rodModel.getData().get(rodModel.getData().size() - 2).getTime()) + " : close = "
                                        + rodModel.getData().get(rodModel.getData().size() - 2).getClose() + "<br><br>" +epochToIso8601(rodModel.getData().get(265).getTime()) + " : close = "
                                        + rodModel.getData().get(265).getClose() ));
                                if (cod14 > 0)
                                    tvv3.setText("14 Days - ↗ " + cod14);
                                else
                                    tvv3.setText("14 Days ↘ " + cod14);
                            }else if (i==3){
                                tvv.setText(Html.fromHtml(  epochToIso8601(rodModel.getData().get(rodModel.getData().size() - 2).getTime()) + " : close = "
                                        + rodModel.getData().get(rodModel.getData().size() - 2).getClose() + "<br><br>" +epochToIso8601(rodModel.getData().get(0).getTime()) + " : close = "
                                        + rodModel.getData().get(0).getClose() ));
                                if (cod25 > 0)
                                    tvv3.setText("25 Days ↗ " + cod25);
                                else
                                    tvv3.setText("25 Days ↘ " + cod25);
                            }

//                           // String mystring = ;
//                            tvv.setText(Html.fromHtml(epochToIso8601(rodModel.getData().get(rodModel.getData().size() - 2).getTime()) + " : close = "
//                                    + rodModel.getData().get(rodModel.getData().size() - 2).getClose() + "<br><br>" +
//                                    epochToIso8601(rodModel.getData().get(433).getTime()) + " : close = "
//                                    + rodModel.getData().get(433).getClose() + "<br><br>" +
//                                    epochToIso8601(rodModel.getData().get(265).getTime()) + " : close = "
//                                    + rodModel.getData().get(265).getClose() + "<br><br>" +
//                                    epochToIso8601(rodModel.getData().get(0).getTime()) + " : close = "
//                                    + rodModel.getData().get(0).getClose() ));

//                            if (cod7 > 0)
//                                tv_1.setText("↗ " + cod7);
//                            else
//                                tv_1.setText("↘ " + cod7);
//                            if (cod14 > 0)
//                                tv_2.setText("↗ " + cod14);
//                            else
//                                tv_2.setText("↘ " + cod14);
//                            if (cod14 > 0)
//                                tv_3.setText("↗ " + cod14);
//                            else
//                                tv_3.setText("↘ " + cod14);
//                            if (cod25 > 0)
//                                tv_4.setText("↗ " + cod25);
//                            else
//                                tv_4.setText("↘ " + cod25);
//                            if (cod25 > 0)
//                                tv_5.setText("↗ " + cod25);
//                            else
//                                tv_5.setText("↘ " + cod25);

                        } else {

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<RODModel> call, Throwable t) {
                    progressLayout.setVisibility(View.GONE);
                    String erro = t.getMessage();
                    try {

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } else {

            Snackbar.make(findViewById(android.R.id.content), R.string.check_internet, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Respond to the click, such as by undoing the modification that caused
                            // this message to be displayed
                            getCOD(i);
                        }
                    }).show();
        }
    }

    String epochToIso8601(long time) {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(time * 1000));
    }
}