package com.zx.fragment_fragment_data;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {

    private TextView resultTv;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //注册
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解绑
        EventBus.getDefault().unregister(this);
    }

    //事件接收
    @Subscribe
    public void onEvent(Integer count){
        resultTv.setText(String.valueOf(count));
    }

    //初始化View
    private void initView(View view) {
        resultTv = (TextView) view.findViewById(R.id.result_tv);
    }

    //供Activity调用的方法
    public void update(int count) {
        resultTv.setText(String.valueOf(count));
    }

}
