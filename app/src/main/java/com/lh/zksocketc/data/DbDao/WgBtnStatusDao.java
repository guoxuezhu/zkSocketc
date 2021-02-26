package com.lh.zksocketc.data.DbDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.lh.zksocketc.data.model.WgBtnStatus;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WG_BTN_STATUS".
*/
public class WgBtnStatusDao extends AbstractDao<WgBtnStatus, Void> {

    public static final String TABLENAME = "WG_BTN_STATUS";

    /**
     * Properties of entity WgBtnStatus.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Lstatus1 = new Property(0, String.class, "Lstatus1", false, "LSTATUS1");
        public final static Property Lstatus2 = new Property(1, String.class, "Lstatus2", false, "LSTATUS2");
        public final static Property Mstatus1 = new Property(2, String.class, "Mstatus1", false, "MSTATUS1");
        public final static Property Mstatus2 = new Property(3, String.class, "Mstatus2", false, "MSTATUS2");
    }


    public WgBtnStatusDao(DaoConfig config) {
        super(config);
    }
    
    public WgBtnStatusDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WG_BTN_STATUS\" (" + //
                "\"LSTATUS1\" TEXT," + // 0: Lstatus1
                "\"LSTATUS2\" TEXT," + // 1: Lstatus2
                "\"MSTATUS1\" TEXT," + // 2: Mstatus1
                "\"MSTATUS2\" TEXT);"); // 3: Mstatus2
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WG_BTN_STATUS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, WgBtnStatus entity) {
        stmt.clearBindings();
 
        String Lstatus1 = entity.getLstatus1();
        if (Lstatus1 != null) {
            stmt.bindString(1, Lstatus1);
        }
 
        String Lstatus2 = entity.getLstatus2();
        if (Lstatus2 != null) {
            stmt.bindString(2, Lstatus2);
        }
 
        String Mstatus1 = entity.getMstatus1();
        if (Mstatus1 != null) {
            stmt.bindString(3, Mstatus1);
        }
 
        String Mstatus2 = entity.getMstatus2();
        if (Mstatus2 != null) {
            stmt.bindString(4, Mstatus2);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, WgBtnStatus entity) {
        stmt.clearBindings();
 
        String Lstatus1 = entity.getLstatus1();
        if (Lstatus1 != null) {
            stmt.bindString(1, Lstatus1);
        }
 
        String Lstatus2 = entity.getLstatus2();
        if (Lstatus2 != null) {
            stmt.bindString(2, Lstatus2);
        }
 
        String Mstatus1 = entity.getMstatus1();
        if (Mstatus1 != null) {
            stmt.bindString(3, Mstatus1);
        }
 
        String Mstatus2 = entity.getMstatus2();
        if (Mstatus2 != null) {
            stmt.bindString(4, Mstatus2);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public WgBtnStatus readEntity(Cursor cursor, int offset) {
        WgBtnStatus entity = new WgBtnStatus( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // Lstatus1
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // Lstatus2
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Mstatus1
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // Mstatus2
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, WgBtnStatus entity, int offset) {
        entity.setLstatus1(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setLstatus2(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMstatus1(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMstatus2(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(WgBtnStatus entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(WgBtnStatus entity) {
        return null;
    }

    @Override
    public boolean hasKey(WgBtnStatus entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
