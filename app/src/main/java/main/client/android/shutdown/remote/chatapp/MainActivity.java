package main.client.android.shutdown.remote.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


//Activity koji ce prikazvati listu prijatelja
//koji ce provjeriti da li smo logirani
//u slucaju da nismo pozvat ce Home activity
public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //u slucaju da nije logiran preusmjeriti na home acitivity
        if(currentUser == null){
            Intent homeActivity = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(homeActivity);
            finish();
        }
    }
}
