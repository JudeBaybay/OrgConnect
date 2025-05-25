package com.example.orgconnectapp.ui.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orgconnectapp.R;
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


public class MenuFragment extends Fragment{

    CardView scMembers, hmMembers, symsMembers, csMembers, sumsMembers, pnsMembers, atsMembers, unMembers, tvMembers, ccMembers, aceMembers;



    public MenuFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        scMembers = view.findViewById(R.id.scMembers);
        hmMembers = view.findViewById(R.id.hmMembers);
        symsMembers = view.findViewById(R.id.symsMembers);
        csMembers = view.findViewById(R.id.csMembers);
        sumsMembers = view.findViewById(R.id.sumsMembers);
        pnsMembers = view.findViewById(R.id.pnsMembers);
        atsMembers = view.findViewById(R.id.atsMembers);
        unMembers = view.findViewById(R.id.unMembers);
        tvMembers = view.findViewById(R.id.tvMembers);
        ccMembers = view.findViewById(R.id.ccMembers);
        aceMembers = view.findViewById(R.id.aceMembers);

        scMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateSc.class);
                startActivity(intent);
            }
        });
        hmMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateHm.class);
                startActivity(intent);
            }
        });
        symsMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateSyms.class);
                startActivity(intent);
            }
        });
        csMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateCs.class);
                startActivity(intent);
            }
        });
        sumsMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateSums.class);
                startActivity(intent);
            }
        });
        pnsMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdatePns.class);
                startActivity(intent);
            }
        });
        atsMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateAts.class);
                startActivity(intent);
            }
        });
        unMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateUn.class);
                startActivity(intent);
            }
        });
        tvMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateTv.class);
                startActivity(intent);
            }
        });
        ccMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateCc.class);
                startActivity(intent);
            }
        });
        aceMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateAce.class);
                startActivity(intent);
            }
        });

        return view;

    }
}