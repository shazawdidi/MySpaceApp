//package com.task.myspaceapp.data;
//
//import android.app.Application;
//import android.content.Context;
//import android.util.Log;
//
//import com.google.android.gms.common.api.Api;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import net.orderpharma.pharmacyapp.utility.LocalSession;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import dimitrovskif.smartcache.BasicCaching;
//import dimitrovskif.smartcache.SmartCallFactory;
//import okhttp3.Cache;
//import okhttp3.CacheControl;
//import okhttp3.ConnectionSpec;
//import okhttp3.Interceptor;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Protocol;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
////import okhttp3.logging.HttpLoggingInterceptor;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//
//public class ApiClient  {
//
//    private static final String TAG = "ServiceGenerator";
//     public static final String HEADER_CACHE_CONTROL = "Cache-Control";
//    public static final String HEADER_PRAGMA = "Pragma";
//
//    private static ApiClient instance;
//    private static Context context;
//    private static Retrofit retrofit;
//
//
//    private static final long cacheSize =100 * 1024 * 1024; // 5 MB
//    public ApiClient(Context ctx) {
//        this.context = ctx;
//    }
//    public static Retrofit getClient(String baseUrl) {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//        List<Protocol> protocols = new ArrayList<>();
//        protocols.add(Protocol.HTTP_1_1);
//        protocols.add(Protocol.HTTP_2);
//
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//        RequestBody body = RequestBody.create(mediaType, "searchText=&apiKey=501edc9e");
//        Request request = new Request.Builder()
//                .url("https://myscrap.com/api/msDiscoverPage")
//                .method("POST", body)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                .addHeader("Cookie", "ci_session=922d09e855ef16a52b4e7b963ce82dd661a705e3")
//                .build();
//
//
//        Gson gson = new GsonBuilder()
//                .setLenient().setLenient()
//                .serializeNulls()
//                .create();
//
//
//        return null;
//    }
//
//
//
//
//}