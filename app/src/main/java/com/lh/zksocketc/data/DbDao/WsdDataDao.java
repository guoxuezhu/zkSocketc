package com.lh.zksocketc.data.DbDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.lh.zksocketc.data.model.WsdData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WSD_DATA".
*/
public class WsdDataDao extends AbstractDao<WsdData, Void> {

    public static final String TABLENAME = "WSD_DATA";

    /**
     * Properties of entity WsdData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Wendu = new Property(0, String.class, "wendu", false, "WENDU");
        public final static Property Shidu = new Property(1, String.class, "shidu", false, "SHIDU");
        public final static Property Pm25 = new Property(2, String.class, "pm25", false, "PM25");
    }


    public WsdDataDao(DaoConfig config) {
        super(config);
    }
    
    public WsdDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WSD_DATA\" (" + //
                "\"WENDU\" TEXT," + // 0: wendu
                "\"SHIDU\" TEXT," + // 1: shidu
                "\"PM25\" TEXT);"); // 2: pm25
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WSD_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, WsdData entity) {
        stmt.clearBindings();
 
        String wendu = entity.getWendu();
        if (wendu != null) {
            stmt.bindString(1, wendu);
        }
 
        String shidu = entity.getShidu();
        if (shidu != null) {
            stmt.bindString(2, shidu);
        }
 
        String pm25 = entity.getPm25();
        if (pm25 != null) {
            stmt.bindString(3, pm25);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, WsdData entity) {
        stmt.clearBindings();
 
        String wendu = entity.getWendu();
        if (wendu != null) {
            stmt.bindString(1, wendu);
        }
 
        String shidu = entity.getShidu();
        if (shidu != null) {
            stmt.bindString(2, shidu);
        }
 
        String pm25 = entity.getPm25();
        if (pm25 != null) {
            stmt.bindString(3, pm25);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public WsdData readEntity(Cursor cursor, int offset) {
        WsdData entity = new WsdData( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // wendu
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // shidu
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // pm25
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, WsdData entity, int offset) {
        entity.setWendu(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setShidu(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPm25(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(WsdData entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(WsdData entity) {
        return null;
    }

    @Override
    public boolean hasKey(WsdData entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}