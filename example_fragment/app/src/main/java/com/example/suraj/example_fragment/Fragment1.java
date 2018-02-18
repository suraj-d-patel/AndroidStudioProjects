package com.example.suraj.example_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by suraj on 27/1/18.
 */

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){

        return inflater.inflate(R.layout.fragment1,container,false);
    }
}
