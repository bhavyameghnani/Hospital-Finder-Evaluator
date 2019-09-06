package com.example.hfe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    Button btn_signup;
    EditText name, emailid, home_addr, phone, pass, repass;
    ImageView im1;
    String TAG = "debug";
    FirebaseAuth mAuth;

    String _name;
    String _emailid;
    String _home_addr;
    String _phone;
    String _pass;
    String _repass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name      = findViewById(R.id.signup_name);
        emailid   = findViewById(R.id.signup_emailid);
        home_addr = findViewById(R.id.signup_home_addr);
        phone     = findViewById(R.id.signup_phone);
        pass      = findViewById(R.id.signup_pass);
        repass    = findViewById(R.id.signup_repass);

        btn_signup = findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == btn_signup){
             _name = name.getText().toString().trim();
             _emailid = emailid.getText().toString().trim();
             _home_addr = home_addr.getText().toString().trim();
             _phone = phone.getText().toString().trim();
             _pass = pass.getText().toString().trim();
             _repass = repass.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(_emailid, _pass)

                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override

                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                // Write a message to the database
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("User_Details");

                                String token = FirebaseInstanceId.getInstance().getToken();
                                User_Details user_obj = new User_Details(_name, _emailid, _phone, _home_addr ,"patient", token);
                                //myRef.setValue("Hello, World!");

                                myRef.child(mAuth.getUid()).setValue(user_obj);

                                startActivity(new Intent(Signup.this, Home.class));
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Signup.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });
        }

    }
}
