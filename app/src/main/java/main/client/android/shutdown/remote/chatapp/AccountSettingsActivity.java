package main.client.android.shutdown.remote.chatapp;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountSettingsActivity extends AppCompatActivity {

    Button accountSettings_btnChangeStatus;
    Button accountSettings_btnChangeImage;

    TextView accountSettings_txtName;
    TextView accountSettings_txtStatus;
    CircleImageView profile_image;

    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;

    String username;
    String status;
    String newStatus;
    String imageD;
    String thumbimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        accountSettings_btnChangeStatus = findViewById(R.id.accountSettings_btnChangeStatus);
        accountSettings_btnChangeImage = findViewById(R.id.accountSettings_btnChangeImage);

        accountSettings_txtName = findViewById(R.id.accountSettings_txtName);
        accountSettings_txtStatus = findViewById(R.id.accountSettings_txtStatus);
        profile_image = findViewById(R.id.profile_image);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null) {
            databaseReference = FirebaseDatabase.getInstance()
                    .getReference()
                    .child("Users")
                    .child(firebaseUser.getUid());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    username = dataSnapshot.child("username").getValue().toString();
                    status = dataSnapshot.child("status").getValue().toString();
                    imageD = dataSnapshot.child("image").getValue().toString();
                    thumbimage = dataSnapshot.child("thumbImage").getValue().toString();

                    accountSettings_txtName.setText(username);
                    accountSettings_txtStatus.setText(status);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }


    public void changeStatus(View view){
        alertDialog();
    }

    public void changeImage(View view){

    }

    private void alertDialog(){
        final EditText nStatus = new EditText(AccountSettingsActivity.this);
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(AccountSettingsActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(AccountSettingsActivity.this);
        }
        builder.setView(nStatus);
        builder.setTitle("Change status")
                .setMessage("Please enter your new status")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(!nStatus.getText().toString().isEmpty()){
                            if(firebaseUser != null) {
                                FirebaseDatabase.getInstance().getReference()
                                        .child("Users")
                                        .child(firebaseUser.getUid())
                                        .child("status")
                                        .setValue(nStatus.getText().toString());
                            }
                        }//if
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
