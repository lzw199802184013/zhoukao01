package soexample.umeng.com.zhoukao1.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import soexample.umeng.com.zhoukao1.model.PubusBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PUBUS_BEAN".
*/
public class PubusBeanDao extends AbstractDao<PubusBean, Long> {

    public static final String TABLENAME = "PUBUS_BEAN";

    /**
     * Properties of entity PubusBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Images = new Property(1, String.class, "images", false, "IMAGES");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Price = new Property(3, String.class, "price", false, "PRICE");
    }


    public PubusBeanDao(DaoConfig config) {
        super(config);
    }
    
    public PubusBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PUBUS_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"IMAGES\" TEXT," + // 1: images
                "\"TITLE\" TEXT," + // 2: title
                "\"PRICE\" TEXT);"); // 3: price
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PUBUS_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PubusBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String images = entity.getImages();
        if (images != null) {
            stmt.bindString(2, images);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(4, price);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PubusBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String images = entity.getImages();
        if (images != null) {
            stmt.bindString(2, images);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(4, price);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PubusBean readEntity(Cursor cursor, int offset) {
        PubusBean entity = new PubusBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // images
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // price
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PubusBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setImages(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPrice(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PubusBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PubusBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PubusBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
