package com.example.myfragmentapp.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {

    public final static String Extra_Name = "Category Name";
    public final static String Extra_Description = "Category Description";
    private String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // semua inisiasi berada disini
        TextView tvCatName = view.findViewById(R.id.tvCatName);
        TextView tvCatDesc = view.findViewById(R.id.tv_cat_description);
        Button btnToProfile = view.findViewById(R.id.btn_to_go_to_profile);
        Button btnToShowDialog = view.findViewById(R.id.btn_show_dialog);

        btnToProfile.setOnClickListener(this);
        btnToShowDialog.setOnClickListener(this);


        // saat view sudah terbuat maka ambil bundle dan set tvCatName dan tvCatDesc
        tvCatName.setText(getArguments().getString(Extra_Name));
        tvCatDesc.setText(getDescription());

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_to_go_to_profile:
                Toast.makeText(getContext(),"Button to Go to Profile",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_show_dialog:
                Toast.makeText(getContext(),"Button to Show Dialog",Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
