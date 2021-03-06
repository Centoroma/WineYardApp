package com.example.cento.wineyardapp.DB.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.cento.wineyardapp.DB.Contract;
import com.example.cento.wineyardapp.DB.Object.Worker;
import com.example.cento.wineyardapp.DB.SQLhelper;

/**
 * Created by Cento on 19.04.2017.
 */

public class WorkerDataSource {
    private final SQLiteDatabase db;

    public WorkerDataSource(Context context){
        SQLhelper sqliteHelper = SQLhelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
    }

    /**
     * Insert a new worker
     */
    public long createWorker(Worker worker){
        long id;
        ContentValues values = new ContentValues();
        values.put(Contract.WorkerEntry.KEY_FIRSTNAME, worker.getFirstName());
        values.put(Contract.WorkerEntry.KEY_LASTNAME, worker.getLastName());
        values.put(Contract.WorkerEntry.KEY_PHONE, worker.getPhone());
        values.put(Contract.WorkerEntry.KEY_MAIL, worker.getMail());
        id = this.db.insert(Contract.WorkerEntry.TABLE_WORKER, null, values);
        return id;
    }

    /**
     * Find one Worker by Id
     */
    public Worker getWorkerById(long id){
        String sql = "SELECT * FROM " + Contract.WorkerEntry.TABLE_WORKER +
                " WHERE " + Contract.WorkerEntry.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Worker worker = new Worker();
        worker.setId(cursor.getInt(cursor.getColumnIndex(Contract.WorkerEntry.KEY_ID)));
        worker.setFirstName(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_FIRSTNAME)));
        worker.setLastName(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_LASTNAME)));
        worker.setPhone(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_PHONE)));
        worker.setMail(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_MAIL)));

        cursor.close();
        return worker;
    }

    /**
     * Get all Workers
     */
    public List<Worker> getAllWorkers(){
        List<Worker> workers = new ArrayList<>();
        String sql = "SELECT * FROM " + Contract.WorkerEntry.TABLE_WORKER + " ORDER BY " + Contract.WorkerEntry.KEY_LASTNAME;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Worker worker = new Worker();
                worker.setId(cursor.getInt(cursor.getColumnIndex(Contract.WorkerEntry.KEY_ID)));
                worker.setFirstName(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_FIRSTNAME)));
                worker.setLastName(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_LASTNAME)));
                worker.setPhone(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_PHONE)));
                worker.setMail(cursor.getString(cursor.getColumnIndex(Contract.WorkerEntry.KEY_MAIL)));

                workers.add(worker);
            } while(cursor.moveToNext());
        }

        cursor.close();
        return workers;
    }

    /**
     *  Update a Worker
     */
    public int updateWorker(Worker worker){
        ContentValues values = new ContentValues();
        values.put(Contract.WorkerEntry.KEY_FIRSTNAME, worker.getFirstName());
        values.put(Contract.WorkerEntry.KEY_LASTNAME, worker.getLastName());
        values.put(Contract.WorkerEntry.KEY_PHONE, worker.getPhone());
        values.put(Contract.WorkerEntry.KEY_MAIL, worker.getMail());

        return this.db.update(Contract.WorkerEntry.TABLE_WORKER, values, Contract.WorkerEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(worker.getId()) });
    }

    /**
     * Delete a Worker - this will also delete all his job ?????
     * for the worker
     */

   /* public void deleteWorker(long id){
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
