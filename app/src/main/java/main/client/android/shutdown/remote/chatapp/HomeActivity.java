package main.client.android.shutdown.remote.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
    }


    public void register(View view){
        Intent register = new Intent(HomeActivity.this, RegisterEmailActivity.class);
        startActivity(register);
        finish();
    }

    public void login(View view){
        Intent login = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(login);
    }
}
