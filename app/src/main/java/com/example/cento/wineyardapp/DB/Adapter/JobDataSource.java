package com.example.cento.wineyardapp.DB.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.cento.wineyardapp.DB.Contract;
import com.example.cento.wineyardapp.DB.Object.Job;
import com.example.cento.wineyardapp.DB.SQLhelper;

/**
 * Created by Cento on 19.04.2017.
 */

public class JobDataSource {
    private SQLiteDatabase db;
    private Context context;

    public JobDataSource(Context context){
        SQLhelper sqliteHelper = SQLhelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;
    }

    /**
     * Insert a new job
     */
    public long createJob(Job job){
        long id;
        ContentValues values = new ContentValues();
        values.put(Contract.JobEntry.KEY_DESCRIPTION, job.getDescription());
        values.put(Contract.JobEntry.KEY_DEADLINE, job.getDeadline());
        values.put(Contract.JobEntry.KEY_WINELOT_ID, job.getWinelotId());
        values.put(Contract.JobEntry.KEY_WORKER_ID, job.getWorkerId());
        id = this.db.insert(Contract.JobEntry.TABLE_JOB, null, values);
        return id;
    }

    /**
     * Find one Job by Id
     */
    public Job getJobById(long id){
        String sql = "SELECT * FROM " + Contract.JobEntry.TABLE_JOB +
                " WHERE " + Contract.JobEntry.KEY_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Job job = new Job();
        job.setId(cursor.getInt(cursor.getColumnIndex(Contract.JobEntry.KEY_ID)));
        job.setDescription(cursor.getString(cursor.getColumnIndex(Contract.JobEntry.KEY_DESCRIPTION)));
        job.setDeadline(cursor.getString(cursor.getColumnIndex(Contract.JobEntry.KEY_DEADLINE)));
        job.setWinelotId(cursor.getInt(cursor.getColumnIndex(Contract.JobEntry.KEY_WINELOT_ID)));
        job.setWorkerId(cursor.getInt(cursor.getColumnIndex(Contract.JobEntry.KEY_WORKER_ID)));

        return job;
    }

    /**
     * Get all Jobs
     */
    public List<Job> getAllJobs(){
        List<Job> jobs = new ArrayList<Job>();
        String sql = "SELECT * FROM " + Contract.JobEntry.TABLE_JOB + " ORDER BY " + Contract.JobEntry.KEY_DEADLINE;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Job job = new Job();
                job.setId(cursor.getInt(cursor.getColumnIndex(Contract.JobEntry.KEY_ID)));
                job.setDescription(cursor.getString(cursor.getColumnIndex(Contract.JobEntry.KEY_DESCRIPTION)));
                job.setDeadline(cursor.getString(cursor.getColumnIndex(Contract.JobEntry.KEY_DEADLINE)));
                job.setWinelotId(cursor.getInt(cursor.getColumnIndex(Contract.JobEntry.KEY_WINELOT_ID)));
                job.setWorkerId(cursor.getInt(cursor.getColumnIndex(Contract.JobEntry.KEY_WORKER_ID)));

                jobs.add(job);
            } while(cursor.moveToNext());
        }

        return jobs;
    }

    /**
     *  Update a Job
     */
    public int updateJob(Job job){
        ContentValues values = new ContentValues();
        values.put(Contract.JobEntry.KEY_DESCRIPTION, job.getDescription());
        values.put(Contract.JobEntry.KEY_DEADLINE, job.getDeadline());
        values.put(Contract.JobEntry.KEY_WINELOT_ID, job.getWinelotId());
        values.put(Contract.JobEntry.KEY_WORKER_ID, job.getWorkerId());

        return this.db.update(Contract.JobEntry.TABLE_JOB, values, Contract.JobEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(job.getId()) });
    }

    /**
     * Delete a Job - this will also delete all his job ?????
     * for the Job
     */

   /* public void deleteJob(long id){
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
