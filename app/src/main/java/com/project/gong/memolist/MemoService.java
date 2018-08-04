package com.project.gong.memolist;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MemoService {
    @POST("createToken")
    Call<TokenResult>createToken();

    @GET("checkToken")
    Call<ValidResult>checkToken(@Query("token") String token);

    @POST("backup")
    Call<BaseResult>backup(@Body BackupRequest body);
    //포스트같은경우는 리퀘스트가 까다로움 이제 바디를 써야할때가옴!!

    //리퀘스트에 넣어줄려고 만듬
    //백업 api설계가 끝났음.. !!!!
    //이제 백 겟업설계를하면됨..
    //네이밍을좀생각해보기... getbackup
    @GET("backup")
    Call<GetBackUpResult>getBackup(@Query("token") String token);


}
