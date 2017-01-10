package com.zx.fragment_fragment_data;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Fragment&&Fragment之间传值的2种方式
 *
 * 1、使用接口，通过Activity宿主作为中间桥梁，进行数据交互
 *
 * 1）定义数据接口
 * 2）在Activity中实现该接口，并实现接口中定义的方法
 * 3）在Fragment A中声明接口对象,并调用接口中的方法
 * 4)Activity中的接口回调中，向Fragment B传递数据
 *
 * 2、EventBus框架传递数据
 *
 */
public class MainActivity extends AppCompatActivity implements IAddListener{

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
    }

    //初始化Fragment
    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        AFragment aFragment = new AFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_a,aFragment,"AFragment");
        transaction.add(R.id.fragment_b,new BFragment(),"BFragment");
        transaction.commit();
        aFragment.setIAddListener(this); //传递接口对象
    }

    //回调的接口
    @Override
    public void update(int count) {
        BFragment bFragment = (BFragment) fragmentManager.findFragmentByTag("BFragment");
        bFragment.update(count);
    }
}
