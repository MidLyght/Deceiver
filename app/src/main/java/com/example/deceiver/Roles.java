package com.example.deceiver;

import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Roles {
    private void RandomizeRoles(){
        ArrayAdapter<String> roles= ArrayAdapter.createFromResource(R.array.Roles);
        for (int i = 1; i <= 9; ++i) number.add(i);
        Collections.shuffle(number);
    }
}
