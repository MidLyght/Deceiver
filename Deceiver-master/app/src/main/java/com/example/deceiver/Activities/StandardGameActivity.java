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

    private void dawnPowers(){
        ArrayList<StandardCharacter> list = new ArrayList<StandardCharacter>();
        list.add(deceiver);
        list.add(traitor);
        list.add(farmer1);
        list.add(farmer2);
        list.add(guard);
        list.add(blacksmith);
        list.add(witch);
        list.add(seer);

        if(guard.isAlive()){
            Random random=new Random();
            int val=random.nextInt(8);
            while(list.get(val).isAlive()==false||list.get(val)==guard){
                val=random.nextInt(8);
            }
            list.get(val).setProtected(true);
            dawnLog+="The guard has chosen to protect character "+val+".\n";
        }

        if(witch.isAlive()){
            Random random=new Random();
            int val=random.nextInt(8);
            while(list.get(val).isAlive()==false){
                val=random.nextInt(8);
            }
            list.get(val).setVivified(true);
        }

        if(seer.isAlive() && dawnCount%3==0){
            Random random=new Random();
            int val=random.nextInt(8);
            while(list.get(val).isAlive()==false){
                val=random.nextInt(8);
            }
            list.get(val).setExposed(true);
            dawnLog+="The seer has revealed the identity of character "+val+"!\n";
        }
    }

    private void nightPowers(){
        ArrayList<StandardCharacter> list = new ArrayList<StandardCharacter>();
        list.add(deceiver);
        list.add(traitor);
        list.add(farmer1);
        list.add(farmer2);
        list.add(guard);
        list.add(blacksmith);
        list.add(witch);
        list.add(seer);

        if((deceiver.isAlive()&&!deceiver.isHeavilyWounded())||(traitor.isAlive()&&!traitor.isHeavilyWounded()&&!deceiver.isAlive())){
            Random random=new Random();
            int val=random.nextInt(8);
            while(list.get(val).isAlive()==false || list.get(val).getRole()==Deceiver || list.get(val).getRole()==Traitor){
                val=random.nextInt(8);
            }
            if(list.get(val).isHasSword()){
                deceiver.setHeavilyWounded(true);
                traitor.setHeavilyWounded(true);
                deceiver.setWoundCounter(1);
                traitor.setWoundCounter(1);
                blacksmith.setExposed(true);
                nightLog+="The blacksmith has heavily wounded the deceiver!\n";
            }
            else if(list.get(val).isVivified()){
                //
                nightLog+="Character "+val+" was saved by the witch!\n";
                list.get(val).setVivified(false);
            }
            else if(list.get(val).isProtected()){
                guard.setExposed(true);
                guard.setAlive(false);
                nightLog+="The guard died protecting character "+val+".\n";
                list.get(val).setProtected(false);
            }
            else{
                list.get(val).setAlive(false);
                nightLog+="Character "+val+" died.\n";
            }
        }
    }
}