package com.cavila.mountainbikeprime;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Arrays;

/**
 * Created by cristobalavila on 10/22/13.
 */
public class DetailFragment extends Fragment{

    private static final String TAG = "DetailFragment";

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

    public class Bike {
        String name;
        Integer price;
        Integer weight;
        String webSite;
        String image;

        public Bike() {
            this.name = "";
            this.price = 0;
            this.weight = 0;
            this.webSite = "";
            this.image = "";
        }

        public Bike(String name, Integer price, Integer weight, String webSite, String image) {
            this.name = name;
            this.price = price;
            this.weight = weight;
            this.webSite = webSite;
            this.image = image;
        }

        public void printInfo() {
            System.out.println(name);
            System.out.println(price);
            System.out.println(weight);
            System.out.println(webSite);
            System.out.println(image);
            Log.d(TAG,"Name is: "+name);
        }

    }
    // set array of bikes
    Bike[] bikes = new Bike[5];

    public void setBikesData() {
        Bike bike1 = new Bike("name1",1900,30,"www.bike.com","bike_1.jpg");

        bikes[0] = new Bike("GT Sensor 9R Elite",1900,30,"www.bike.com","bike_1.jpg");
        bikes[1] = new Bike("Kona Hei-Hei 29",1950,30,"www.bike.com","bike_1.jpg");

        bike1.printInfo();
    }
//Todo: change method to receive a Bike object and attach it's properties to each view
    public void setText(String item) {
        item = item + "added in setText";
        TextView view = (TextView) getView().findViewById(R.id.bikeName);
        TextView view2 = (TextView) getView().findViewById(R.id.price);
        view.setText(item);
        view2.setText(item);
        setBikesData();
    }

    public void setBikeData(Integer bikeId) {
        // get clicked button id
            // http://stackoverflow.com/questions/3320115/android-onclicklistener-identify-a-button
        // use that id to match the respective bike in the array
        // update the views with bike's data
//        for (int i = 0; i<=bikes.length; i++) {
//        }

        //item = item + "added in setText";
        TextView view1 = (TextView) getView().findViewById(R.id.bikeName);
        TextView view2 = (TextView) getView().findViewById(R.id.price);
        Bike currentBike = new Bike();


        setBikesData();
//        switch (bikeId) {
//            case 1: currentBike = bikes[0];
//                break;
//            case 2: currentBike = bikes[1];
//                break;
//            default:
//                break;
//        }
        if (bikeId == 1){
            view1.setText(bikes[0].name);
            view2.setText(Integer.toString(bikes[0].price));
        } else if (bikeId == 2){
            view1.setText(bikes[1].name);
            view2.setText(Integer.toString(bikes[1].price));
        }

    }

    public void setPrice(String item) {
        TextView view = (TextView) getView().findViewById(R.id.price);
        view.setText(item);
    }

}
