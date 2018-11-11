package soexample.umeng.com.zhoukao1.net;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    private static final int HTTP_SUCCESS = 100;
    private static final int HTTP_FAIL = 101;

    public HttpUtils get(String url) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(HTTP_FAIL);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message = Message.obtain();
                message.what = HTTP_SUCCESS;
                message.obj = string;
                handler.sendMessage(message);
            }
        });
        return this;
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case HTTP_SUCCESS:
                    String data = (String) msg.obj;
                    listener.success(data);
                    break;

                case HTTP_FAIL:
                    listener.fail();
                    break;
            }
        }
    };
    private HttpListener listener;

    public void result(HttpListener listener) {
        this.listener = listener;
    }

    public interface HttpListener {
        void success(String data);

        void fail();

    }
}
