package com.example.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collegeapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.data.Indicator;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;

    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });


        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Mahaveer Ambesh Guru PG College, Purana Bazar, Fatehnagar");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);



    }

    private void setSliderViews() {
        for (int i = 0; i < 5; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                    case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-application-3-55d3d.appspot.com/o/Chemistry-Lab%20of%20Mahaveer%20Ambesh%20Guru%20PG%20College%20Fatehnagar_Laboratory.jpg?alt=media&token=dfb0143a-c58f-4489-acf6-e0b90c4b2b9e");
                    break;
                    case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-application-3-55d3d.appspot.com/o/Computer%20Lab%20of%20Mahaveer%20Ambesh%20Guru%20PG%20College%20Fatehnagar_IT-Lab.jpg?alt=media&token=f36a5ab0-0f82-4a12-8eb5-8e3c14dd6e33");
                    break;
                    case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-application-3-55d3d.appspot.com/o/Events%20of%20Mahaveer%20Ambesh%20Guru%20PG%20College%20Fatehnagar_Events.jpg?alt=media&token=005ba9d7-1c11-42cd-a5bf-2c4de2b2dbbc");
                    break;
                    case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-application-3-55d3d.appspot.com/o/Geography-Lab%20of%20Mahaveer%20Ambesh%20Guru%20PG%20College%20Fatehnagar_Laboratory.jpg?alt=media&token=ca3e9d79-19a5-466f-8143-32186db42482");
                    break;
                    case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-application-3-55d3d.appspot.com/o/Physic%20lab%20of%20Mahaveer%20Ambesh%20Guru%20PG%20College%20Fatehnagar_Laboratory.jpg?alt=media&token=601e35c1-6c4a-48c1-83b2-4fe4f761c2dc");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);

        }
    }
}