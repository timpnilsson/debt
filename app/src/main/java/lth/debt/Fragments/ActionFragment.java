package lth.debt.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lth.debt.R;

/**
 * Created by Carl on 2015-06-29.
 */
public class ActionFragment extends Fragment {

    public static ActionFragment newInstance(FirstPageFragmentListener listener) {
        ActionFragment fragment = new ActionFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.action_fragment, container, false);
    }



}
