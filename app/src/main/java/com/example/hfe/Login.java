package com.example.hfe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mauth;
    ProgressDialog loginProgress;
    EditText et1,et2;
    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1 = findViewById(R.id.login_email);
        et2 = findViewById(R.id.login_password);

        bt1 = findViewById(R.id.btn_login);
        bt2 = findViewById(R.id.btn_signup);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);


        mauth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if(view == bt1){
            String email = et1.getText().toString().trim();
            String pass = et2.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }

            loginProgress = ProgressDialog.show(Login.this, null, "Logging in...", true);
            loginProgress.setCancelable(false);

            mauth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mauth.getCurrentUser();
                                loginProgress.dismiss();
                                startActivity(new Intent(Login.this, Home.class));
                                finish();

                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });
        }
        if(view== bt2){
            startActivity(new Intent(Login.this, Signup.class));
        }
    }
}
