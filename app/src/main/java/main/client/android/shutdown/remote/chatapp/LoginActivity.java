package main.client.android.shutdown.remote.chatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    Button login_btnLogin;
    EditText login_UtxtEmail;
    EditText login_UtxtPassword;

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btnLogin = findViewById(R.id.login_btnLogin);
        login_UtxtEmail = findViewById(R.id.login_UtxtEmail);
        login_UtxtPassword = findViewById(R.id.login_UtxtPassword);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
    }

    public void login_Login(View view){
        if(!login_UtxtEmail.getText().toString().isEmpty() &&
                !login_UtxtPassword.getText().toString().isEmpty()){
            progressDialog.setTitle("Logging user");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            provjera(login_UtxtEmail.getText().toString(), login_UtxtPassword.getText().toString());

        }else{
            Toast.makeText(LoginActivity.this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
        }
    }

    //provjerava da li je korisnik logiran, false nije logiran
    private void provjera(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                    mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainActivity);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Please check your credentials", Toast.LENGTH_LONG);
                    progressDialog.hide();
                }
            }
        });
    }
}
