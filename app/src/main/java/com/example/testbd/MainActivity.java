package com.example.testbd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail, etGender;

    DBHelper dbHelper;
    SQLiteDatabase database;
    ContentValues contentValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.Add);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.Read);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.Clear);
        btnClear.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.Name);
        etEmail = (EditText) findViewById(R.id.Mail);
        etGender = (EditText) findViewById(R.id.Gender);

        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        UpdateTable();
    }


    public void UpdateTable()
    {
        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int genderIndex = cursor.getColumnIndex(DBHelper.KEY_GENDER);

            TableLayout dbOutput = findViewById(R.id.Table);
            dbOutput.removeAllViews();
            do{
                TableRow dbOutputRow = new TableRow(this);

                dbOutputRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);

                TextView outputID = new TextView(this);
                params.weight = 1.0f;
                outputID.setLayoutParams(params);
                outputID.setText(cursor.getString(idIndex));
                dbOutputRow.addView(outputID);

                TextView outputName = new TextView(this);
                params.weight = 3.0f;
                outputName.setLayoutParams(params);
                outputName.setText(cursor.getString(nameIndex));
                dbOutputRow.addView(outputName);

                TextView outputPrice = new TextView(this);
                params.weight = 3.0f;
                outputPrice.setLayoutParams(params);
                outputPrice.setText(cursor.getString(genderIndex));
                dbOutputRow.addView(outputPrice);

                Button btndelete = new Button(this);
                btndelete.setOnClickListener(this);
                params.weight = 1.0f;
                btndelete.setLayoutParams(params);
                btndelete.setText("УДАЛИТЬ");
                btndelete.setId(cursor.getInt(idIndex));
                dbOutputRow.addView(btndelete);

                dbOutput.addView(dbOutputRow);
            }
            while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");

        cursor.close();
    }


    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String gender = etGender.getText().toString();
        contentValues = new ContentValues();


        switch (v.getId()) {

            case R.id.Add:
            contentValues.put(DBHelper.KEY_NAME, name);
            contentValues.put(DBHelper.KEY_MAIL, email);
            contentValues.put(DBHelper.KEY_GENDER, gender);

            database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
            UpdateTable();
            etName.setText("");
            etEmail.setText("");
            etGender.setText("");
            break;

            case R.id.Clear:
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                TableLayout dbOutput = findViewById(R.id.Table);
                dbOutput.removeAllViews();
                UpdateTable();
                break;

            default:
                View outputDBRow = (View) v.getParent();
                ViewGroup outputDB = (ViewGroup) outputDBRow.getParent();
                outputDB.removeView(outputDBRow);
                outputDB.invalidate();
                database.delete(dbHelper.TABLE_CONTACTS, dbHelper.KEY_ID+" = ?", new String[] {String.valueOf(v.getId())} );

                Cursor cursorUpdater = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
                if (cursorUpdater.moveToFirst()) {
                    int idIndex = cursorUpdater.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursorUpdater.getColumnIndex(DBHelper.KEY_NAME);
                    int mailIndex = cursorUpdater.getColumnIndex(DBHelper.KEY_MAIL);
                    int genderIndex = cursorUpdater.getColumnIndex(DBHelper.KEY_GENDER);
                    int realID = 1;
                    do{
                        if (cursorUpdater.getInt(idIndex) > realID){
                            contentValues.put(dbHelper.KEY_ID, realID);
                            contentValues.put(dbHelper.KEY_NAME, cursorUpdater.getString(nameIndex));
                            contentValues.put(dbHelper.KEY_MAIL, cursorUpdater.getString(mailIndex));
                            contentValues.put(dbHelper.KEY_GENDER, cursorUpdater.getString(genderIndex));
                            database.replace(dbHelper.TABLE_CONTACTS, null, contentValues);
                        }
                        realID++;
                    }
                    while(cursorUpdater.moveToNext());
                    if (cursorUpdater.moveToLast()) {
                        if (cursorUpdater.moveToLast() && v.getId()!=realID) {
                            database.delete(dbHelper.TABLE_CONTACTS, dbHelper.KEY_ID + " = ?", new String[]{cursorUpdater.getString(idIndex)});
                        }
                    }
                    UpdateTable();
                }
                else
                    Log.d("mLog","0 rows");
                break;
        }
        dbHelper.close();
    }
}