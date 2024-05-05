package com.example.orgconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.orgconnect.event.DeleteEventActivity;
import com.example.orgconnect.event.Event;
import com.example.orgconnect.faculty.UpdateFaculty;
import com.example.orgconnect.orgs.menu.Menu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadEvent, addGalleryImage, faculty, deleteEvent, changeOfficers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        uploadEvent = findViewById(R.id.addEvent);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        faculty = findViewById(R.id.faculty);
        deleteEvent = findViewById(R.id.deleteEvent);
        changeOfficers = findViewById(R.id.changeOfficers);


        uploadEvent.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteEvent.setOnClickListener(this);
        changeOfficers.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.addEvent){
            Intent intent = new Intent(MainActivity.this, Event.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.addGalleryImage){
            Intent intent = new Intent(MainActivity.this,UploadImage.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.faculty){
            Intent intent = new Intent(MainActivity.this, UpdateFaculty.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.deleteEvent){
            Intent intent = new Intent(MainActivity.this, DeleteEventActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.changeOfficers){
            Intent intent = new Intent(MainActivity.this, Menu.class);
            startActivity(intent);
        }
    }

}