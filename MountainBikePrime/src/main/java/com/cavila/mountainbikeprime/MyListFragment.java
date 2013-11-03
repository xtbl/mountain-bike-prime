package com.cavila.mountainbikeprime;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment{
    private OnItemSelectedListener listener;
    public Integer buttonId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mblist_overview,
                container, false);
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);
        Button button5 = (Button) view.findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
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
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonId = 3;
                updateBikeDetails(buttonId);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonId = 4;
                updateBikeDetails(buttonId);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonId = 5;
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

    // May also be triggered from the Activity
    public void updateBikeDetails(Integer btnId) {
        // Send data to Activity
        listener.onMBItemSelected(btnId);
    }

}
