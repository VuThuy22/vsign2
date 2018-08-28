package com.example.elcomplus.vsign.screens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.elcomplus.vsign.R;
import com.example.elcomplus.vsign.screens.base.BaseActivity;
import com.example.elcomplus.vsign.screens.fragment.MySignFragment;
import com.example.elcomplus.vsign.screens.fragment.ServiceVsignFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private Fragment mySignFragment, serviceVsignFragment, receiverFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setToolbarTitle(toobar,"Chữ ký của tôi",true);
        navigation.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) mOnNavigationItemSelectedListener);
       initFragment();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                        toobar.setTitle(R.string.title_mysign);
                        replaceFragment(receiverFragment);
                    return true;
                case R.id.navigation_vsign:
                        appbar.setVisibility(View.VISIBLE);
                        toobar.setTitle(R.string.title_Vsign);
                        replaceFragment(serviceVsignFragment);
                    return false;
            }
            return false;
        }
    };
    private void initFragment(){
        mySignFragment= MySignFragment.newInstance();
        receiverFragment=mySignFragment;
        serviceVsignFragment= ServiceVsignFragment.newInstance();
        replaceFragment(receiverFragment);

    }
    public  void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,mySignFragment.getTag()).commit();
    }



}
