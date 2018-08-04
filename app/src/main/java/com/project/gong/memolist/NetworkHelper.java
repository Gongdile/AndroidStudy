package com.project.gong.memolist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    private static NetworkHelper instance=null;
    public static NetworkHelper getInstance(){
        if(instance == null)instance = new NetworkHelper();

        return instance;
        //instance를 가져오려면 init을 무조건 해야함

    }
    public Retrofit retrofit;
    public  MemoService memoService;

    private NetworkHelper(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://memobackup.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       MemoService service = retrofit.create(MemoService.class);
}
    //이게 안전한설계임 다른곳에서 만들지 못핟록 해버리기~~
    //그러면 인스턴스없을때 다른곳에서 new안되쟈나~~


//
    //init안쓰고 쓰는방법이있음
}
