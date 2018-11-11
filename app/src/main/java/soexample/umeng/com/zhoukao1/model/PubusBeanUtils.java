package soexample.umeng.com.zhoukao1.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import soexample.umeng.com.zhoukao1.greendao.DaoMaster;
import soexample.umeng.com.zhoukao1.greendao.PubusBeanDao;

public class PubusBeanUtils {
    private PubusBeanDao pubusBeanDao;

    private PubusBeanUtils() {
    }

    ;

    private static PubusBeanUtils pubusBeanUtils;

    public static PubusBeanUtils getPubusBeanUtils() {

        if (pubusBeanUtils == null) {
            pubusBeanUtils = new PubusBeanUtils();
        }
        return pubusBeanUtils;
    }

    public void init(Context context) {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "erq");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        pubusBeanDao = daoMaster.newSession().getPubusBeanDao();

    }

    //增加
    public void insert(PubusBean pubusBean) {
        pubusBeanDao.insert(pubusBean);
    }

    //查询
    public List<PubusBean> query() {
        return pubusBeanDao.loadAll();
    }

    //删除
    public void delete() {

        pubusBeanDao.deleteAll();
    }
}
