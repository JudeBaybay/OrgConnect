package com.example.orgconnectapp.ui.orgs.SC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.orgconnectapp.R;
import com.example.orgconnectapp.ui.faculty.TeacherAdapter;
import com.example.orgconnectapp.ui.faculty.TeacherData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UpdateSc extends AppCompatActivity {


    private RecyclerView scDepartnment;
    private LinearLayout scNoData;
    private TeacherAdapter adapter1;
    private List<TeacherData> listT1;
    private RecyclerView scPresData, scVPresData, scSecData, scASecData, scTresData, scATresData, scAuditorData, scAAuditorData, scBusData, scProData, scTechData, sc4YrData, sc3YrData, sc2YrData, sc1YrData, scG12Data, scG11Data;
    private LinearLayout scPresNoData, scVPresNoData, scSecNoData, scASecNoData, scTresNoData, scATresNoData , scAuditorNoData, scAAuditorNoData, scBusNoData, scProNoData, scTechNoData, sc4YrNoData, sc3YrNoData, sc2YrNoData, sc1YrNoData, scG12NoData,   scG11NoData;
    private List <ScData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private ScAdapter adapter;
    private DatabaseReference reference, dbRef;
    private DatabaseReference reference1, dbRef1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sc);



        scDepartnment = findViewById(R.id.scDepartnment);
        scNoData = findViewById(R.id.scNoData);



        scPresData = findViewById(R.id.scPresData);
        scVPresData = findViewById(R.id.scVPresData);
        scSecData = findViewById(R.id.scSecData);
        scASecData = findViewById(R.id.scASecData);
        scTresData = findViewById(R.id.scTresData);
        scATresData = findViewById(R.id.scATresData);
        scAuditorData = findViewById(R.id.scAuditorData);
        scAAuditorData = findViewById(R.id.scAAuditorData);
        scBusData = findViewById(R.id.scBusData);
        scProData = findViewById(R.id.scProData);
        scTechData = findViewById(R.id.scTechData);
        sc4YrData = findViewById(R.id.sc4YrData);
        sc3YrData = findViewById(R.id.sc3YrData);
        sc2YrData = findViewById(R.id.sc2YrData);
        sc1YrData = findViewById(R.id.sc1YrData);
        scG12Data = findViewById(R.id.scG12Data);
        scG11Data = findViewById(R.id.scG11Data);


        scPresNoData = findViewById(R.id.scPresNoData);
        scVPresNoData = findViewById(R.id.scVPresNoData);
        scSecNoData = findViewById(R.id.scSecNoData);
        scASecNoData = findViewById(R.id.scASecNoData);
        scTresNoData = findViewById(R.id.scTresNoData);
        scATresNoData = findViewById(R.id.scATresNoData);
        scAuditorNoData = findViewById(R.id.scAuditorNoData);
        scAAuditorNoData = findViewById(R.id.scAAuditorNoData);
        scProNoData = findViewById(R.id.scProNoData);
        scBusNoData = findViewById(R.id.scBusNoData);
        scTechNoData = findViewById(R.id.scTechNoData);
        sc4YrNoData = findViewById(R.id.sc4YrNoData);
        sc3YrNoData = findViewById(R.id.sc3YrNoData);
        sc2YrNoData = findViewById(R.id.sc2YrNoData);
        sc1YrNoData = findViewById(R.id.sc1YrNoData);
        scG12NoData = findViewById(R.id.scG12NoData);
        scG11NoData = findViewById(R.id.scG11NoData);


        reference = FirebaseDatabase.getInstance().getReference().child("Student Council Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        scDepartnment();

        scPresData();
        scVPresData();
        scSecData();
        scASecData();
        scTresData();
        scATresData();
        scAuditorData();
        scAAuditorData();
        scBusData();
        scProData();
        scTechData();
        sc4YrData();
        sc3YrData();
        sc2YrData();
        sc1YrData();
        scG12Data();
        scG11Data();



    }

    private void scDepartnment() {
        dbRef1 = reference1.child("Student Council Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scNoData.setVisibility(View.VISIBLE);
                    scDepartnment.setVisibility(View.GONE);
                }else{
                    scNoData.setVisibility(View.GONE);
                    scDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT1.add(data);
                    }
                    scDepartnment.setHasFixedSize(true);
                    scDepartnment.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter1 = new TeacherAdapter(listT1, UpdateSc.this, "Student Council Adviser");
                    scDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateSc.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void scPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scPresNoData.setVisibility(View.VISIBLE);
                    scPresData.setVisibility(View.GONE);
                }else{
                    scPresNoData.setVisibility(View.GONE);
                    scPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list1.add(data);
                    }
                    scPresData.setHasFixedSize(true);
                    scPresData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list1, UpdateSc.this, "President");
                    scPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scVPresNoData.setVisibility(View.VISIBLE);
                    scVPresData.setVisibility(View.GONE);
                }else{
                    scVPresNoData.setVisibility(View.GONE);
                    scVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list2.add(data);
                    }
                    scVPresData.setHasFixedSize(true);
                    scVPresData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list2, UpdateSc.this, "Vice President");
                    scVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scSecNoData.setVisibility(View.VISIBLE);
                    scSecData.setVisibility(View.GONE);
                }else{
                    scSecNoData.setVisibility(View.GONE);
                    scSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list3.add(data);
                    }
                    scSecData.setHasFixedSize(true);
                    scSecData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list3, UpdateSc.this, "Secretary");
                    scSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scASecData.setVisibility(View.VISIBLE);
                    scASecData.setVisibility(View.GONE);
                }else{
                    scASecNoData.setVisibility(View.GONE);
                    scASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list4.add(data);
                    }
                    scASecData.setHasFixedSize(true);
                    scASecData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list4, UpdateSc.this, "Assistant Secretary");
                    scASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scTresNoData.setVisibility(View.VISIBLE);
                    scTresData.setVisibility(View.GONE);
                }else{
                    scTresNoData.setVisibility(View.GONE);
                    scTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list5.add(data);
                    }
                    scTresData.setHasFixedSize(true);
                    scTresData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list5, UpdateSc.this, "Treasurer");
                    scTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scATresNoData.setVisibility(View.VISIBLE);
                    scATresData.setVisibility(View.GONE);
                }else{
                    scATresNoData.setVisibility(View.GONE);
                    scATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list6.add(data);
                    }
                    scATresData.setHasFixedSize(true);
                    scATresData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list6, UpdateSc.this, "Assistant Treasurer");
                    scATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scAuditorNoData.setVisibility(View.VISIBLE);
                    scAuditorData.setVisibility(View.GONE);
                }else{
                    scAuditorNoData.setVisibility(View.GONE);
                    scAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list7.add(data);
                    }
                    scAuditorData.setHasFixedSize(true);
                    scAuditorData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list7, UpdateSc.this, "Auditor");
                    scAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scAAuditorNoData.setVisibility(View.VISIBLE);
                    scAAuditorData.setVisibility(View.GONE);
                }else{
                    scAAuditorNoData.setVisibility(View.GONE);
                    scAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list8.add(data);
                    }
                    scAAuditorData.setHasFixedSize(true);
                    scAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list8, UpdateSc.this, "Assistant Auditor");
                    scAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scBusNoData.setVisibility(View.VISIBLE);
                    scBusData.setVisibility(View.GONE);
                }else{
                    scBusNoData.setVisibility(View.GONE);
                    scBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list9.add(data);
                    }
                    scBusData.setHasFixedSize(true);
                    scBusData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list9, UpdateSc.this, "Business Manager");
                    scBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scProNoData.setVisibility(View.VISIBLE);
                    scProData.setVisibility(View.GONE);
                }else{
                    scProNoData.setVisibility(View.GONE);
                    scProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list10.add(data);
                    }
                    scProData.setHasFixedSize(true);
                    scProData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list10, UpdateSc.this, "Project Manager");
                    scProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scTechNoData.setVisibility(View.VISIBLE);
                    scTechData.setVisibility(View.GONE);
                }else{
                    scTechNoData.setVisibility(View.GONE);
                    scTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list11.add(data);
                    }
                    scTechData.setHasFixedSize(true);
                    scTechData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list11, UpdateSc.this, "Tech Officer");
                    scTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sc4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sc4YrNoData.setVisibility(View.VISIBLE);
                    sc4YrData.setVisibility(View.GONE);
                }else{
                    sc4YrNoData.setVisibility(View.GONE);
                    sc4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list12.add(data);
                    }
                    sc4YrData.setHasFixedSize(true);
                    sc4YrData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list12, UpdateSc.this, "4th Year Representative");
                    sc4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sc3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sc3YrNoData.setVisibility(View.VISIBLE);
                    sc3YrData.setVisibility(View.GONE);
                }else{
                    sc3YrNoData.setVisibility(View.GONE);
                    sc3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list13.add(data);
                    }
                    sc3YrData.setHasFixedSize(true);
                    sc3YrData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list13, UpdateSc.this, "3rd Year Representative");
                    sc3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sc2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sc2YrNoData.setVisibility(View.VISIBLE);
                    sc2YrData.setVisibility(View.GONE);
                }else{
                    sc2YrNoData.setVisibility(View.GONE);
                    sc2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list14.add(data);
                    }
                    sc2YrData.setHasFixedSize(true);
                    sc2YrData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list14, UpdateSc.this, "2nd Year Representative");
                    sc2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sc1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sc1YrNoData.setVisibility(View.VISIBLE);
                    sc1YrData.setVisibility(View.GONE);
                }else{
                    sc1YrNoData.setVisibility(View.GONE);
                    sc1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list15.add(data);
                    }
                    sc1YrData.setHasFixedSize(true);
                    sc1YrData.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list15, UpdateSc.this, "1st Year Representative");
                    sc1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scG12NoData.setVisibility(View.VISIBLE);
                    scG12Data.setVisibility(View.GONE);
                }else{
                    scG12NoData.setVisibility(View.GONE);
                    scG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list16.add(data);
                    }
                    scG12Data.setHasFixedSize(true);
                    scG12Data.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list16, UpdateSc.this, "Grade 12 Representative");
                    scG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void scG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    scG11NoData.setVisibility(View.VISIBLE);
                    scG11Data.setVisibility(View.GONE);
                }else{
                    scG11NoData.setVisibility(View.GONE);
                    scG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        ScData data = snapshot.getValue(ScData.class);
                        list17.add(data);
                    }
                    scG11Data.setHasFixedSize(true);
                    scG11Data.setLayoutManager(new LinearLayoutManager(UpdateSc.this));
                    adapter = new ScAdapter(list17, UpdateSc.this, "Grade 11 Representative");
                    scG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}