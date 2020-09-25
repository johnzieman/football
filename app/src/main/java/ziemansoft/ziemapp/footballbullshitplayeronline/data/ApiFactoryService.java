package ziemansoft.ziemapp.footballbullshitplayeronline.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ziemansoft.ziemapp.footballbullshitplayeronline.pojo.ResponseResult;

public interface ApiFactoryService {
    @GET("3/person/popular")
    Observable<ResponseResult> getActor(@Query("api_key") String key);
}
