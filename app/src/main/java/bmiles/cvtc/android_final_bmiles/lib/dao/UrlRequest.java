package bmiles.cvtc.android_final_bmiles.lib.dao;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UrlRequest {

    OkHttpClient c = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = c.newCall(request).execute()) {
            return response.body().toString();
        } catch (IOException e) {
            Log.d("UrlRequest", e.getMessage());
            return e.toString();
        }

    }

}
