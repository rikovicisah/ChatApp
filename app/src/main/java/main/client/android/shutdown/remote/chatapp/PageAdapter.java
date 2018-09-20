package main.client.android.shutdown.remote.chatapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class PageAdapter extends FragmentPagerAdapter{

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;// jer imamo tri taba
    }


    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position){
            case 0:
                RequestFragment requestFragment = new RequestFragment();
                f = requestFragment;
                break;
            case 1:
                ChatFragment chatFragment = new ChatFragment();
                f = chatFragment;
                break;
            case 2:
                FriendsFragment friendsFragment = new FriendsFragment();
                f = friendsFragment;
                break;
        }
        return f;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        switch (position){
            case 0: return "Request";
            case 1: return "Chat";
            case 2: return "Friends";
            default: return null;
        }
    }
}
