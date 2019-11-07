package com.example.hfe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class Home extends AppCompatActivity implements View.OnClickListener{

    ImageView bt;
    String TAG = "debug";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bt = findViewById(R.id.maps);

        bt.setOnClickListener(this);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Mumbai_Zone");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int xc = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Mumbai_Zone mz = dataSnapshot1.getValue(Mumbai_Zone.class);
                    Long name = mz.getHID();
                    Log.d(TAG, "Value is: " + name.toString() + "\t count : " + xc++);
//                    String name = mz.getHospital_Name();
//                    Log.d(TAG, "Value is: " + name + "\t count : " + ++xc);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view==bt){
            startActivity(new Intent(this,MapsActivity.class));
        }

    }
}
