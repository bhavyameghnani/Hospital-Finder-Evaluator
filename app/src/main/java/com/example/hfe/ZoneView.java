package com.example.hfe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ZoneView extends AppCompatActivity implements View.OnClickListener {

    String lati,longi;
    double latitude,longitude;
    DatabaseReference databaseReference;
    String TAG = "BHAVYA";

    TextView t1,t2,t3;
    ImageView i1;
    Button bt1;

    String dep,prob,soll,imageUrl;

    double laaeet,loongeei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_view);

        t1 = findViewById(R.id.title_zoneview);
        t2 = findViewById(R.id.desc_zoneview);
        t3 = findViewById(R.id.sol_zoneview);

        //i1 = findViewById(R.id.imageView_zoneview);
        bt1 = findViewById(R.id.button_zoneview);

        bt1.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        lati = bundle.getString("LATITUDE");
        longi = bundle.getString("LONGITUDE");

        latitude = Double.parseDouble(lati);
        longitude = Double.parseDouble(longi);

        databaseReference = FirebaseDatabase.getInstance().getReference("Mumbai_Zone");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Mumbai_Zone mz = dataSnapshot1.getValue(Mumbai_Zone.class);
                    String mumbai_location = mz.getLocation_Coordinates();

                    System.out.println("Mumbai_Location" + mumbai_location);

                    if (mumbai_location.isEmpty() || mumbai_location.equals("Error")) {
                        System.out.println("JHOL");
                    } else {
                        String[] tokens = mumbai_location.split(",");
                        System.out.println("LAATTIITUDE" + tokens);


                        double laat = Double.parseDouble(tokens[0]);
                        double loongi = Double.parseDouble(tokens[1]);



                    /*Log.d("DEKHH",String.valueOf(laat));
                    Log.d("DEKHHN",String.valueOf(latitude));*/

                        if ((Double.compare(laat, latitude) == 0) && (Double.compare(loongi, longitude) == 0)) {
                            dep = mz.getHospital_Name();
                            prob = mz.getHospital_Category();
                            //imageUrl = mz.getSpecialties();
                            soll = mz.getSpecialties();
                        /*laaeet = Double.parseDouble(zn.getZoneLat());
                        loongeei =Double.parseDouble(zn.getZoneLong());*/
                            //Log.d("DEKH",dep);

                            t1.setText(dep);
                            t2.setText(prob);
                            t3.setText(soll);


                            /*Glide.with(ZoneView.this)
                                    .load(imageUrl)
                                    .into(i1);*/
                        }
                    }
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
        if(view==bt1){
            Uri gmmIntentUri = Uri.parse("google.navigation:q="+laaeet+","+loongeei);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }
    }
}