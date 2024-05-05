package com.example.orgconnectapp.ui.orgs.PNS;

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

public class UpdatePns extends AppCompatActivity {



    private RecyclerView pnsDepartnment;
    private LinearLayout pnsNoData;
    private List<TeacherData> listT6;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;
    private RecyclerView pnsPresData, pnsVPresData, pnsSecData, pnsASecData, pnsTresData, pnsATresData, pnsAuditorData, pnsAAuditorData, pnsBusData, pnsProData, pnsTechData, pns4YrData, pns3YrData, pns2YrData, pns1YrData, pnsG12Data, pnsG11Data;
    private LinearLayout pnsPresNoData, pnsVPresNoData, pnsSecNoData, pnsASecNoData, pnsTresNoData, pnsATresNoData , pnsAuditorNoData, pnsAAuditorNoData, pnsBusNoData, pnsProNoData, pnsTechNoData, pns4YrNoData, pns3YrNoData, pns2YrNoData, pns1YrNoData, pnsG12NoData,   pnsG11NoData;
    private List<PnsData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private PnsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pns);

        pnsDepartnment = findViewById(R.id.pnsDepartnment);
        pnsNoData = findViewById(R.id.pnsNoData);

        pnsPresData = findViewById(R.id.pnsPresData);
        pnsVPresData = findViewById(R.id.pnsVPresData);
        pnsSecData = findViewById(R.id.pnsSecData);
        pnsASecData = findViewById(R.id.pnsASecData);
        pnsTresData = findViewById(R.id.pnsTresData);
        pnsATresData = findViewById(R.id.pnsATresData);
        pnsAuditorData = findViewById(R.id.pnsAuditorData);
        pnsAAuditorData = findViewById(R.id.pnsAAuditorData);
        pnsBusData = findViewById(R.id.pnsBusData);
        pnsProData = findViewById(R.id.pnsProData);
        pnsTechData = findViewById(R.id.pnsTechData);
        pns4YrData = findViewById(R.id.pns4YrData);
        pns3YrData = findViewById(R.id.pns3YrData);
        pns2YrData = findViewById(R.id.pns2YrData);
        pns1YrData = findViewById(R.id.pns1YrData);
        pnsG12Data = findViewById(R.id.pnsG12Data);
        pnsG11Data = findViewById(R.id.pnsG11Data);


        pnsPresNoData = findViewById(R.id.pnsPresNoData);
        pnsVPresNoData = findViewById(R.id.pnsVPresNoData);
        pnsSecNoData = findViewById(R.id.pnsSecNoData);
        pnsASecNoData = findViewById(R.id.pnsASecNoData);
        pnsTresNoData = findViewById(R.id.pnsTresNoData);
        pnsATresNoData = findViewById(R.id.pnsATresNoData);
        pnsAuditorNoData = findViewById(R.id.pnsAuditorNoData);
        pnsAAuditorNoData = findViewById(R.id.pnsAAuditorNoData);
        pnsProNoData = findViewById(R.id.pnsProNoData);
        pnsBusNoData = findViewById(R.id.pnsBusNoData);
        pnsTechNoData = findViewById(R.id.pnsTechNoData);
        pns4YrNoData = findViewById(R.id.pns4YrNoData);
        pns3YrNoData = findViewById(R.id.pns3YrNoData);
        pns2YrNoData = findViewById(R.id.pns2YrNoData);
        pns1YrNoData = findViewById(R.id.pns1YrNoData);
        pnsG12NoData = findViewById(R.id.pnsG12NoData);
        pnsG11NoData = findViewById(R.id.pnsG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Pen N' Scroll Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        pnsPresData();
        pnsVPresData();
        pnsSecData();
        pnsASecData();
        pnsTresData();
        pnsATresData();
        pnsAuditorData();
        pnsAAuditorData();
        pnsBusData();
        pnsProData();
        pnsTechData();
        pns4YrData();
        pns3YrData();
        pns2YrData();
        pns1YrData();
        pnsG12Data();
        pnsG11Data();

        pnsDepartnment();
    }

    private void pnsDepartnment() {
        dbRef1 = reference1.child("Pen N' Scroll Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsNoData.setVisibility(View.VISIBLE);
                    pnsDepartnment.setVisibility(View.GONE);
                }else{
                    pnsNoData.setVisibility(View.GONE);
                    pnsDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT6.add(data);
                    }
                    pnsDepartnment.setHasFixedSize(true);
                    pnsDepartnment.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter1 = new TeacherAdapter(listT6, UpdatePns.this, "Pen N' Scroll Adviser");
                    pnsDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdatePns.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void pnsPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsPresNoData.setVisibility(View.VISIBLE);
                    pnsPresData.setVisibility(View.GONE);
                }else{
                    pnsPresNoData.setVisibility(View.GONE);
                    pnsPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list1.add(data);
                    }
                    pnsPresData.setHasFixedSize(true);
                    pnsPresData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list1, UpdatePns.this, "President");
                    pnsPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsVPresNoData.setVisibility(View.VISIBLE);
                    pnsVPresData.setVisibility(View.GONE);
                }else{
                    pnsVPresNoData.setVisibility(View.GONE);
                    pnsVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list2.add(data);
                    }
                    pnsVPresData.setHasFixedSize(true);
                    pnsVPresData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list2, UpdatePns.this, "Vice President");
                    pnsVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsSecNoData.setVisibility(View.VISIBLE);
                    pnsSecData.setVisibility(View.GONE);
                }else{
                    pnsSecNoData.setVisibility(View.GONE);
                    pnsSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list3.add(data);
                    }
                    pnsSecData.setHasFixedSize(true);
                    pnsSecData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list3, UpdatePns.this, "Secretary");
                    pnsSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsASecData.setVisibility(View.VISIBLE);
                    pnsASecData.setVisibility(View.GONE);
                }else{
                    pnsASecNoData.setVisibility(View.GONE);
                    pnsASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list4.add(data);
                    }
                    pnsASecData.setHasFixedSize(true);
                    pnsASecData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list4, UpdatePns.this, "Assistant Secretary");
                    pnsASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsTresNoData.setVisibility(View.VISIBLE);
                    pnsTresData.setVisibility(View.GONE);
                }else{
                    pnsTresNoData.setVisibility(View.GONE);
                    pnsTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list5.add(data);
                    }
                    pnsTresData.setHasFixedSize(true);
                    pnsTresData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list5, UpdatePns.this, "Treasurer");
                    pnsTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsATresNoData.setVisibility(View.VISIBLE);
                    pnsATresData.setVisibility(View.GONE);
                }else{
                    pnsATresNoData.setVisibility(View.GONE);
                    pnsATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list6.add(data);
                    }
                    pnsATresData.setHasFixedSize(true);
                    pnsATresData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list6, UpdatePns.this, "Assistant Treasurer");
                    pnsATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsAuditorNoData.setVisibility(View.VISIBLE);
                    pnsAuditorData.setVisibility(View.GONE);
                }else{
                    pnsAuditorNoData.setVisibility(View.GONE);
                    pnsAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list7.add(data);
                    }
                    pnsAuditorData.setHasFixedSize(true);
                    pnsAuditorData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list7, UpdatePns.this, "Auditor");
                    pnsAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsAAuditorNoData.setVisibility(View.VISIBLE);
                    pnsAAuditorData.setVisibility(View.GONE);
                }else{
                    pnsAAuditorNoData.setVisibility(View.GONE);
                    pnsAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list8.add(data);
                    }
                    pnsAAuditorData.setHasFixedSize(true);
                    pnsAAuditorData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list8, UpdatePns.this, "Assistant Auditor");
                    pnsAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsBusNoData.setVisibility(View.VISIBLE);
                    pnsBusData.setVisibility(View.GONE);
                }else{
                    pnsBusNoData.setVisibility(View.GONE);
                    pnsBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list9.add(data);
                    }
                    pnsBusData.setHasFixedSize(true);
                    pnsBusData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list9, UpdatePns.this, "Business Manager");
                    pnsBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsProNoData.setVisibility(View.VISIBLE);
                    pnsProData.setVisibility(View.GONE);
                }else{
                    pnsProNoData.setVisibility(View.GONE);
                    pnsProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list10.add(data);
                    }
                    pnsProData.setHasFixedSize(true);
                    pnsProData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list10, UpdatePns.this, "Project Manager");
                    pnsProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsTechNoData.setVisibility(View.VISIBLE);
                    pnsTechData.setVisibility(View.GONE);
                }else{
                    pnsTechNoData.setVisibility(View.GONE);
                    pnsTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list11.add(data);
                    }
                    pnsTechData.setHasFixedSize(true);
                    pnsTechData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list11, UpdatePns.this, "Tech Officer");
                    pnsTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pns4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pns4YrNoData.setVisibility(View.VISIBLE);
                    pns4YrData.setVisibility(View.GONE);
                }else{
                    pns4YrNoData.setVisibility(View.GONE);
                    pns4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list12.add(data);
                    }
                    pns4YrData.setHasFixedSize(true);
                    pns4YrData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list12, UpdatePns.this, "4th Year Representative");
                    pns4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pns3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pns3YrNoData.setVisibility(View.VISIBLE);
                    pns3YrData.setVisibility(View.GONE);
                }else{
                    pns3YrNoData.setVisibility(View.GONE);
                    pns3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list13.add(data);
                    }
                    pns3YrData.setHasFixedSize(true);
                    pns3YrData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list13, UpdatePns.this, "3rd Year Representative");
                    pns3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pns2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pns2YrNoData.setVisibility(View.VISIBLE);
                    pns2YrData.setVisibility(View.GONE);
                }else{
                    pns2YrNoData.setVisibility(View.GONE);
                    pns2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list14.add(data);
                    }
                    pns2YrData.setHasFixedSize(true);
                    pns2YrData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list14, UpdatePns.this, "2nd Year Representative");
                    pns2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pns1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pns1YrNoData.setVisibility(View.VISIBLE);
                    pns1YrData.setVisibility(View.GONE);
                }else{
                    pns1YrNoData.setVisibility(View.GONE);
                    pns1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list15.add(data);
                    }
                    pns1YrData.setHasFixedSize(true);
                    pns1YrData.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list15, UpdatePns.this, "1st Year Representative");
                    pns1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pnsG12NoData.setVisibility(View.VISIBLE);
                    pnsG12Data.setVisibility(View.GONE);
                }else{
                    pnsG12NoData.setVisibility(View.GONE);
                    pnsG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        PnsData data = snapshot.getValue(PnsData.class);
                        list16.add(data);
                    }
                    pnsG12Data.setHasFixedSize(true);
                    pnsG12Data.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list16, UpdatePns.this, "Grade 12 Representative");
                    pnsG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void pnsG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    pnsG11NoData.setVisibility(View.VISIBLE);
                    pnsG11Data.setVisibility(View.GONE);
                } else {
                    pnsG11NoData.setVisibility(View.GONE);
                    pnsG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        PnsData data = snapshot.getValue(PnsData.class);
                        list17.add(data);
                    }
                    pnsG11Data.setHasFixedSize(true);
                    pnsG11Data.setLayoutManager(new LinearLayoutManager(UpdatePns.this));
                    adapter = new PnsAdapter(list17, UpdatePns.this, "Grade 11 Representative");
                    pnsG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}