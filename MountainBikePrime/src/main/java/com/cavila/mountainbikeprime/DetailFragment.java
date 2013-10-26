package com.cavila.mountainbikeprime;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cristobalavila on 10/22/13.
 */
public class DetailFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mbitem_detail,
                container, false);
        return view;
    }
String[] bikeInfo = {"bike1", "bike2", "bike3"};
// try to get this data from xml
// 2. receive that bike code parameter here and pass the bike info according to bike code (like an object property by id)

    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.bikeName);
        TextView view2 = (TextView) getView().findViewById(R.id.price);
        view.setText(item);
        view2.setText(item);
    }

    public void setPrice(String item) {
        TextView view = (TextView) getView().findViewById(R.id.price);
        view.setText(item);
    }

}
