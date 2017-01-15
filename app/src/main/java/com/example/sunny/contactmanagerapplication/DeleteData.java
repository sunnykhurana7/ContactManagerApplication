package com.example.sunny.contactmanagerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteData extends AppCompatActivity {

    EditText number;
    Button delete;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        number = (EditText) findViewById(R.id.etNumber);
        delete = (Button) findViewById(R.id.delete);

        db = new DatabaseHelper(this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteData(number.getText().toString());
            }
        });
    }
}
