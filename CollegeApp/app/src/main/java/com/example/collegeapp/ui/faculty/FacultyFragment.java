package com.example.collegeapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView BcaDepartment, McaDepartment, BscDepartment, BaDepartment;
    private LinearLayout BcaNoData, McaNoData, BscNoData, BaNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        BcaDepartment = view.findViewById(R.id.BcaDepartment);
        McaDepartment = view.findViewById(R.id.McaDepartment);
        BscDepartment = view.findViewById(R.id.BscDepartment);
        BaDepartment = view.findViewById(R.id.BaDepartment);

        BcaNoData = view.findViewById(R.id.BcaNoData);
        McaNoData = view.findViewById(R.id.McaNoData);
        BscNoData = view.findViewById(R.id.BscNoData);
        BaNoData = view.findViewById(R.id.BaNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        BcaDepartment();
        McaDepartment();
        BscDepartment();
        BaDepartment();

        return view;
    }

    private void BcaDepartment() {
        dbref = reference.child("BCA");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list1 = new ArrayList<>();
                if (!datasnapshot.exists()) {
                    BcaNoData.setVisibility(View.VISIBLE);
                    BcaDepartment.setVisibility(View.GONE);
                } else {
                    BcaNoData.setVisibility(View.GONE);
                    BcaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        Log.i("data", " " + data.getName());
                        list1.add(data);


                    }
                    if (list1.size() > 0) {

                    }
                    BcaDepartment.setHasFixedSize(true);
                    BcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    BcaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void McaDepartment() {
        dbref = reference.child("MCA");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list2 = new ArrayList<>();
                if (!datasnapshot.exists()) {
                    McaNoData.setVisibility(View.VISIBLE);
                    McaDepartment.setVisibility(View.GONE);
                } else {
                    McaNoData.setVisibility(View.GONE);
                    McaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    McaDepartment.setHasFixedSize(true);
                    McaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    McaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void BscDepartment() {
        dbref = reference.child("BSC");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list3 = new ArrayList<>();
                if (!datasnapshot.exists()) {
                    BscNoData.setVisibility(View.VISIBLE);
                    BscDepartment.setVisibility(View.GONE);
                } else {
                    BscNoData.setVisibility(View.GONE);
                    BscDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    BscDepartment.setHasFixedSize(true);
                    BscDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    BscDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void BaDepartment() {
        dbref = reference.child("BA");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list4 = new ArrayList<>();
                if (!datasnapshot.exists()) {
                    BaNoData.setVisibility(View.VISIBLE);
                    BaDepartment.setVisibility(View.GONE);
                } else {
                    BaNoData.setVisibility(View.GONE);
                    BaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    BaDepartment.setHasFixedSize(true);
                    BaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    BaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}