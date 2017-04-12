package com.bc.eternal.subo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.bc.eternal.subo.R;
import com.bc.eternal.subo.ui.adapter.LiveAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hasee on 2017/4/11.
 */

public class LiveFragment extends Fragment {
    @BindView(R.id.live_tab)
    TabLayout liveTab;
    @BindView(R.id.live_vp)
    ViewPager liveVp;
    Unbinder unbinder;
    private View view;
    private LiveAdapter mLiveAdapter;
    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表
    private HotFragment mHotFragment;
    private FollowFragment mFollowFragment;
    private NearbyFragment mNearbyFragment;
    private SkillFragment mSkillFragment;
    private VoiceFragment mVoiceFragment;
    private VideoFragment mVideoFragment;
    private GameFragment mGameFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_live, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mFollowFragment=new FollowFragment();
        mHotFragment=new HotFragment();
        mNearbyFragment=new NearbyFragment();
        mFollowFragment=new FollowFragment();
        mSkillFragment=new SkillFragment();
        mGameFragment=new GameFragment();
        mVideoFragment=new VideoFragment();
        mVoiceFragment=new VoiceFragment();



        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(mFollowFragment);
        list_fragment.add(mHotFragment);
        list_fragment.add(mNearbyFragment);
        list_fragment.add(mVideoFragment);
        list_fragment.add(mGameFragment);
        list_fragment.add(mSkillFragment);
        list_fragment.add(mVoiceFragment);


        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("关注");
        list_title.add("热门");
        list_title.add("附近");
        list_title.add("视频");
        list_title.add("游戏");
        list_title.add("才艺");
        list_title.add("好声音");


        liveTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        //为TabLayout添加tab名称
        liveTab.addTab(liveTab.newTab().setText(list_title.get(0)));
        liveTab.addTab(liveTab.newTab().setText(list_title.get(1)));
        liveTab.addTab(liveTab.newTab().setText(list_title.get(2)));
        liveTab.addTab(liveTab.newTab().setText(list_title.get(3)));
        liveTab.addTab(liveTab.newTab().setText(list_title.get(4)));
        liveTab.addTab(liveTab.newTab().setText(list_title.get(5)));
        liveTab.addTab(liveTab.newTab().setText(list_title.get(6)));


        mLiveAdapter=new LiveAdapter(getActivity().getSupportFragmentManager(),list_fragment,list_title);
        //viewpager加载adapter
        liveVp.setAdapter(mLiveAdapter);
        //TabLayout加载viewpager
        liveTab.setupWithViewPager(liveVp);

    }


}
