package com.cof.stdio_hue.contacts.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.cof.stdio_hue.contacts.model.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cof on 01/09/2018.
 */
public class DBManager extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "profile_manager";
    private static final String TABLE_NAME = "profile";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String ADDRESS = "address";
    private static final String EMAIL = "email";
    private static final int VERSION = 1;

    private Context context;

    private String SQLCreate = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + PHONE_NUMBER + " TEXT, " + ADDRESS + " TEXT, " + EMAIL + " TEXT)";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLCreate);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db,int oldVersion,int newVersion) {
        super.onDowngrade(db,oldVersion,newVersion);
        // Ha version
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // New Version thay đổi -> RUN
    }

    public void addProfile(Profile profile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME, profile.getmName());
        values.put(PHONE_NUMBER, profile.getmPhoneNumber());
        values.put(ADDRESS, profile.getmAddress());
        values.put(EMAIL, profile.getmEmail());

        if(db.insert(TABLE_NAME, null, values) > 0)
            Toast.makeText(context, "Add Success", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Add Fail", Toast.LENGTH_SHORT).show();
        db.close();
    }

    public List<Profile> getAllProfile(){
        List<Profile> listProfile = new ArrayList<>();
        String SQLGetAll = "SELECT *  FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SQLGetAll, null);
        if(cursor.moveToFirst()){
            do{
                Profile profile = new Profile();

                profile.setmID(cursor.getInt(0));
                profile.setmName(cursor.getString(1));
                profile.setmPhoneNumber(cursor.getString(2));
                profile.setmAddress(cursor.getString(3));
                profile.setmEmail(cursor.getString(4));
                listProfile.add(profile);
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return listProfile;
    }

    public int deleteProfile(Profile profile){
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME, ID + " = ?", new String[] {String.valueOf(profile.getmID())});
        db.close();
        return i;
    }

    public int updateProfile(Profile profile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, profile.getmName());
        contentValues.put(PHONE_NUMBER, profile.getmPhoneNumber());
        contentValues.put(ADDRESS, profile.getmAddress());
        contentValues.put(EMAIL, profile.getmEmail());
        int check = db.update(TABLE_NAME, contentValues, ID + " = ?", new String[] {String.valueOf(profile.getmID())});
        db.close();
        return check;
    }
}
