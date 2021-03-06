package ru.rgordeev.httpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.rgordeev.httpexample.model.Currencies;

public class MainActivity extends AppCompatActivity {

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
    }

    public void getCurrencies(View view) {
        new HTTPConnection().execute();
    }

    public void cleanUp(View view) {

    }

    private class HTTPConnection extends AsyncTask<Void, Void, Currencies> {

        @Override
        protected void onPostExecute(Currencies currencies) {

            String key = "RUB";
            Double value = currencies.getRates().get(key);

            output.setText(String.format("1 EUR = %.2f RUB", value));
        }

        @Override
        protected Currencies doInBackground(Void... voids) {

            Currencies result;
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://api.exchangeratesapi.io/v1/latest?access_key=2a198fc99182d8257ec81baf79afe155&format=1")
                    .get()
                    .build();

            try {
                Response response = httpClient.newCall(request).execute();
                String text = response.body().string();
                result = new Gson().fromJson(text, Currencies.class);
            } catch (IOException e) {
                e.printStackTrace();
                result = null;
            }

            return result;
        }
    }
}
