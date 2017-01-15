package com.example.sunny.contactmanagerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateData extends AppCompatActivity {

    EditText etNumber, etName, etEmail;
    Button btnUpdate;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        etNumber = (EditText) findViewById(R.id.etnumber);
        etName = (EditText) findViewById(R.id.etname);
        etEmail = (EditText) findViewById(R.id.etemail);
        btnUpdate = (Button) findViewById(R.id.update);

        db = new DatabaseHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateData(etNumber.getText().toString(), etName.getText().toString(), etEmail.getText().toString());
            }
        });

    }
}
