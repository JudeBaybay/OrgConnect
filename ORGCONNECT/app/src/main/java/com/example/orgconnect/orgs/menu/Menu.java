package com.example.orgconnect.orgs.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


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

public class Menu extends AppCompatActivity implements View.OnClickListener {

    CardView scMembers, hmMembers, symsMembers, csMembers, sumsMembers, pnsMembers, atsMembers, unMembers, tvMembers, ccMembers, aceMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        scMembers = findViewById(R.id.scMembers);
        hmMembers = findViewById(R.id.hmMembers);
        symsMembers = findViewById(R.id.symsMembers);
        csMembers = findViewById(R.id.csMembers);
        sumsMembers = findViewById(R.id.sumsMembers);
        pnsMembers = findViewById(R.id.pnsMembers);
        atsMembers = findViewById(R.id.atsMembers);
        unMembers = findViewById(R.id.unMembers);
        tvMembers = findViewById(R.id.tvMembers);
        ccMembers = findViewById(R.id.ccMembers);
        aceMembers = findViewById(R.id.aceMembers);

        scMembers.setOnClickListener(this);
        hmMembers.setOnClickListener(this);
        symsMembers.setOnClickListener(this);
        csMembers.setOnClickListener(this);
        sumsMembers.setOnClickListener(this);
        pnsMembers.setOnClickListener(this);
        atsMembers.setOnClickListener(this);
        unMembers.setOnClickListener(this);
        tvMembers.setOnClickListener(this);
        ccMembers.setOnClickListener(this);
        aceMembers.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.scMembers){
            Intent intent = new Intent(Menu.this, UpdateSc.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.hmMembers){
            Intent intent = new Intent(Menu.this, UpdateHm.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.symsMembers){
            Intent intent = new Intent(Menu.this, UpdateSyms.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.csMembers){
            Intent intent = new Intent(Menu.this, UpdateCs.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.sumsMembers){
            Intent intent = new Intent(Menu.this, UpdateSums.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.pnsMembers){
            Intent intent = new Intent(Menu.this, UpdatePns.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.atsMembers){
            Intent intent = new Intent(Menu.this, UpdateAts.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.unMembers){
            Intent intent = new Intent(Menu.this, UpdateUn.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.tvMembers){
            Intent intent = new Intent(Menu.this, UpdateTv.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.ccMembers){
            Intent intent = new Intent(Menu.this, UpdateCc.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.aceMembers){
            Intent intent = new Intent(Menu.this, UpdateAce.class);
            startActivity(intent);
        }
    }
}
