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
public class GreenFragment extends Fragment {
    private static final String TAG = GreenFragment.class.getSimpleName();

    public GreenFragment() {
        // Required empty public constructor
    }

    public static Fragment getInstance() {
        GreenFragment fragment = new GreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_green, container, false);
    }
}
