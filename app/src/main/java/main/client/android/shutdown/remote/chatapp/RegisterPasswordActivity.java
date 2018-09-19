package main.client.android.shutdown.remote.chatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPasswordActivity extends AppCompatActivity {

    EditText registerPassword_UtxtPassword;
    EditText registerPassword_UtxtPasswordRetype;
    Button registerPassword_btnNext;
    String email;
    String username;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);

        registerPassword_UtxtPassword = findViewById(R.id.registerPassword_UtxtPassword);
        registerPassword_UtxtPasswordRetype = findViewById(R.id.registerPassword_UtxtPasswordRetype);
        registerPassword_btnNext = findViewById(R.id.registerPassword_btnNext);

        Intent fromRegisterEmail = getIntent();
        email = fromRegisterEmail.getStringExtra("email");
        username = fromRegisterEmail.getStringExtra("username");

        mAuth = FirebaseAuth.getInstance();
    }

    public void createAccount(View view){
        if(registerPassword_UtxtPassword.getText().toString().equals(registerPassword_UtxtPasswordRetype.getText().toString())
                && registerPassword_UtxtPassword.getText().toString().length() > 7){

            mAuth.createUserWithEmailAndPassword(email, registerPassword_UtxtPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent main = new Intent(RegisterPasswordActivity.this, MainActivity.class);
                                startActivity(main);
                                finish();

                            } else {
                                Toast.makeText(RegisterPasswordActivity.this, "Authentication failed. Check your connection",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }else{
            Toast.makeText(RegisterPasswordActivity.this,"Please enter your password, min 8 characters", Toast.LENGTH_LONG).show();
            registerPassword_UtxtPassword.setText("");
            registerPassword_UtxtPasswordRetype.setText("");
        }
    }

}
