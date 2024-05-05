package com.example.orgconnectapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.orgconnectapp.ui.orgs.ACE.UpdateAce;
import com.example.orgconnectapp.ui.orgs.ATS.UpdateAts;
import com.example.orgconnectapp.ui.orgs.CC.UpdateCc;
import com.example.orgconnectapp.ui.orgs.CS.UpdateCs;
import com.example.orgconnectapp.ui.orgs.HM.UpdateHm;
import com.example.orgconnectapp.ui.orgs.PNS.UpdatePns;
import com.example.orgconnectapp.ui.orgs.SC.UpdateSc;
import com.example.orgconnectapp.ui.orgs.SUMS.UpdateSums;
import com.example.orgconnectapp.ui.orgs.SYMS.UpdateSyms;
import com.example.orgconnectapp.ui.orgs.TV.UpdateTv;
import com.example.orgconnectapp.ui.orgs.U.UpdateUn;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import android.widget.Toast;

import com.example.orgconnectapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FacultyFragment extends Fragment implements View.OnClickListener{
    private LinearLayout scAdviser, hmAdviser, symsAdviser, csAdviser, sumsAdviser, pnsAdviser, atsAdviser, uAdviser, tvAdviser, ccAdviser, aceAdviser;
    private RecyclerView scDepartnment, hmDepartnment, symsDepartnment, csDepartnment, pnsDepartnment, atcDepartnment, uDepartnment, tvDepartnment, ccDepartnment, aceDepartnment;
    private LinearLayout scNoData, hmNoData, symsNoData, csNoData, pnsNoData, atcNoData, uNoData, tvNoData, ccNoData, aceNoData;
    private List<TeacherData> listT1, listT2, listT3, listT4, listT5, listT6, listT7, listT8, listT9, listT10;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        scAdviser = view.findViewById(R.id.scAdviser);
        hmAdviser = view.findViewById(R.id.hmAdviser);
        symsAdviser = view.findViewById(R.id.symsAdviser);
        csAdviser = view.findViewById(R.id.csAdviser);
        sumsAdviser = view.findViewById(R.id.sumsAdviser);
        pnsAdviser = view.findViewById(R.id.pnsAdviser);
        atsAdviser = view.findViewById(R.id.atsAdviser);
        uAdviser = view.findViewById(R.id.uAdviser);
        tvAdviser = view.findViewById(R.id.tvAdviser);
        ccAdviser = view.findViewById(R.id.ccAdviser);
        aceAdviser = view.findViewById(R.id.aceAdviser);

        scDepartnment = view.findViewById(R.id.scDepartnment);
        hmDepartnment = view.findViewById(R.id.hmDepartnment);
        symsDepartnment = view.findViewById(R.id.symsDepartnment);
        csDepartnment = view.findViewById(R.id.csDepartnment);
        pnsDepartnment = view.findViewById(R.id.pnsDepartnment);
        atcDepartnment = view.findViewById(R.id.atcDepartnment);
        uDepartnment = view.findViewById(R.id.uDepartnment);
        tvDepartnment = view.findViewById(R.id.tvDepartnment);
        ccDepartnment = view.findViewById(R.id.ccDepartnment);
        aceDepartnment = view.findViewById(R.id.aceDepartnment);

        scNoData = view.findViewById(R.id.scNoData);
        hmNoData = view.findViewById(R.id.hmNoData);
        symsNoData = view.findViewById(R.id.symsNoData);
        csNoData = view.findViewById(R.id.csNoData);
        pnsNoData = view.findViewById(R.id.pnsNoData);
        atcNoData = view.findViewById(R.id.atcNoData);
        uNoData = view.findViewById(R.id.uNoData);
        tvNoData = view.findViewById(R.id.tvNoData);
        ccNoData = view.findViewById(R.id.ccNoData);
        aceNoData = view.findViewById(R.id.aceNoData);

        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        scDepartnment();
        hmDepartnment();
        symsDepartnment();
        csDepartnment();
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

        return view;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.scAdviser) {
            Intent intent = new Intent(getContext(), UpdateSc.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.hmAdviser) {
            Intent intent = new Intent(getContext(), UpdateHm.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.symsAdviser) {
            Intent intent = new Intent(getContext(), UpdateSyms.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.csAdviser) {
            Intent intent = new Intent(getContext(), UpdateCs.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.sumsAdviser) {
            Intent intent = new Intent(getContext(), UpdateSums.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.pnsAdviser) {
            Intent intent = new Intent(getContext(), UpdatePns.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.atsAdviser) {
            Intent intent = new Intent(getContext(), UpdateAts.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.uAdviser) {
            Intent intent = new Intent(getContext(), UpdateUn.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.tvAdviser) {
            Intent intent = new Intent(getContext(), UpdateTv.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.ccAdviser) {
            Intent intent = new Intent(getContext(), UpdateCc.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.aceAdviser) {
            Intent intent = new Intent(getContext(), UpdateAce.class);
            startActivity(intent);
        }
    }

    private void scDepartnment() {
        dbRef1 = reference1.child("Student Council Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    scNoData.setVisibility(View.VISIBLE);
                    scDepartnment.setVisibility(View.GONE);
                } else {
                    scNoData.setVisibility(View.GONE);
                    scDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT1.add(data);
                    }
                    scDepartnment.setHasFixedSize(true);
                    scDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT1, getContext(), "Student Council Adviser");
                    scDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hmDepartnment() {
        dbRef1 = reference1.child("HM Society Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    hmNoData.setVisibility(View.VISIBLE);
                    hmDepartnment.setVisibility(View.GONE);
                } else {
                    hmNoData.setVisibility(View.GONE);
                    hmDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT2.add(data);
                    }
                    hmDepartnment.setHasFixedSize(true);
                    hmDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT2, getContext(), "HM Society Adviser");
                    hmDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void symsDepartnment() {
        dbRef1 = reference1.child("SYMS Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    symsNoData.setVisibility(View.VISIBLE);
                    symsDepartnment.setVisibility(View.GONE);
                } else {
                    symsNoData.setVisibility(View.GONE);
                    symsDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT3.add(data);
                    }
                    symsDepartnment.setHasFixedSize(true);
                    symsDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT3,getContext(), "SYMS Adviser");
                    symsDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csDepartnment() {
        dbRef1 = reference1.child("Computer Society Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartnment.setVisibility(View.GONE);
                } else {
                    csNoData.setVisibility(View.GONE);
                    csDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT4.add(data);
                    }
                    csDepartnment.setHasFixedSize(true);
                    csDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT4, getContext(), "Computer Society Adviser");
                    csDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pnsDepartnment() {
        dbRef1 = reference1.child("Pen N' Scroll Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT5 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    pnsNoData.setVisibility(View.VISIBLE);
                    pnsDepartnment.setVisibility(View.GONE);
                } else {
                    pnsNoData.setVisibility(View.GONE);
                    pnsDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT5.add(data);
                    }
                    pnsDepartnment.setHasFixedSize(true);
                    pnsDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT5, getContext(), "Pen N' Scroll Adviser");
                    pnsDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void atcDepartnment() {
        dbRef1 = reference1.child("Athlos Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT6 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    atcNoData.setVisibility(View.VISIBLE);
                    atcDepartnment.setVisibility(View.GONE);
                } else {
                    atcNoData.setVisibility(View.GONE);
                    atcDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT6.add(data);
                    }
                    atcDepartnment.setHasFixedSize(true);
                    atcDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT6, getContext(), "Athlos Club Adviser");
                    atcDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uDepartnment() {
        dbRef1 = reference1.child("Unleashed Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT7 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    uNoData.setVisibility(View.VISIBLE);
                    uDepartnment.setVisibility(View.GONE);
                } else {
                    uNoData.setVisibility(View.GONE);
                    uDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT7.add(data);
                    }
                    uDepartnment.setHasFixedSize(true);
                    uDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT7, getContext(), "Unleashed Adviser");
                    uDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tvDepartnment() {
        dbRef1 = reference1.child("Teatro Versatil Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT8 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    tvNoData.setVisibility(View.VISIBLE);
                    tvDepartnment.setVisibility(View.GONE);
                } else {
                    tvNoData.setVisibility(View.GONE);
                    tvDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT8.add(data);
                    }
                    tvDepartnment.setHasFixedSize(true);
                    tvDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT8, getContext(), "Teatro Versatil Adviser");
                    tvDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ccDepartnment() {
        dbRef1 = reference1.child("Coders Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT9 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    ccNoData.setVisibility(View.VISIBLE);
                    ccDepartnment.setVisibility(View.GONE);
                } else {
                    ccNoData.setVisibility(View.GONE);
                    ccDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT9.add(data);
                    }
                    ccDepartnment.setHasFixedSize(true);
                    ccDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT9, getContext(), "Coders Club Adviser");
                    ccDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aceDepartnment() {
        dbRef1 = reference1.child("Ace Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT10 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    aceNoData.setVisibility(View.VISIBLE);
                    aceDepartnment.setVisibility(View.GONE);
                } else {
                    aceNoData.setVisibility(View.GONE);
                    aceDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT10.add(data);
                    }
                    aceDepartnment.setHasFixedSize(true);
                    aceDepartnment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter1 = new TeacherAdapter(listT10, getContext(), "Ace Club Adviser");
                    aceDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
