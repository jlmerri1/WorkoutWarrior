package hfad.com.workoutwarrior;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "my_db";
    private static final String TABLE = "exercises";
    private static final String NAME = "name";
    private static final String WEIGHT = "weight";
    private static final String REPS = "reps";
    private static final String DATE = "date";


    public DBHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+ TABLE+" (id integer primary key, "
                    + NAME + " text, " + WEIGHT + " text, " + REPS + " text, " + DATE + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertExercise(Exercise exercise){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put(NAME, exercise.getName());
            contentValues.put(WEIGHT, exercise.getWeight());
            contentValues.put(REPS, exercise.getReps());
            contentValues.put(DATE, exercise.getDate());
            db.insert(TABLE, null, contentValues);

            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean updateExercise(Exercise exercise){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put(NAME, exercise.getName());
            contentValues.put(WEIGHT, exercise.getWeight());
            contentValues.put(REPS, exercise.getReps());
            contentValues.put(DATE, exercise.getDate());
            db.update(TABLE,contentValues, "id = ?", new String[]{String.valueOf(exercise.getId())});

            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean deleteExercise(Exercise exercise){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE,"id = ?", new String[]{String.valueOf(exercise.getId())});
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public ArrayList<Exercise> getAllExercises() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();

        Cursor cur = db.rawQuery("select * from " + TABLE, null);
        cur.moveToFirst();
        try {

            while (cur.isAfterLast() == false) {
                Exercise e = new Exercise();
                e.setId(cur.getInt(cur.getColumnIndex("id")));
                e.setName(cur.getString(cur.getColumnIndex(NAME)));
                e.setWeight(cur.getString(cur.getColumnIndex(WEIGHT)));
                e.setReps(cur.getString(cur.getColumnIndex(REPS)));
                e.setDate(cur.getString(cur.getColumnIndex(DATE)));
                exercises.add(e);
                cur.moveToNext();
            }
            return exercises;
        }catch (Exception e){
            return null;
        }
    }
}
