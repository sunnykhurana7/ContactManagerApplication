package com.example.sunny.contactmanagerapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {

    EditText etSearch;
    Button btns;
    TextView txtName, txtEmail;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        db = new DatabaseHelper(this);
        etSearch = (EditText) findViewById(R.id.etSearch);
        btns = (Button) findViewById(R.id.btnss);
        txtName = (TextView) findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.getData(etSearch.getText().toString());
                while (cursor.moveToNext()) {
                    txtName.setText(cursor.getString(1));
                    txtEmail.setText(cursor.getString(3));
                }

            }
        });


    }
}
