package net.zarski.pg.passwordgenerator.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.zarski.pg.passwordgenerator.R;


public class Generate extends Fragment {
    private OnFragmentInteractionListener mListener;

    public static Generate newInstance(String param1, String param2) {
        Generate fragment = new Generate();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_generate, container, false);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onGeneratePressed() {
        if (mListener != null) {
            mListener.onGeneratePressed();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onGeneratePressed();
    }
}
