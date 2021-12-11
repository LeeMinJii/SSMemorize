package com.example.ssmemorize;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
//private static String ele_word ="/data/data/com.example.test/databases/"; // Database name

public class DBHelper_SAT extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;
    private static String TAG = "DBHelper";

    private static String databasePath = "/data/data/com.example.ssmemorize/databases/"; // 데이터베이스 경로
    private static String databaseName = "sat_Word.db"; // 데이터베이스 이름
    private static String tableName = "sat_Word"; // 테이블 이름

    public static SQLiteDatabase mDataBase;
    private final Context mContext;

    public DBHelper_SAT(Context context) {
        super(context, "databaseName", null, DATABASE_VERSION);
        this.mContext = context;
    }

    // 필수 메소드 오버라이딩
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
    // 데이터베이스 파일 열기
    public boolean OpenDatabaseFile() throws SQLException {

        if(!checkDataBase()){
            createDataBase();
        }

        String mPath = databasePath + databaseName;
        try{
            mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        catch(SQLException sqlException){
            Log.e(TAG, "[ERROR]" + "Can't Open Database");
        }
        return mDataBase != null;
    }

    public void createDataBase() throws SQLException{

        this.getReadableDatabase();
        this.close();

        try{
            copyDataBase();
            Log.e(TAG,  "[SUCCESS] " + databaseName + " are Created");
        }
        catch(IOException ioException){
            // Error Message
            Log.e(TAG, "[ERROR] " + "Unable to create " + databaseName);
            throw new Error(TAG);
        }
    }

    // DB파일 존재하나 확인
    private boolean checkDataBase() {
        File file = new File(databasePath + databaseName);
        return file.exists();
    }

    // DB 복사
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(databaseName);
        String outputFileName = "/data/data/com.example.ssmemorize/databases/" + databaseName;
        OutputStream mOutput = new FileOutputStream(outputFileName);

        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }


    public ArrayList<Word> getTableData() {

        try {
            // 테이블 정보 저장 List
            ArrayList<Word> mList = new ArrayList<Word>();

            // 쿼리
            String sql = "SELECT * FROM " + tableName;

            // 테이블 데이터를 읽기 위한 Cursor
            Cursor mCursor = mDataBase.rawQuery(sql, null);

            // 테이블 끝까지 읽기
            if (mCursor != null) {
                // 다음 row(행)으로 이동
                while (mCursor.moveToNext()) {
                    // 해당 row에 저장
                    Word word = new Word();
                    word.setId(mCursor.getInt(0));
                    word.setEnglish(mCursor.getString(1));
                    word.setKorean(mCursor.getString(2));

                    // List에 해당 row 추가
                    mList.add(word);
                }
            }
            return mList;

        } catch (SQLException mSQLException) {
            // Error Message
            Log.e(TAG, mSQLException.toString());
            throw mSQLException;
        }
    }

    // 데이터베이스 닫기
    public void CloseDatabaseFile(){
        if (mDataBase != null){
            mDataBase.close();
        }
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.disableWriteAheadLogging();
    }
}