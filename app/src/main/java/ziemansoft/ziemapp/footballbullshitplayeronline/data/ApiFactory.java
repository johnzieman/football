package ziemansoft.ziemapp.footballbullshitplayeronline.data;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private static final String BASE_URL = "https://api.themoviedb.org/";
    private static ApiFactory apiFactory;
    private Retrofit retrofit;

    public ApiFactory(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL).build();
    }

    public static ApiFactory getInstance() {
        if (apiFactory == null) {
            apiFactory = new ApiFactory();
        }
        return apiFactory;
    }
    public  ApiFactoryService getServise(){
        return retrofit.create(ApiFactoryService.class);
    }
}
