package soexample.umeng.com.zhoukao1;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import soexample.umeng.com.zhoukao1.model.PubusBeanUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        PubusBeanUtils.getPubusBeanUtils().init(this);
    }
}
