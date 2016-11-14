package ispu442.mobileprint.utilities;

import android.util.Pair;

import java.io.IOException;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import okhttp3.Response;


public class HttpHelper {

    public static final String url = "http://192.168.0.175:3000/";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static String GET(String address) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + address)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String POST(String address, String json)  throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url + address)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
