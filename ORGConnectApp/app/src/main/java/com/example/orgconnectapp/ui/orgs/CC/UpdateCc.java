package com.example.orgconnectapp.ui.orgs.CC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class UpdateCc extends AppCompatActivity {


    private RecyclerView ccDepartnment;
    private LinearLayout ccNoData;
    private List<TeacherData> listT10;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;
    private RecyclerView ccPresData, ccVPresData, ccSecData, ccASecData, ccTresData, ccATresData, ccAuditorData, ccAAuditorData, ccBusData, ccProData, ccTechData, cc4YrData, cc3YrData, cc2YrData, cc1YrData, ccG12Data, ccG11Data;
    private LinearLayout ccPresNoData, ccVPresNoData, ccSecNoData, ccASecNoData, ccTresNoData, ccATresNoData , ccAuditorNoData, ccAAuditorNoData, ccBusNoData, ccProNoData, ccTechNoData, cc4YrNoData, cc3YrNoData, cc2YrNoData, cc1YrNoData, ccG12NoData,   ccG11NoData;
    private List<CcData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private CcAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cc);

        ccDepartnment = findViewById(R.id.ccDepartnment);
        ccNoData = findViewById(R.id.ccNoData);

        ccPresData = findViewById(R.id.ccPresData);
        ccVPresData = findViewById(R.id.ccVPresData);
        ccSecData = findViewById(R.id.ccSecData);
        ccASecData = findViewById(R.id.ccASecData);
        ccTresData = findViewById(R.id.ccTresData);
        ccATresData = findViewById(R.id.ccATresData);
        ccAuditorData = findViewById(R.id.ccAuditorData);
        ccAAuditorData = findViewById(R.id.ccAAuditorData);
        ccBusData = findViewById(R.id.ccBusData);
        ccProData = findViewById(R.id.ccProData);
        ccTechData = findViewById(R.id.ccTechData);
        cc4YrData = findViewById(R.id.cc4YrData);
        cc3YrData = findViewById(R.id.cc3YrData);
        cc2YrData = findViewById(R.id.cc2YrData);
        cc1YrData = findViewById(R.id.cc1YrData);
        ccG12Data = findViewById(R.id.ccG12Data);
        ccG11Data = findViewById(R.id.ccG11Data);


        ccPresNoData = findViewById(R.id.ccPresNoData);
        ccVPresNoData = findViewById(R.id.ccVPresNoData);
        ccSecNoData = findViewById(R.id.ccSecNoData);
        ccASecNoData = findViewById(R.id.ccASecNoData);
        ccTresNoData = findViewById(R.id.ccTresNoData);
        ccATresNoData = findViewById(R.id.ccATresNoData);
        ccAuditorNoData = findViewById(R.id.ccAuditorNoData);
        ccAAuditorNoData = findViewById(R.id.ccAAuditorNoData);
        ccProNoData = findViewById(R.id.ccProNoData);
        ccBusNoData = findViewById(R.id.ccBusNoData);
        ccTechNoData = findViewById(R.id.ccTechNoData);
        cc4YrNoData = findViewById(R.id.cc4YrNoData);
        cc3YrNoData = findViewById(R.id.cc3YrNoData);
        cc2YrNoData = findViewById(R.id.cc2YrNoData);
        cc1YrNoData = findViewById(R.id.cc1YrNoData);
        ccG12NoData = findViewById(R.id.ccG12NoData);
        ccG11NoData = findViewById(R.id.ccG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Coders Club Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        ccDepartnment();

        ccPresData();
        ccVPresData();
        ccSecData();
        ccASecData();
        ccTresData();
        ccATresData();
        ccAuditorData();
        ccAAuditorData();
        ccBusData();
        ccProData();
        ccTechData();
        cc4YrData();
        cc3YrData();
        cc2YrData();
        cc1YrData();
        ccG12Data();
        ccG11Data();

    }

    private void ccDepartnment() {
        dbRef1 = reference1.child("Coders Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccNoData.setVisibility(View.VISIBLE);
                    ccDepartnment.setVisibility(View.GONE);
                }else{
                    ccNoData.setVisibility(View.GONE);
                    ccDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT10.add(data);
                    }
                    ccDepartnment.setHasFixedSize(true);
                    ccDepartnment.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter1 = new TeacherAdapter(listT10, UpdateCc.this, "Coders Club Adviser");
                    ccDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateCc.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void ccPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccPresNoData.setVisibility(View.VISIBLE);
                    ccPresData.setVisibility(View.GONE);
                }else{
                    ccPresNoData.setVisibility(View.GONE);
                    ccPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list1.add(data);
                    }
                    ccPresData.setHasFixedSize(true);
                    ccPresData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list1, UpdateCc.this, "President");
                    ccPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccVPresNoData.setVisibility(View.VISIBLE);
                    ccVPresData.setVisibility(View.GONE);
                }else{
                    ccVPresNoData.setVisibility(View.GONE);
                    ccVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list2.add(data);
                    }
                    ccVPresData.setHasFixedSize(true);
                    ccVPresData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list2, UpdateCc.this, "Vice President");
                    ccVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccSecNoData.setVisibility(View.VISIBLE);
                    ccSecData.setVisibility(View.GONE);
                }else{
                    ccSecNoData.setVisibility(View.GONE);
                    ccSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list3.add(data);
                    }
                    ccSecData.setHasFixedSize(true);
                    ccSecData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list3, UpdateCc.this, "Secretary");
                    ccSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccASecData.setVisibility(View.VISIBLE);
                    ccASecData.setVisibility(View.GONE);
                }else{
                    ccASecNoData.setVisibility(View.GONE);
                    ccASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list4.add(data);
                    }
                    ccASecData.setHasFixedSize(true);
                    ccASecData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list4, UpdateCc.this, "Assistant Secretary");
                    ccASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccTresNoData.setVisibility(View.VISIBLE);
                    ccTresData.setVisibility(View.GONE);
                }else{
                    ccTresNoData.setVisibility(View.GONE);
                    ccTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list5.add(data);
                    }
                    ccTresData.setHasFixedSize(true);
                    ccTresData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list5, UpdateCc.this, "Treasurer");
                    ccTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccATresNoData.setVisibility(View.VISIBLE);
                    ccATresData.setVisibility(View.GONE);
                }else{
                    ccATresNoData.setVisibility(View.GONE);
                    ccATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list6.add(data);
                    }
                    ccATresData.setHasFixedSize(true);
                    ccATresData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list6, UpdateCc.this, "Assistant Treasurer");
                    ccATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccAuditorNoData.setVisibility(View.VISIBLE);
                    ccAuditorData.setVisibility(View.GONE);
                }else{
                    ccAuditorNoData.setVisibility(View.GONE);
                    ccAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list7.add(data);
                    }
                    ccAuditorData.setHasFixedSize(true);
                    ccAuditorData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list7, UpdateCc.this, "Auditor");
                    ccAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccAAuditorNoData.setVisibility(View.VISIBLE);
                    ccAAuditorData.setVisibility(View.GONE);
                }else{
                    ccAAuditorNoData.setVisibility(View.GONE);
                    ccAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list8.add(data);
                    }
                    ccAAuditorData.setHasFixedSize(true);
                    ccAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list8, UpdateCc.this, "Assistant Auditor");
                    ccAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccBusNoData.setVisibility(View.VISIBLE);
                    ccBusData.setVisibility(View.GONE);
                }else{
                    ccBusNoData.setVisibility(View.GONE);
                    ccBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list9.add(data);
                    }
                    ccBusData.setHasFixedSize(true);
                    ccBusData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list9, UpdateCc.this, "Business Manager");
                    ccBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccProNoData.setVisibility(View.VISIBLE);
                    ccProData.setVisibility(View.GONE);
                }else{
                    ccProNoData.setVisibility(View.GONE);
                    ccProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list10.add(data);
                    }
                    ccProData.setHasFixedSize(true);
                    ccProData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list10, UpdateCc.this, "Project Manager");
                    ccProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccTechNoData.setVisibility(View.VISIBLE);
                    ccTechData.setVisibility(View.GONE);
                }else{
                    ccTechNoData.setVisibility(View.GONE);
                    ccTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list11.add(data);
                    }
                    ccTechData.setHasFixedSize(true);
                    ccTechData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list11, UpdateCc.this, "Tech Officer");
                    ccTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cc4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cc4YrNoData.setVisibility(View.VISIBLE);
                    cc4YrData.setVisibility(View.GONE);
                }else{
                    cc4YrNoData.setVisibility(View.GONE);
                    cc4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list12.add(data);
                    }
                    cc4YrData.setHasFixedSize(true);
                    cc4YrData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list12, UpdateCc.this, "4th Year Representative");
                    cc4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cc3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cc3YrNoData.setVisibility(View.VISIBLE);
                    cc3YrData.setVisibility(View.GONE);
                }else{
                    cc3YrNoData.setVisibility(View.GONE);
                    cc3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list13.add(data);
                    }
                    cc3YrData.setHasFixedSize(true);
                    cc3YrData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list13, UpdateCc.this, "3rd Year Representative");
                    cc3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cc2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cc2YrNoData.setVisibility(View.VISIBLE);
                    cc2YrData.setVisibility(View.GONE);
                }else{
                    cc2YrNoData.setVisibility(View.GONE);
                    cc2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list14.add(data);
                    }
                    cc2YrData.setHasFixedSize(true);
                    cc2YrData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list14, UpdateCc.this, "2nd Year Representative");
                    cc2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cc1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cc1YrNoData.setVisibility(View.VISIBLE);
                    cc1YrData.setVisibility(View.GONE);
                }else{
                    cc1YrNoData.setVisibility(View.GONE);
                    cc1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list15.add(data);
                    }
                    cc1YrData.setHasFixedSize(true);
                    cc1YrData.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list15, UpdateCc.this, "1st Year Representative");
                    cc1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccG12NoData.setVisibility(View.VISIBLE);
                    ccG12Data.setVisibility(View.GONE);
                }else{
                    ccG12NoData.setVisibility(View.GONE);
                    ccG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list16.add(data);
                    }
                    ccG12Data.setHasFixedSize(true);
                    ccG12Data.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list16, UpdateCc.this, "Grade 12 Representative");
                    ccG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ccG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ccG11NoData.setVisibility(View.VISIBLE);
                    ccG11Data.setVisibility(View.GONE);
                }else{
                    ccG11NoData.setVisibility(View.GONE);
                    ccG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CcData data = snapshot.getValue(CcData.class);
                        list17.add(data);
                    }
                    ccG11Data.setHasFixedSize(true);
                    ccG11Data.setLayoutManager(new LinearLayoutManager(UpdateCc.this));
                    adapter = new CcAdapter(list17, UpdateCc.this, "Grade 11 Representative");
                    ccG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}