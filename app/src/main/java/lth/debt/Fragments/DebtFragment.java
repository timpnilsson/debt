package lth.debt.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lth.debt.R;

/**
 * Created by Carl on 2015-06-29.
 */
public class DebtFragment extends Fragment {

    public static DebtFragment newInstance() {
        DebtFragment fragment = new DebtFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.debt_fragment, container, false);
    }
}
