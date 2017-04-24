package com.example.cento.wineyardapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bof.navigationdrawerwineyard.R;

/**
 * Created by flavien on 19/04/17.
 */

public class FragLocationList extends Fragment implements AdapterView.OnItemClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_location_list, container, false);


        String[] action ={"A",
                "B",
                "C",
                "D"};

        ListView listView = (ListView)view.findViewById(R.id.listOfLocation);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.mylocationlist,
                R.id.locationName,
                action
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
