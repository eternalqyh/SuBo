package com.bc.eternal.subo.ui.activity.sub;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bc.eternal.subo.R;
import com.bc.eternal.subo.ui.fragment.LiveFragment;
import com.bc.eternal.subo.ui.fragment.MypageFragment;
import com.bc.eternal.subo.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_fragment)
    FrameLayout mainFragment;
    @BindView(R.id.rbtn_live)
    RadioButton rbtnLive;
    @BindView(R.id.rbtn_mypage)
    RadioButton rbtnMypage;
    @BindView(R.id.main_radiogroup)
    RadioGroup mainRadiogroup;
    private Context mContext;
    private Fragment mliveFragment;
    private Fragment mmypageFragment;
    private FragmentManager fm;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;
        initEvents();
        fragmentselect(0);

    }

    private void fragmentselect(int i) {
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
                if (mliveFragment == null) {
                        mliveFragment = new LiveFragment();
                        transaction.add(R.id.main_fragment, mliveFragment);
                } else {
                    transaction.show(mliveFragment);
                }
                break;
            case 1:
                if (mmypageFragment == null) {
                    mmypageFragment = new MypageFragment();
                    transaction.add(R.id.main_fragment, mmypageFragment);
                } else {
                    transaction.show(mmypageFragment);
                }
                break;
        }
        transaction.commit();
    }

    //初始隐藏所有fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (mliveFragment != null) {
            transaction.hide(mliveFragment);
        }
        if (mmypageFragment != null) {
            transaction.hide(mmypageFragment);
        }
    }


    private void initEvents() {

        mainRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbtn_live:
                        fragmentselect(0);
                        break;
                    case R.id.rbtn_mypage:
                        fragmentselect(1);
                        break;
                }
            }
        });


    }

}
