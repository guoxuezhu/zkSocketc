package com.lh.zksocketc.data.DbDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.lh.zksocketc.data.model.IcCardNumer;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "IC_CARD_NUMER".
*/
public class IcCardNumerDao extends AbstractDao<IcCardNumer, Void> {

    public static final String TABLENAME = "IC_CARD_NUMER";

    /**
     * Properties of entity IcCardNumer.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CardNum = new Property(0, String.class, "cardNum", false, "CARD_NUM");
    }


    public IcCardNumerDao(DaoConfig config) {
        super(config);
    }
    
    public IcCardNumerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"IC_CARD_NUMER\" (" + //
                "\"CARD_NUM\" TEXT);"); // 0: cardNum
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"IC_CARD_NUMER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, IcCardNumer entity) {
        stmt.clearBindings();
 
        String cardNum = entity.getCardNum();
        if (cardNum != null) {
            stmt.bindString(1, cardNum);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, IcCardNumer entity) {
        stmt.clearBindings();
 
        String cardNum = entity.getCardNum();
        if (cardNum != null) {
            stmt.bindString(1, cardNum);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public IcCardNumer readEntity(Cursor cursor, int offset) {
        IcCardNumer entity = new IcCardNumer( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // cardNum
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, IcCardNumer entity, int offset) {
        entity.setCardNum(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(IcCardNumer entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(IcCardNumer entity) {
        return null;
    }

    @Override
    public boolean hasKey(IcCardNumer entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}