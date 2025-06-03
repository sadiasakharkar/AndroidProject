
package com.example.practical10;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button bt1, bt2, bt3;
    String uid, uname, upass;
    SQLiteDatabase db;
    SQLiteOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1= findViewById(R.id.et1);
        et2= findViewById(R.id.et2);
        et3= findViewById(R.id.et3);
        bt1= findViewById(R.id.bt1);
        bt2= findViewById(R.id.bt2);
        bt3= findViewById(R.id.bt3);
        helper = new DB(this);


    }

    public void InsertData(View view) {
        uid = et1.getText().toString();
        uname = et2.getText().toString();
        upass = et3.getText().toString();
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB.COL_1, uid);
        values.put(DB.COL_2, uname);
        values.put(DB.COL_3, upass);

        double res = db.insert(DB.TABLE_NAME,null,values);

        if(res == -1)
        {
            Toast.makeText(this, "Insertion failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Insertion successful", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteData(View view) {
        uid = et1.getText().toString();
        uname = et2.getText().toString();
        upass = et3.getText().toString();
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB.COL_1, uid);
        values.put(DB.COL_2, uname);
        values.put(DB.COL_3, upass);

        double res = db.delete(DB.TABLE_NAME,DB.COL_1+"=?", new String[]{uid});
        if(res == -1)
        {
            Toast.makeText(this, "Deletion failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Deletion successful", Toast.LENGTH_SHORT).show();
        }
    }

    public void UpdateData(View view) {
        uid = et1.getText().toString();
        uname = et2.getText().toString();
        upass = et3.getText().toString();
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB.COL_1, uid);
        values.put(DB.COL_2, uname);
        values.put(DB.COL_3, upass);

        double res = db.update(DB.TABLE_NAME, values, DB.COL_1 + "=?", new String[]{uid});
        if(res == -1)
        {
            Toast.makeText(this, "Updation failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Updation successful", Toast.LENGTH_SHORT).show();
        }
    }
}
