package main.client.android.shutdown.remote.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountSettingsActivity extends AppCompatActivity {

    Button accountSettings_btnChangeStatus;
    Button accountSettings_btnChangeImage;
    TextView accountSettings_txtName;
    TextView accountSettings_txtStatus;
    CircleImageView profile_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        accountSettings_btnChangeStatus = findViewById(R.id.accountSettings_btnChangeStatus);
        accountSettings_btnChangeImage = findViewById(R.id.accountSettings_btnChangeImage);
        accountSettings_txtName = findViewById(R.id.accountSettings_txtName);
        accountSettings_txtStatus = findViewById(R.id.accountSettings_txtStatus);
        profile_image = findViewById(R.id.profile_image);
    }
}
