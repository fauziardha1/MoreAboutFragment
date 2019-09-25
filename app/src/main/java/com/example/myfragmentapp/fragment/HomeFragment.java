package com.example.myfragmentapp.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myfragmentapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnToCategoryFragment = view.findViewById(R.id.btnToCategoryFragment);
        btnToCategoryFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // jika button di klik maka lakukan aksi

        if (v.getId() == R.id.btnToCategoryFragment) {
//            Toast.makeText(getContext(),"HomeFragment",Toast.LENGTH_LONG).show();

            // cek apakah sudah ada object detail fragment sebelumnya?
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            CategoryFragment categoryFragment = new CategoryFragment();

            if(manager != null){
                transaction.replace(R.id.container,categoryFragment,CategoryFragment.class.getSimpleName());
                transaction.addToBackStack(null);
                transaction.commit();
                Toast.makeText(getContext(),"Category Fragment",Toast.LENGTH_LONG).show();
            }

        }
    }
}
