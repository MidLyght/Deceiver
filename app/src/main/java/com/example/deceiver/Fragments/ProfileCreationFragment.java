package com.example.deceiver.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.deceiver.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileCreationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileCreationFragment extends Fragment {

    private View objectProfileCreationFragment;
    private ImageButton profileEditPicImgBtn, profileEditFavRole1ImgBtn, profileEditFavRole2ImgBtn, profileEditFavRole3ImgBtn;
    private EditText profileEditUsernameEt, profileEditBioEt, profileEditLocationEt;
    private Button profileEditBack, profileEditApply;

    private void attachComponents(){
        profileEditPicImgBtn=objectProfileCreationFragment.findViewById(R.id.profileEditPicImgBtn);
        profileEditFavRole1ImgBtn=objectProfileCreationFragment.findViewById(R.id.profileEditFavRole1ImgBtn);
        profileEditFavRole2ImgBtn=objectProfileCreationFragment.findViewById(R.id.profileEditFavRole2ImgBtn);
        profileEditFavRole3ImgBtn=objectProfileCreationFragment.findViewById(R.id.profileEditFavRole3ImgBtn);
        profileEditUsernameEt=objectProfileCreationFragment.findViewById(R.id.profileEditUsernameEt);
        profileEditBioEt=objectProfileCreationFragment.findViewById(R.id.profileEditBioEt);
        profileEditLocationEt=objectProfileCreationFragment.findViewById(R.id.profileEditLocationEt);
        profileEditBack=objectProfileCreationFragment.findViewById(R.id.profileEditBack);
        profileEditApply=objectProfileCreationFragment.findViewById(R.id.profileEditApply);
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileCreationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileCreationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileCreationFragment newInstance(String param1, String param2) {
        ProfileCreationFragment fragment = new ProfileCreationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        objectProfileCreationFragment=inflater.inflate(R.layout.fragment_profile_creation,container,false);
        attachComponents();

        return objectProfileCreationFragment;
    }
}