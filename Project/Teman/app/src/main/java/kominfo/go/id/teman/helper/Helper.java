package kominfo.go.id.teman.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Helper extends SQLiteOpenHelper {

    private static final String TABLE_FRIENDS = "friends";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "nama";
    private static final String COLUMN_ADDRESS = "alamat";
    private static final String DATABASE_NAME = "dts_poliban.db";
    private static final int DATABASE_VERSION = 2;

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String query = "CREATE TABLE " + TABLE_FRIENDS + " ("
                + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY autoincrement, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_ADDRESS + " TEXT "
                + " )";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_FRIENDS;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NAME, cursor.getString(1));
                map.put(COLUMN_ADDRESS, cursor.getString(2));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        database.close();
        return wordList;
    }

    public void insert(String name, String address) {
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO "
                + TABLE_FRIENDS
                + " (nama, alamat) "
                + "VALUES ('" + name + "', '" + address + "')";

        database.execSQL(queryValues);
        database.close();
    }

    public void update(int id, String name, String address) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_FRIENDS + " SET "
                + COLUMN_NAME + "='" + name + "', "
                + COLUMN_ADDRESS + "='" + address + "'"
                + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(int id) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "DELETE FROM " + TABLE_FRIENDS + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        database.execSQL(updateQuery);
        database.close();
//        https://github.com/aldiskatel
    }

}
