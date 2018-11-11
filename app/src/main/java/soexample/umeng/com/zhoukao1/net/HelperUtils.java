package soexample.umeng.com.zhoukao1.net;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelperUtils {

    private BaseService baseService;
    private Callback<ResponseBody> callBack = new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful() && response.code() == 200) {
                try {
                    listeners.success(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                listeners.fail(response.message());
            }

        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            listeners.fail(t.getMessage());
        }
    };

    public HelperUtils() {
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.zhaoapi.cn/")
                .build();
        baseService = retrofit.create(BaseService.class);
    }

    ;

    //get请求
    public HelperUtils get(String url, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        baseService.get(url, map).enqueue(callBack);
        return this;
    }

    //post请求
    public HelperUtils post(String url, Map<String, String> map) {
        baseService.post(url, map).enqueue(callBack);
        return this;
    }

    private HttpListeners listeners;

    public void result(HttpListeners listeners) {
        this.listeners = listeners;
    }

    public interface HttpListeners {
        void success(String data);

        void fail(String error);
    }
}
