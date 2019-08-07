package sg.edu.np.twq2.exam01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "MyDBHandler";
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "chat.db";
    public static final String CHATGRP = "ChatGrp";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_LASTMSG = "LastMsg";
    public static final String COLUMN_TIMESTAMP = "TimeStamp";

    public DBHelper(Context c)
    {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + CHATGRP + " ("
                + COLUMN_TITLE + " TEXT, "
                + COLUMN_LASTMSG + " TEXT, "
                + COLUMN_TIMESTAMP + " TEXT)");

        db.execSQL("INSERT INTO " + CHATGRP
                + " VALUES(\"TITLE A\", \"hello\", \"09:32\")");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer)
    {
        db.execSQL("DROP TABLE IF EXISTS " + CHATGRP);
        onCreate(db);
    }

    public ArrayList<ChatGrp> getAllChatGroups()
    {
        ArrayList<ChatGrp> list = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CHATGRP,
                null);

        while(c.moveToNext())
        {
            ChatGrp cg = new ChatGrp();
            cg.setTitle(c.getString(0));
            cg.setLastMsg(c.getString(1));
            cg.setTime(c.getString(2));

            list.add(cg);
        }

        c.close();
        db.close();
        return list;
    }

    public void addChatGroup(ChatGrp cg)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, cg.getTitle());
        values.put(COLUMN_LASTMSG, cg.getLastMsg());
        values.put(COLUMN_TIMESTAMP, cg.getTime());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(CHATGRP, null, values);
        db.close();
    }
}










