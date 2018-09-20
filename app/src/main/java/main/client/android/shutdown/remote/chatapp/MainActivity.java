package main.client.android.shutdown.remote.chatapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


//Activity koji ce prikazvati listu prijatelja
//koji ce provjeriti da li smo logirani
//u slucaju da nismo pozvat ce Home activity
public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Toolbar main_page_bar;
    String email;

    ViewPager tabPager;
    private PageAdapter pageAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        main_page_bar = findViewById(R.id.main_app_bar);

        main_page_bar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(main_page_bar);
        getSupportActionBar().setTitle("ChatApp : ");

        tabLayout = findViewById(R.id.main_tab);

        //tabs
        tabPager = findViewById(R.id.tabPager);
        pageAdapter = new PageAdapter(getSupportFragmentManager());

        tabPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(tabPager);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //u slucaju da nije logiran preusmjeriti na home acitivity
        if(currentUser == null){
            sendToHome();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.main_menu_accountSettings:
                accountSettings();
                break;
            case R.id.main_menu_allUsers:
                allUsers();
                break;
            case R.id.main_menu_exit:
                exit();
                break;
            case R.id.main_menu_logout:
                logout();
                break;
        }
        return true;
    }

    private void exit() {
        System.exit(0);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        sendToHome();
    }

    //TODO uraditi accountSettings u MainActivity
    private void accountSettings() {
        Intent accountSettings = new Intent(MainActivity.this, AccountSettingsActivity.class);
        startActivity(accountSettings);
        finish();
    }

    //TODO uraditi allUsers u MainActivity
    private void allUsers() {

    }

    private void sendToHome(){
        Intent homeActivity = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(homeActivity);
        finish();
    }


}
