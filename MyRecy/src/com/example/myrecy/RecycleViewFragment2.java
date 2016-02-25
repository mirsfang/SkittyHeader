package com.example.myrecy;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecycleViewFragment2 extends BaseFragmentRe {


	private RecycleViewAdapter adapter;
    private RecyclerView mRecycleView;
    String title;
    public static RecycleViewFragment2 newInstance(RecycleViewAdapter adapter) {
    	RecycleViewFragment2 fragment = new RecycleViewFragment2();
        fragment.adapter=adapter;
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycleView=(RecyclerView) view.findViewById(R.id.id_stickynavlayout_innerscrollview);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false));
      
        mRecycleView.setAdapter(adapter);
        adapter.setOnItemOnClickListener(new RecycleViewAdapter.OnItemOnClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(getActivity(), "click 排行" + position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClickListener(View view, int position) {
                Toast.makeText(getActivity(), "Long-click 排行" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public String getTitle() {
        return "排行";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
