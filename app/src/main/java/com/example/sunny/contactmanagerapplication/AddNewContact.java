package com.example.sunny.contactmanagerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContact extends AppCompatActivity {

    EditText etName, etMobileNumber, etEmail;
    Button btnSave;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        db = new DatabaseHelper(this);

        etName = (EditText) findViewById(R.id.etName);
        etMobileNumber = (EditText) findViewById(R.id.etMobileNumber);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = db.insertData(etName.getText().toString(), Integer.parseInt(etMobileNumber.getText().toString()), etEmail.getText().toString());
                if (result) {
                    Toast.makeText(AddNewContact.this, "Data Insert SuccessFully...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddNewContact.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
