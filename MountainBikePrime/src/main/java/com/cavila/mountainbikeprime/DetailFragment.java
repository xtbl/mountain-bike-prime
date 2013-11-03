package com.cavila.mountainbikeprime;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

        public String getName() {
            return name;
        }

        public String getPrice() {
            return Integer.toString(price);
        }

        public String getWeight() {
            return Integer.toString(weight);
        }

        public String getWebSite() {
            return webSite;
        }

        public String getImage() {
            return image;
        }
    }
    // set array of bikes
    Bike[] bikes = new Bike[5];

    public void setBikesData() {

        bikes[0] = new Bike("GT Sensor 9R Elite",1980,30,"gtbicycles.com","gt_sensor_elite");
        bikes[1] = new Bike("Kona Hei-Hei 29",1990,30,"konaworld.com","kona_hei_hei");
        bikes[2] = new Bike("Santa Cruz Superlight",1850,29,"santacruzbicycles.com","santa_cruz_superlight");
        bikes[3] = new Bike("Scott Spark 29 Team",1850,28,"scottusa.com","scott_spark_29_team");
        bikes[4] = new Bike("Marin Rift Zone XC6",2000,30,"marinbikes.com","marin_rift_zone_xc6");
    }


    public void setBikeData(Integer bikeId) {
        // get clicked button id
        // use that id to match the respective bike in the array

        TextView nameView = (TextView) getView().findViewById(R.id.bikeName);
        TextView priceView = (TextView) getView().findViewById(R.id.price);
        TextView weightView = (TextView) getView().findViewById(R.id.weight);
        TextView webSiteView = (TextView) getView().findViewById(R.id.website);
        LinearLayout detailLayout = (LinearLayout) getView().findViewById(R.id.detailLayout);

        setBikesData();
        Integer currentBikeId = bikeId - 1;

        nameView.setText(bikes[currentBikeId].getName());
        priceView.setText("Price: $"+ bikes[currentBikeId].getPrice());
        weightView.setText("Weight: " + bikes[currentBikeId].getWeight() + "lbs");
        webSiteView.setText("Website: " + bikes[currentBikeId].getWebSite());
        int bikeImageId = getResources().getIdentifier(bikes[currentBikeId].getImage(),
                                                    "drawable", "com.cavila.mountainbikeprime");
        detailLayout.setBackgroundResource(bikeImageId);
    }

}

//todo: look and feel
//todo: change default image and text
//todo: initial screen
//todo: credits
//todo: get data from xml
//todo: get data from sqlite