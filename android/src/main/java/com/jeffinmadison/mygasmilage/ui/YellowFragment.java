package com.jeffinmadison.mygasmilage.ui;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeffinmadison.mygasmilage.R;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class YellowFragment extends Fragment {
    private static final String TAG = YellowFragment.class.getSimpleName();

    public YellowFragment() {
        // Required empty public constructor
    }

    public static Fragment getInstance() {
        YellowFragment fragment = new YellowFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yellow, container, false);
    }


}
