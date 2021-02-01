package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtName, edtAge;
    Button btnSubmit,btnAction;
    Person p;
    List<Person> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= new ArrayList<>();
        list.add(new Person("Doan",10));
        list.add(new Person("Linh",11));
        list.add(new Person("Điệp",12));
        list.add(new Person("Trung",13));
        AnhXa();
        btnSubmit.setOnClickListener(this);
        btnAction.setOnClickListener(this);
    }

    public void AnhXa(){
        edtAge = findViewById(R.id.edtAge);
        edtName = findViewById(R.id.edtName);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnAction = findViewById(R.id.btnTestAction);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubmit:
                p = new Person(edtName.getText().toString(),Integer.parseInt(edtAge.getText().toString()));
                Intent i = new Intent(MainActivity.this,InforActivity.class);
                i.putExtra("name", edtName.getText().toString());
                i.putExtra("age",Integer.parseInt(edtAge.getText().toString()));
                i.putExtra("object", (Parcelable) p);
                i.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) list);
                startActivity(i);
                break;
            case R.id.btnTestAction:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//SETWALLPAPER
                Intent intent2 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0981206317"));
                Intent intent3 = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("tel:123456789"));
                startActivity(intent3);
                break;
            default: break;
        }
    }
}