package com.example.orgconnect.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orgconnect.R;
import com.example.orgconnect.orgs.ACE.UpdateAce;
import com.example.orgconnect.orgs.ATS.UpdateAts;
import com.example.orgconnect.orgs.CC.UpdateCc;
import com.example.orgconnect.orgs.CS.UpdateCs;
import com.example.orgconnect.orgs.HM.UpdateHm;
import com.example.orgconnect.orgs.PNS.UpdatePns;
import com.example.orgconnect.orgs.SC.UpdateSc;
import com.example.orgconnect.orgs.SUMS.UpdateSums;
import com.example.orgconnect.orgs.SYMS.UpdateSyms;
import com.example.orgconnect.orgs.TV.UpdateTv;
import com.example.orgconnect.orgs.U.UpdateUn;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab;
    private LinearLayout scAdviser, hmAdviser, symsAdviser, csAdviser, sumsAdviser, pnsAdviser, atsAdviser, uAdviser, tvAdviser, ccAdviser, aceAdviser;
    private RecyclerView scDepartnment, hmDepartnment, symsDepartnment, csDepartnment, sumsDepartment, pnsDepartnment, atcDepartnment, uDepartnment, tvDepartnment, ccDepartnment, aceDepartnment;
    private LinearLayout scNoData, hmNoData, symsNoData, csNoData, sumsNoData, pnsNoData, atcNoData, uNoData, tvNoData, ccNoData, aceNoData;
    private List<TeacherData> listT1, listT2, listT3, listT4, listT5, listT6, listT7, listT8, listT9, listT10, listT11;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        scAdviser = findViewById(R.id.scAdviser);
        hmAdviser = findViewById(R.id.hmAdviser);
        symsAdviser = findViewById(R.id.symsAdviser);
        csAdviser = findViewById(R.id.csAdviser);
        sumsAdviser = findViewById(R.id.sumsAdviser);
        pnsAdviser = findViewById(R.id.pnsAdviser);
        atsAdviser = findViewById(R.id.atsAdviser);
        uAdviser = findViewById(R.id.uAdviser);
        tvAdviser = findViewById(R.id.tvAdviser);
        ccAdviser = findViewById(R.id.ccAdviser);
        aceAdviser = findViewById(R.id.aceAdviser);

        scDepartnment = findViewById(R.id.scDepartnment);
        hmDepartnment = findViewById(R.id.hmDepartnment);
        symsDepartnment = findViewById(R.id.symsDepartnment);
        csDepartnment = findViewById(R.id.csDepartnment);
        sumsDepartment = findViewById(R.id.sumsDepartnment);
        pnsDepartnment = findViewById(R.id.pnsDepartnment);
        atcDepartnment = findViewById(R.id.atcDepartnment);
        uDepartnment = findViewById(R.id.uDepartnment);
        tvDepartnment = findViewById(R.id.tvDepartnment);
        ccDepartnment = findViewById(R.id.ccDepartnment);
        aceDepartnment = findViewById(R.id.aceDepartnment);

        scNoData = findViewById(R.id.scNoData);
        hmNoData = findViewById(R.id.hmNoData);
        symsNoData = findViewById(R.id.symsNoData);
        csNoData = findViewById(R.id.csNoData);
        sumsNoData = findViewById(R.id.sumsNoData);
        pnsNoData = findViewById(R.id.pnsNoData);
        atcNoData = findViewById(R.id.atcNoData);
        uNoData = findViewById(R.id.uNoData);
        tvNoData = findViewById(R.id.tvNoData);
        ccNoData = findViewById(R.id.ccNoData);
        aceNoData = findViewById(R.id.aceNoData);

        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        scDepartnment();
        hmDepartnment();
        symsDepartnment();
        csDepartnment();
        sumsDepartnment();
        pnsDepartnment();
        atcDepartnment();
        uDepartnment();
        tvDepartnment();
        ccDepartnment();
        aceDepartnment();

        scAdviser.setOnClickListener(this);
        hmAdviser.setOnClickListener(this);
        symsAdviser.setOnClickListener(this);
        csAdviser.setOnClickListener(this);
        sumsAdviser.setOnClickListener(this);
        pnsAdviser.setOnClickListener(this);
        atsAdviser.setOnClickListener(this);
        uAdviser.setOnClickListener(this);
        tvAdviser.setOnClickListener(this);
        ccAdviser.setOnClickListener(this);
        aceAdviser.setOnClickListener(this);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this, AddFaculty.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.scAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateSc.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.hmAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateHm.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.symsAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateSyms.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.csAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateCs.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.sumsAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateSums.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.pnsAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdatePns.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.atsAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateAts.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.uAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateUn.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.tvAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateTv.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.ccAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateCc.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.aceAdviser) {
            Intent intent = new Intent(UpdateFaculty.this, UpdateAce.class);
            startActivity(intent);
        }
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
                    scDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT1, UpdateFaculty.this, "Student Council Adviser");
                    scDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void hmDepartnment() {
        dbRef1 = reference1.child("HM Society Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmNoData.setVisibility(View.VISIBLE);
                    hmDepartnment.setVisibility(View.GONE);
                }else{
                    hmNoData.setVisibility(View.GONE);
                    hmDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT2.add(data);
                    }
                    hmDepartnment.setHasFixedSize(true);
                    hmDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT2, UpdateFaculty.this,"HM Society Adviser");
                    hmDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void symsDepartnment() {
        dbRef1 = reference1.child("SYMS Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsNoData.setVisibility(View.VISIBLE);
                    symsDepartnment.setVisibility(View.GONE);
                }else{
                    symsNoData.setVisibility(View.GONE);
                    symsDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT3.add(data);
                    }
                    symsDepartnment.setHasFixedSize(true);
                    symsDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT3, UpdateFaculty.this, "SYMS Adviser");
                    symsDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void csDepartnment() {
        dbRef1 = reference1.child("Computer Society Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartnment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT4.add(data);
                    }
                    csDepartnment.setHasFixedSize(true);
                    csDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT4, UpdateFaculty.this, "Computer Society Adviser");
                    csDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void sumsDepartnment() {
        dbRef1 = reference1.child("SUMS Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsNoData.setVisibility(View.VISIBLE);
                    sumsDepartment.setVisibility(View.GONE);
                }else{
                    sumsNoData.setVisibility(View.GONE);
                    sumsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT5.add(data);
                    }
                    sumsDepartment.setHasFixedSize(true);
                    sumsDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT5, UpdateFaculty.this, "SUMS Adviser");
                    sumsDepartment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
                    pnsDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT6, UpdateFaculty.this, "Pen N' Scroll Adviser");
                    pnsDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void atcDepartnment() {
        dbRef1 = reference1.child("Athlos Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atcNoData.setVisibility(View.VISIBLE);
                    atcDepartnment.setVisibility(View.GONE);
                }else{
                    atcNoData.setVisibility(View.GONE);
                    atcDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT7.add(data);
                    }
                    atcDepartnment.setHasFixedSize(true);
                    atcDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT7, UpdateFaculty.this, "Athlos Club Adviser");
                    atcDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void uDepartnment() {
        dbRef1 = reference1.child("Unleashed Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    uNoData.setVisibility(View.VISIBLE);
                    uDepartnment.setVisibility(View.GONE);
                }else{
                    uNoData.setVisibility(View.GONE);
                    uDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT8.add(data);
                    }
                    uDepartnment.setHasFixedSize(true);
                    uDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT8, UpdateFaculty.this, "Unleashed Adviser");
                    uDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void tvDepartnment() {
        dbRef1 = reference1.child("Teatro Versatil Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    tvNoData.setVisibility(View.VISIBLE);
                    tvDepartnment.setVisibility(View.GONE);
                }else{
                    tvNoData.setVisibility(View.GONE);
                    tvDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT9.add(data);
                    }
                    tvDepartnment.setHasFixedSize(true);
                    tvDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT9, UpdateFaculty.this, "Teatro Versatil Adviser");
                    tvDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
                    ccDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT10, UpdateFaculty.this, "Coders Club Adviser");
                    ccDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void aceDepartnment() {
        dbRef1 = reference1.child("Ace Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceNoData.setVisibility(View.VISIBLE);
                    aceDepartnment.setVisibility(View.GONE);
                }else{
                    aceNoData.setVisibility(View.GONE);
                    aceDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT11.add(data);
                    }
                    aceDepartnment.setHasFixedSize(true);
                    aceDepartnment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter1 = new TeacherAdapter(listT11, UpdateFaculty.this, "Ace Club Adviser");
                    aceDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}