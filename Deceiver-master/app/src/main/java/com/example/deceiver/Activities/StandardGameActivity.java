package com.example.deceiver.Activities;

import static com.example.deceiver.Enums.StandardRole.Blacksmith;
import static com.example.deceiver.Enums.StandardRole.Deceiver;
import static com.example.deceiver.Enums.StandardRole.Farmer;
import static com.example.deceiver.Enums.StandardRole.Guard;
import static com.example.deceiver.Enums.StandardRole.Seer;
import static com.example.deceiver.Enums.StandardRole.Traitor;
import static com.example.deceiver.Enums.StandardRole.Witch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.deceiver.DataClasses.StandardCharacter;
import com.example.deceiver.Fragments.LogInFragment;
import com.example.deceiver.Enums.Phase;
import com.example.deceiver.Enums.StandardTeam;
import com.example.deceiver.Fragments.StandardGameDawnFragment;
import com.example.deceiver.Fragments.StandardGameDawnLogFragment;
import com.example.deceiver.Fragments.StandardGameDayFragment;
import com.example.deceiver.Fragments.StandardGameNightFragment;
import com.example.deceiver.Fragments.StandardGameNightLogFragment;
import com.example.deceiver.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StandardGameActivity extends AppCompatActivity {

    public StandardCharacter deceiver,traitor,farmer1,farmer2,witch,blacksmith,seer,guard;
    public ArrayList<StandardCharacter> order;
    public int dayCount=1,dawnCount=1,nightCount=0;
    public String dawnLog,nightLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_game);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutGame, new StandardGameDawnFragment());
        ft.commit();
    }
}