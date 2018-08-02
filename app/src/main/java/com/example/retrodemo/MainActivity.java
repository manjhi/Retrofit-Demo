package com.example.retrodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);

        Call<List<RouteData>> call=api.getrouteData();

        call.enqueue(new Callback<List<RouteData>>() {
            @Override
            public void onResponse(Call<List<RouteData>> call, Response<List<RouteData>> response) {
                List<RouteData> routeData=response.body();

                for (RouteData r:routeData){
                    Log.d( "onResponse: ",r.getResponse_code());
                }
            }

            @Override
            public void onFailure(Call<List<RouteData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t+" ", Toast.LENGTH_SHORT).show();
                Log.d("onFailure: ",t.toString());
            }
        });
    }
}
