package com.example.cento.wineyardapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bof.navigationdrawerwineyard.R;

import static android.R.attr.description;

/**
 * Created by flavien on 19/04/17.
 */

public class FragWork extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_work,container, false);

        String[] action ={"Deminage",
                "Forniquage",
                "Flavienage",
                "Centage"};

        ListView listView = (ListView)view.findViewById(R.id.listofwork);

        ArrayAdapter<String> listviewadapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.doublelist,
                R.id.action,
                action
        );

        listView.setAdapter(listviewadapter);
        return view;
    }
}
