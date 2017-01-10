package com.zx.fragment_fragment_data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private int count; //计数器，表示向Fragment B传递的数据
    private IAddListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);
        initView(view);
        return view;
    }

    //初始化View
    private void initView(View view) {
        view.findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //数字加1，向Fragment B传递数据
                count++;
                //listener.update(count); //传递数据
                EventBus.getDefault().post(Integer.valueOf(count));
            }
        });
    }

    //实例化接口对象
    public  void setIAddListener(IAddListener listener){
        this.listener = listener;
    }

}
