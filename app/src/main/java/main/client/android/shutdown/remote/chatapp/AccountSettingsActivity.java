package main.client.android.shutdown.remote.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
                    .child(firebaseUser.getUid().toString());

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
}
