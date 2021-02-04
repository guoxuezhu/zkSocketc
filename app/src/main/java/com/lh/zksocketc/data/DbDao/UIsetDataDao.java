package com.lh.zksocketc.data.DbDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.lh.zksocketc.data.model.UIsetData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "UISET_DATA".
*/
public class UIsetDataDao extends AbstractDao<UIsetData, Void> {

    public static final String TABLENAME = "UISET_DATA";

    /**
     * Properties of entity UIsetData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Btn_1_status = new Property(0, String.class, "btn_1_status", false, "BTN_1_STATUS");
        public final static Property Btn_2_status = new Property(1, String.class, "btn_2_status", false, "BTN_2_STATUS");
        public final static Property Btn_3_status = new Property(2, String.class, "btn_3_status", false, "BTN_3_STATUS");
        public final static Property Btn_4_status = new Property(3, String.class, "btn_4_status", false, "BTN_4_STATUS");
        public final static Property Btn_5_status = new Property(4, String.class, "btn_5_status", false, "BTN_5_STATUS");
        public final static Property Btn_6_status = new Property(5, String.class, "btn_6_status", false, "BTN_6_STATUS");
        public final static Property Btn_7_status = new Property(6, String.class, "btn_7_status", false, "BTN_7_STATUS");
        public final static Property Btn_8_status = new Property(7, String.class, "btn_8_status", false, "BTN_8_STATUS");
        public final static Property Btn_9_status = new Property(8, String.class, "btn_9_status", false, "BTN_9_STATUS");
    }


    public UIsetDataDao(DaoConfig config) {
        super(config);
    }
    
    public UIsetDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"UISET_DATA\" (" + //
                "\"BTN_1_STATUS\" TEXT," + // 0: btn_1_status
                "\"BTN_2_STATUS\" TEXT," + // 1: btn_2_status
                "\"BTN_3_STATUS\" TEXT," + // 2: btn_3_status
                "\"BTN_4_STATUS\" TEXT," + // 3: btn_4_status
                "\"BTN_5_STATUS\" TEXT," + // 4: btn_5_status
                "\"BTN_6_STATUS\" TEXT," + // 5: btn_6_status
                "\"BTN_7_STATUS\" TEXT," + // 6: btn_7_status
                "\"BTN_8_STATUS\" TEXT," + // 7: btn_8_status
                "\"BTN_9_STATUS\" TEXT);"); // 8: btn_9_status
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"UISET_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UIsetData entity) {
        stmt.clearBindings();
 
        String btn_1_status = entity.getBtn_1_status();
        if (btn_1_status != null) {
            stmt.bindString(1, btn_1_status);
        }
 
        String btn_2_status = entity.getBtn_2_status();
        if (btn_2_status != null) {
            stmt.bindString(2, btn_2_status);
        }
 
        String btn_3_status = entity.getBtn_3_status();
        if (btn_3_status != null) {
            stmt.bindString(3, btn_3_status);
        }
 
        String btn_4_status = entity.getBtn_4_status();
        if (btn_4_status != null) {
            stmt.bindString(4, btn_4_status);
        }
 
        String btn_5_status = entity.getBtn_5_status();
        if (btn_5_status != null) {
            stmt.bindString(5, btn_5_status);
        }
 
        String btn_6_status = entity.getBtn_6_status();
        if (btn_6_status != null) {
            stmt.bindString(6, btn_6_status);
        }
 
        String btn_7_status = entity.getBtn_7_status();
        if (btn_7_status != null) {
            stmt.bindString(7, btn_7_status);
        }
 
        String btn_8_status = entity.getBtn_8_status();
        if (btn_8_status != null) {
            stmt.bindString(8, btn_8_status);
        }
 
        String btn_9_status = entity.getBtn_9_status();
        if (btn_9_status != null) {
            stmt.bindString(9, btn_9_status);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UIsetData entity) {
        stmt.clearBindings();
 
        String btn_1_status = entity.getBtn_1_status();
        if (btn_1_status != null) {
            stmt.bindString(1, btn_1_status);
        }
 
        String btn_2_status = entity.getBtn_2_status();
        if (btn_2_status != null) {
            stmt.bindString(2, btn_2_status);
        }
 
        String btn_3_status = entity.getBtn_3_status();
        if (btn_3_status != null) {
            stmt.bindString(3, btn_3_status);
        }
 
        String btn_4_status = entity.getBtn_4_status();
        if (btn_4_status != null) {
            stmt.bindString(4, btn_4_status);
        }
 
        String btn_5_status = entity.getBtn_5_status();
        if (btn_5_status != null) {
            stmt.bindString(5, btn_5_status);
        }
 
        String btn_6_status = entity.getBtn_6_status();
        if (btn_6_status != null) {
            stmt.bindString(6, btn_6_status);
        }
 
        String btn_7_status = entity.getBtn_7_status();
        if (btn_7_status != null) {
            stmt.bindString(7, btn_7_status);
        }
 
        String btn_8_status = entity.getBtn_8_status();
        if (btn_8_status != null) {
            stmt.bindString(8, btn_8_status);
        }
 
        String btn_9_status = entity.getBtn_9_status();
        if (btn_9_status != null) {
            stmt.bindString(9, btn_9_status);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public UIsetData readEntity(Cursor cursor, int offset) {
        UIsetData entity = new UIsetData( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // btn_1_status
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // btn_2_status
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // btn_3_status
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // btn_4_status
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // btn_5_status
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // btn_6_status
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // btn_7_status
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // btn_8_status
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // btn_9_status
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UIsetData entity, int offset) {
        entity.setBtn_1_status(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setBtn_2_status(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBtn_3_status(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBtn_4_status(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBtn_5_status(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setBtn_6_status(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setBtn_7_status(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setBtn_8_status(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setBtn_9_status(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(UIsetData entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(UIsetData entity) {
        return null;
    }

    @Override
    public boolean hasKey(UIsetData entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}