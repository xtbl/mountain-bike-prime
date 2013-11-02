package com.cavila.mountainbikeprime;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by cristobalavila on 10/22/13.
 */
public class MyListFragment extends Fragment{
    private OnItemSelectedListener listener;
    public Integer buttonId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mblist_overview,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonId = 1;
                updateBikeDetails(buttonId);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonId = 2;
                updateBikeDetails(buttonId);
            }
        });

        return view;
    }

    public interface OnItemSelectedListener {
        public void onMBItemSelected(Integer link);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

// 1. send a bike code from the clicked button as a parameter

    // May also be triggered from the Activity
    public void updateDetail() {
        // create fake data
        String newTime = String.valueOf(System.currentTimeMillis());
        // Send data to Activity
        listener.onMBItemSelected(1);
    }
    // May also be triggered from the Activity
    public void updateBikeDetails(Integer btnId) {
        // create fake data
        //String newTime = String.valueOf(System.currentTimeMillis());
        // Send data to Activity
        listener.onMBItemSelected(btnId);
    }

}
