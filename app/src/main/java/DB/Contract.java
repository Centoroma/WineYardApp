package DB;

import android.provider.BaseColumns;

import static DB.Contract.JobEntry.TABLE_JOB;
import static DB.Contract.WineVarietyEntry.TABLE_WINEVARIETY;

/**
 * Created by Cento on 11.04.2017.
 */

public final class Contract {

        public Contract(){
            //empty constructor
            //should never be instantiated
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


            //Table record create statement
            public static final String CREATE_TABLE_RECORD = "CREATE TABLE "
                    + TABLE_JOB + "("
                    + JobEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                    + JobEntry.KEY_DESCRIPTION + " DATETIME, "
                    + JobEntry.KEY_DEADLINE + " TEXT, "
                    + ");";
        }

    public static abstract class WineLotEntry implements BaseColumns{
        //Table name
        public static final String TABLE_WINELOT = "wineLot";

        //Record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME= "name";
        public static final float KEY_SURFACE = 0f ;
        public static final int KEY_NUMWINESTOCK= 0 ;
        public static final String KEY_PICTURE= "picture";



        //Table record create statement
        public static final String CREATE_TABLE_RECORD = "CREATE TABLE "
                + TABLE_WINELOT + "("
                + WineLotEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + WineLotEntry.KEY_NAME + " DATETIME, "
                + WineLotEntry.KEY_SURFACE + " TEXT, "
                + WineLotEntry.KEY_NUMWINESTOCK + " TEXT, "
                + WineLotEntry.KEY_PICTURE + " TEXT, "
                + ");";
    }

    public static abstract class WineVarietyEntry implements BaseColumns{
        //Table name
        public static final String TABLE_WINEVARIETY= "wine variety";

        //Record Column names
        public static final String KEY_ID = "id";
        public static final String KEY_NAME= "name";


        //Table record create statement
        public static final String CREATE_TABLE_RECORD = "CREATE TABLE "
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
        public static final String CREATE_TABLE_RECORD = "CREATE TABLE "
                + TABLE_ORIENTATION + "("
                + WineVarietyEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                + WineVarietyEntry.KEY_NAME + " TEXT, "
                + ");";
    }


    //Table de conneion
        //Represents the rows of a table
        public static abstract class PersonRecordEntry implements BaseColumns {
            //Table name
            public static final String TABLE_PERSON_RECORD = "person_record";

            //Table person_record Column names
            public static final String KEY_ID = "id";
            public static final String KEY_PERSON_ID = "person_id";
            public static final String KEY_RECORD_ID = "record_id";

            //Table person_record create statement
            public static final String CREATE_TABLE_PERSON_RECORD = "CREATE TABLE "
                    + TABLE_PERSON_RECORD + "("
                    + PersonRecordEntry.KEY_ID + " INTEGER PRIMARY KEY,"
                    + PersonRecordEntry.KEY_PERSON_ID + " INTEGER, "
                    + PersonRecordEntry.KEY_RECORD_ID + " INTEGER, "
                    + "FOREIGN KEY (" + KEY_PERSON_ID + ") REFERENCES " + WineLotEntry.TABLE_WINELOT+ " (" + KEY_ID + "), "
                    + "FOREIGN KEY (" + KEY_RECORD_ID + ") REFERENCES " + OrientationEntry.TABLE_ORIENTATION + " (" + KEY_ID +") "
                    + ");";
        }
}