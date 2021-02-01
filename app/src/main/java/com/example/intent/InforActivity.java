package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InforActivity extends AppCompatActivity {
    TextView txtName, txtAge;
    Person p;
    List<Person> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        AnhXa();
        Intent i = getIntent();
        //get tung item
        String name = i.getStringExtra("name");
        int age = i.getIntExtra("age",0);
        txtAge.setText(txtAge.getText().toString()+age);
        txtName.setText(txtName.getText().toString()+ name);
        //get object
        p = i.getParcelableExtra("object");
        Log.d("Person",p.toString());
        //get list
        list = new ArrayList<>();
        list = i.getParcelableArrayListExtra("list");
        for (Person x : list
             ) {
            Log.d("list", "Data list: "+x.toString());
        }
    }
    public void AnhXa(){
        txtName = findViewById(R.id.txtNameDetail);
        txtAge = findViewById(R.id.txtAgeDetail);
    }


}