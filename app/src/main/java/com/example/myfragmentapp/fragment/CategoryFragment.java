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
public class CategoryFragment extends Fragment implements View.OnClickListener {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnToDetailCat = view.findViewById(R.id.btn_to_Detail_Fragment);
        btnToDetailCat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_to_Detail_Fragment:
                //buat object delailfragment
                DetailFragment detailFragment = new DetailFragment();

                Bundle mBundle = new Bundle();
                mBundle.putString(DetailFragment.Extra_Name, "FreeStyle (CatName)");
                String description = "This is Description to FreeStyle Category..^^";

                //masukkan object bundle ke object detailfragment
                detailFragment.setArguments(mBundle);

                //set description
                detailFragment.setDescription(description);

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.container,detailFragment,DetailFragment.class.getSimpleName());
                transaction.addToBackStack(null);
                transaction.commit();

                break;


        }

    }
}
