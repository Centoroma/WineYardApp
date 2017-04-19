package DB.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DB.Contract;
import DB.Object.WineLot;
import DB.Object.WineLot;
import DB.SQLhelper;

/**
 * Created by Cento on 19.04.2017.
 */

public class WineLotDataSource {
    private SQLiteDatabase db;
    private Context context;

    public WineLotDataSource(Context context){
        SQLhelper sqliteHelper = SQLhelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;
    }

    /**
     * Insert a new WineLot
     */
    public long createWineLot(WineLot wineLot){
        long id;
        ContentValues values = new ContentValues();
        values.put(Contract.WineLotEntry.KEY_NAME, wineLot.getName());
        values.put(Contract.WineLotEntry.KEY_PICTURE, wineLot.getPicture());
        values.put(Contract.WineLotEntry.KEY_NUMWINESTOCK, wineLot.getNumberWineStock());
        values.put(Contract.WineLotEntry.KEY_SURFACE, wineLot.getSurface());
        id = this.db.insert(Contract.WineLotEntry.TABLE_WINELOT, null, values);
        return id;
    }

    /**
     * Find one WineLot by Id
     */
    public WineLot getWineLotById(long id){
        String sql = "SELECT * FROM " + Contract.WineLotEntry.TABLE_WINELOT +
                " WHERE " + Contract.WineLotEntry.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        WineLot wineLot = new WineLot();
        wineLot.setId(cursor.getInt(cursor.getColumnIndex(Contract.WineLotEntry.KEY_ID)));
        wineLot.setName(cursor.getString(cursor.getColumnIndex(Contract.WineLotEntry.KEY_NAME)));
        wineLot.setPicture(cursor.getString(cursor.getColumnIndex(Contract.WineLotEntry.KEY_PICTURE)));
        wineLot.setNumberWineStock(cursor.getInt(cursor.getColumnIndex(Contract.WineLotEntry.KEY_NUMWINESTOCK)));
        wineLot.setSurface(cursor.getFloat(cursor.getColumnIndex(Contract.WineLotEntry.KEY_SURFACE)));

        return wineLot;
    }

    /**
     * Get all WineLots
     */
    public List<WineLot> getAllWineLots(){
        List<WineLot> WineLots = new ArrayList<WineLot>();
        String sql = "SELECT * FROM " + Contract.WineLotEntry.TABLE_WINELOT + " ORDER BY " + Contract.WineLotEntry.KEY_NAME;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                WineLot wineLot = new WineLot();
                wineLot.setId(cursor.getInt(cursor.getColumnIndex(Contract.WineLotEntry.KEY_ID)));
                wineLot.setName(cursor.getString(cursor.getColumnIndex(Contract.WineLotEntry.KEY_NAME)));
                wineLot.setPicture(cursor.getString(cursor.getColumnIndex(Contract.WineLotEntry.KEY_PICTURE)));
                wineLot.setNumberWineStock(cursor.getInt(cursor.getColumnIndex(Contract.WineLotEntry.KEY_NUMWINESTOCK)));
                wineLot.setSurface(cursor.getFloat(cursor.getColumnIndex(Contract.WineLotEntry.KEY_SURFACE)));

                WineLots.add(wineLot);
            } while(cursor.moveToNext());
        }

        return WineLots;
    }

    /**
     *  Update a WineLot
     */
    public int updateWineLot(WineLot wineLot){
        ContentValues values = new ContentValues();
        values.put(Contract.WineLotEntry.KEY_NAME, wineLot.getName());
        values.put(Contract.WineLotEntry.KEY_PICTURE, wineLot.getPicture());
        values.put(Contract.WineLotEntry.KEY_NUMWINESTOCK, wineLot.getNumberWineStock());
        values.put(Contract.WineLotEntry.KEY_SURFACE, wineLot.getSurface());

        return this.db.update(Contract.WineLotEntry.TABLE_WINELOT, values, Contract.WineLotEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(wineLot.getId()) });
    }

    /**
     * TODO
     * Delete a WineLot - this will also delete all his WineLot ?????
     * for the WineLot
     */

   /* public void deleteWineLot(long id){
        RecordDataSource pra = new RecordDataSource(context);
        //get all records of the user
        List<Record> records = pra.getAllRecordsByPerson(id);

        for(Record record : records){
            pra.deleteRecord(record.getId());
        }

        //delete the person
        this.db.delete(PersonEntry.TABLE_PERSON, PersonEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(id) });

    }*/
}
