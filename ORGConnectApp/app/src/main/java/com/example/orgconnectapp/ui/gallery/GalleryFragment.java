package com.example.orgconnectapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orgconnectapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView scRecycler, hmRecycler, symsRecycler, csRecycler, sumsRecycler, pnsRecycler, atsRecycler, uRecycler, tvRecycler, ccRecycler, acRecycler, oeRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        scRecycler = view.findViewById(R.id.scRecycler);
        hmRecycler = view.findViewById(R.id.hmRecycler);
        symsRecycler = view.findViewById(R.id.symsRecycler);
        csRecycler = view.findViewById(R.id.csRecycler);
        sumsRecycler = view.findViewById(R.id.sumsRecycler);
        pnsRecycler = view.findViewById(R.id.pnsRecycler);
        atsRecycler = view.findViewById(R.id.atsRecycler);
        uRecycler = view.findViewById(R.id.uRecycler);
        tvRecycler = view.findViewById(R.id.tvRecycler);
        ccRecycler = view.findViewById(R.id.ccRecycler);
        acRecycler = view.findViewById(R.id.acRecycler);
        oeRecycler = view.findViewById(R.id.oeRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        getScImage();
        getHmImage();
        getSymsImage();
        getCsImage();
        getSumsImage();
        getPnsImage();
        getAtsImage();
        getUImage();
        getTvImage();
        getCcImage();
        getAcImage();
        getOeImage();

        return view;
    }

    private void getScImage() {
        reference.child("Student Council").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                scRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                scRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void getHmImage() {
        reference.child("HM Society").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                hmRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                hmRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getSymsImage() {
        reference.child("SYMS").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                symsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                symsRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getCsImage() {
        reference.child("Computer Society").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                csRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                csRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getSumsImage() {
        reference.child("SUMS").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                sumsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                sumsRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getPnsImage() {
        reference.child("Pen N' Scroll").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                pnsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                pnsRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getAtsImage() {
        reference.child("Athlos Club").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                atsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                atsRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getUImage() {
        reference.child("Unleashed").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                uRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                uRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getTvImage() {
        reference.child("Teatro Versatil").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                tvRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                tvRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getCcImage() {
        reference.child("Coders Club").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                ccRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                ccRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getAcImage() {
        reference.child("Ace Club").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                acRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                acRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void getOeImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data =(String) snapshot.getValue();
                    imageList.add(data);

                }

                adapter = new GalleryAdapter(getContext(), imageList);
                oeRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                oeRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}