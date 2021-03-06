package com.example.cento.wineyardapp.DB;

import android.provider.BaseColumns;

/**
 * Created by Cento on 11.04.2017.
 */

public final class Contract {

        public Contract(){
            //empty constructor
            //should never be instantiate
        }

        //Represents the rows of a table
        public static abstract class WorkerEntry implements BaseColumns{
            //Table name
            public static final String TABLE_WORKER = "worker";

            //Person Column names
            public static final String KEY_ID = "id";
            public static final String KEY_LASTNAME = "lastName";
            public static final String KEY_FIRSTNAME = "firstName";
            public static final String KEY_PHONE = "phone";
            public static final String KEY_MAIL = "mail";

            //Table person create statement
            public static final String CREATE_TABLE_WORKER = "CREATE TABLE "
                    + TABLE_WORKER + "("
                    + WorkerEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                    + WorkerEntry.KEY_LASTNAME + " TEXT, "
                    + WorkerEntry.KEY_FIRSTNAME+ " TEXT, "
                    + WorkerEntry.KEY_PHONE +"TEXT, "
                    + WorkerEntry.KEY_MAIL + " TEXT "
                    + ");";


        }

        public static abstract class JobEntry implements BaseColumns{
            //Table name
            public static final String TABLE_JOB = "job";

            //Record Column names
            public static final String KEY_ID = "id";
            public static final String KEY_DESCRIPTION = "description";
            public static final String KEY_DEADLINE= "deadline";
            public static final String KEY_WINELOT_ID = "winelot_id";
            public static final String KEY_WORKER_ID = "worker_id";


            //Table record create statement
            public static final String CREATE_TABLE_JOB = "CREATE TABLE "
                    + TABLE_JOB + "("
                    + JobEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                    + JobEntry.KEY_DESCRIPTION + " TEXT, "
                    + JobEntry.KEY_DEADLINE + " TEXT, "
                    + "FOREIGN KEY (" + KEY_WINELOT_ID +") REFERENCES " + WineLotEntry.TABLE_WINELOT+ " (" + KEY_ID + "), "
                    + "FOREIGN KEY (" + KEY_WORKER_ID +") REFERENCES " + WorkerEntry.TABLE_WORKER+ " (" + KEY_ID + "), "
                    + ");";
        }

    public static abstract class WineLotEntry implements BaseColumns{
        //Table name
        public static final String TABLE_WINELOT = "wineLot";

        //Record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME= "name";
        public static final String KEY_SURFACE = "surface" ;
        public static final String KEY_NUMWINESTOCK= "numWineStock" ;
        public static final String KEY_PICTURE= "picture";
        public static final String KEY_WINEVARIETY_ID = "winevariety id";
        public static final String KEY_ORIENTATION_ID = "ORIENTATION id";



        //Table record create statement
        public static final String CREATE_TABLE_WINELOT= "CREATE TABLE "
                + TABLE_WINELOT + "("
                + WineLotEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + WineLotEntry.KEY_NAME + " DATETIME, "
                + WineLotEntry.KEY_SURFACE + " TEXT, "
                + WineLotEntry.KEY_NUMWINESTOCK + " TEXT, "
                + WineLotEntry.KEY_PICTURE + " TEXT, "
                + "FOREIGN KEY (" + KEY_WINEVARIETY_ID +") REFERENCES " + WineVarietyEntry.TABLE_WINEVARIETY+ " (" + KEY_ID + "), "
                + "FOREIGN KEY (" + KEY_ORIENTATION_ID +") REFERENCES " + OrientationEntry.TABLE_ORIENTATION+ " (" + KEY_ID + "), "
                + ");";
    }

    public static abstract class WineVarietyEntry implements BaseColumns{
        //Table name
        public static final String TABLE_WINEVARIETY= "wine variety";

        //Record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME= "name";


        //Table record create statement
        public static final String CREATE_TABLE_WINEVARIETY = "CREATE TABLE "
                + TABLE_WINEVARIETY + "("
                + WineVarietyEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + WineVarietyEntry.KEY_NAME + " TEXT, "
                + ");";
    }

    public static abstract class OrientationEntry implements BaseColumns{
        //Table name
        public static final String TABLE_ORIENTATION = "orientation";

        //Record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME= "name";


        //Table record create statement
        public static final String CREATE_TABLE_ORIENTATION = "CREATE TABLE "
                + TABLE_ORIENTATION + "("
                + WineVarietyEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + WineVarietyEntry.KEY_NAME + " TEXT, "
                + ");";
    }
}
