package DB.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DB.Contract;
import DB.Object.WineVariety;
import DB.SQLhelper;

/**
 * Created by Cento on 19.04.2017.
 */

public class WineVarietyDataSource {
    private SQLiteDatabase db;
    private Context context;

    public WineVarietyDataSource(Context context){
        SQLhelper sqliteHelper = SQLhelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;
    }

    /**
     * Insert a new WineVariety
     */
    public long createWineVariety(WineVariety wineVariety){
        long id;
        ContentValues values = new ContentValues();
        values.put(Contract.WineVarietyEntry.KEY_NAME, wineVariety.getName());
        id = this.db.insert(Contract.WineVarietyEntry.TABLE_WINEVARIETY, null, values);
        return id;
    }

    /**
     * Find one WineVariety by Id
     */
    public WineVariety getWineVarietyById(long id){
        String sql = "SELECT * FROM " + Contract.WineVarietyEntry.TABLE_WINEVARIETY +
                " WHERE " + Contract.WineVarietyEntry.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        WineVariety wineVariety = new WineVariety();
        wineVariety.setId(cursor.getInt(cursor.getColumnIndex(Contract.WineVarietyEntry.KEY_ID)));
        wineVariety.setName(cursor.getString(cursor.getColumnIndex(Contract.WineVarietyEntry.KEY_NAME)));

        return wineVariety;
    }

    /**
     * Get all WineVarietys
     */
    public List<WineVariety> getAllWineVarietys(){
        List<WineVariety> wineVarietys = new ArrayList<WineVariety>();
        String sql = "SELECT * FROM " + Contract.WineVarietyEntry.TABLE_WINEVARIETY + " ORDER BY " + Contract.WineVarietyEntry.KEY_NAME;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                WineVariety wineVariety = new WineVariety();
                wineVariety.setId(cursor.getInt(cursor.getColumnIndex(Contract.WineVarietyEntry.KEY_ID)));
                wineVariety.setName(cursor.getString(cursor.getColumnIndex(Contract.WineVarietyEntry.KEY_NAME)));

                wineVarietys.add(wineVariety);
            } while(cursor.moveToNext());
        }

        return wineVarietys;
    }

    /**
     *  Update a WineVariety
     */
    public int updateWineVariety(WineVariety wineVariety){
        ContentValues values = new ContentValues();
        values.put(Contract.WineVarietyEntry.KEY_NAME, wineVariety.getName());

        return this.db.update(Contract.WineVarietyEntry.TABLE_WINEVARIETY, values, Contract.WineVarietyEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(wineVariety.getId()) });
    }

    /**
     * TODO
     * Delete a WineVariety - this will also delete all his WineVariety ?????
     * for the WineVariety
     */

   /* public void deleteWineVariety(long id){
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
