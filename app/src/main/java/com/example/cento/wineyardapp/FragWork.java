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
import com.example.cento.wineyardapp.DB.Object.Job;
import com.example.cento.wineyardapp.DB.Object.Worker;

import java.util.ArrayList;
import java.util.List;

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

        Worker worker = new Worker();
        worker.setId(1);
        worker.setFirstName("Luca");
        worker.setLastName("Centofanti");
        worker.setMail("lucacentofan@gmail.com");
        worker.setPhone("0788129662");

        Job job1 = new Job();
        job1.setId(1);
        job1.setWorker(worker);
        job1.setDescription("Taille");
        job1.setDeadline("28.12.2017");
        job1.setWinelotId(1);

        Job job2 = new Job();
        job2.setId(2);
        job2.setWorker(worker);
        job2.setDescription("Coupe");
        job2.setDeadline("28.12.2017");
        job2.setWinelotId(1);

        Job job3 = new Job();
        job3.setId(3);
        job3.setWorker(worker);
        job3.setDescription("Désherbage");
        job3.setDeadline("28.12.2017");
        job3.setWinelotId(1);

        List<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);

        ListView listView = (ListView)view.findViewById(R.id.listofwork);

        WorkAdapter listViewAdapter = new WorkAdapter(
                getActivity(),
                jobs
        );

        listView.setAdapter(listViewAdapter);
        return view;
    }
}
