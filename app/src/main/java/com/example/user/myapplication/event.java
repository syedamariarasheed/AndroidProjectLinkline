package com.example.user.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class event extends AppCompatActivity {

    List<Artist> artistList;
    DatabaseReference databaseRefEvent;
    ListView listViewE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
       listViewE=(ListView)findViewById(R.id.listviewev);
       artistList=new ArrayList<>();
       databaseRefEvent= FirebaseDatabase.getInstance().getReference("Event");
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseRefEvent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                artistList.clear();
                for(DataSnapshot artistSnapshot: dataSnapshot.getChildren()){
                    Artist artist=artistSnapshot.getValue(Artist.class);
                    artistList.add(artist);
                }

                ArtistList adapter=new ArtistList(event.this,artistList);
                listViewE.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
