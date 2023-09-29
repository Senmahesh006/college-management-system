package com.example.collegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView    IndependenceRecycler,RepublicRecycler,EventsRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        IndependenceRecycler = view.findViewById(R.id.IndependenceRecycler);
        RepublicRecycler = view.findViewById(R.id.RepublicRecycler);
        EventsRecycler = view.findViewById(R.id.EventsRecycler);


        reference = FirebaseDatabase.getInstance().getReference("gallery");

        getIndepImage();

        getRepImage();

        getOtherImage();



        return view;
    }

    private void getRepImage() {
        reference.child("Republic Day").addValueEventListener(new ValueEventListener() {

            List<String>imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = snapshot.getValue().toString();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                RepublicRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                RepublicRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }

    private void getIndepImage() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {

            List<String>imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = snapshot.getValue().toString();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                IndependenceRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                IndependenceRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }
      private void getOtherImage() {
          reference.child("Other Events").addValueEventListener(new ValueEventListener() {

              List<String>imageList = new ArrayList<>();
              @Override
              public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                  for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                      String data = snapshot.getValue().toString();
                      imageList.add(data);
                  }

                  adapter = new GalleryAdapter(getContext(),imageList);
                  EventsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                  EventsRecycler.setAdapter(adapter);

              }

              @Override
              public void onCancelled(@NonNull DatabaseError databaseError) {


              }
          });


      }


}