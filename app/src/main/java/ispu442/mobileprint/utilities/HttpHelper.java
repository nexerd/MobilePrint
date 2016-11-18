package ispu442.mobileprint.utilities;

import android.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import okhttp3.Response;


public class HttpHelper {

    private static final String url = "http://192.168.0.175:3000/mobile/";

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
                private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

                @Override
                public void saveFromResponse(HttpUrl _url, List<Cookie> cookies) {
                    cookieStore.put(url, cookies);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl _url) {
                    List<Cookie> cookies = cookieStore.get(url);
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            })
            .build();


    public static String GET(String address) throws IOException
    {
        Request request = new Request.Builder()
                .url(url + address)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String POST(String address, String json)  throws IOException
    {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url + address)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
