package com.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by nuri on 16.08.2018
 */
public class SampleActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SampleView view = findViewById(R.id.sample_view);
        SampleView opt_view = findViewById(R.id.opt_sample_view);
        SampleView def_view = new SampleView(this);
        SampleViewWithNonRes pView = new SampleViewWithNonRes(this);
        System.out.println("");
    }
}
