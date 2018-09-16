package com.shellhacks.josephkocis.weatherornot;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;



import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;
import android.widget.Toast;

public class WeatherActivity extends AppCompatActivity {

    public static final String TAG = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        String apiKey = "1c3c38f72bfcbc7383f35d598f046aec";
        double latitude = 25.7574;
        double longitude = -80.3733;

        String forecastURL = "https://api.darksky.net/forecast/" + apiKey +
                "/" + latitude + "," + longitude;

        if (isNetworkAvailable()) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(forecastURL).build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        Log.v(TAG, response.body().string());
                        if (response.isSuccessful()) {
                            currentWeather = getCur
                        } else {
                            alertUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "IO Exception caught ", e);
                    }
                }
            });

        }







    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        } else {
            Toast.makeText(this, "Sorry, the network is unavailable.",
                    Toast.LENGTH_LONG).show();
        }

        return isAvailable;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getSupportFragmentManager(), "Error");
    }


}

