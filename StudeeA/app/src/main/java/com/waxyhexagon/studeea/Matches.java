package com.waxyhexagon.studeea;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class Matches extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Intent intent;

    String[] matches;

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;

    TextView name1;
    TextView name2;
    TextView name3;
    TextView name4;
    TextView name5;
    TextView name6;

    private OnFragmentInteractionListener mListener;

    public static Matches newInstance() {
        Matches fragment = new Matches();
        return fragment;
    }

    public Matches() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Matches.
     */
    // TODO: Rename and change types and number of parameters
    public static Matches newInstance(String param1, String param2) {
        Matches fragment = new Matches();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_matches, container, false); //does this fix it

        name1 = (TextView)v.findViewById(R.id.matchNameLabel1);
        name2 = (TextView)v.findViewById(R.id.matchNameLabel2);
        name3 = (TextView)v.findViewById(R.id.matchNameLabel3);
        name4 = (TextView)v.findViewById(R.id.matchNameLabel4);
        name5 = (TextView)v.findViewById(R.id.matchNameLabel5);
        name6 = (TextView)v.findViewById(R.id.matchNameLabel6);
        imageButton1 = (ImageButton)v.findViewById(R.id.matchImageButton1);
        imageButton2 = (ImageButton)v.findViewById(R.id.matchImageButton2);
        imageButton3 = (ImageButton)v.findViewById(R.id.matchImageButton3);
        imageButton4 = (ImageButton)v.findViewById(R.id.matchImageButton4);
        imageButton5 = (ImageButton)v.findViewById(R.id.matchImageButton5);
        imageButton6 = (ImageButton)v.findViewById(R.id.matchImageButton6);
        imageButton1.setOnClickListener(imageOneListener);
        imageButton2.setOnClickListener(imageTwoListener);
        imageButton3.setOnClickListener(imageThreeListener);
        imageButton4.setOnClickListener(imageFourListener);
        imageButton5.setOnClickListener(imageFiveListener);
        imageButton6.setOnClickListener(imageSixListener);

        PopulateMatches populateMatches = new PopulateMatches();
        populateMatches.execute();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Matches");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    View.OnClickListener imageOneListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            intent = new Intent(getActivity(), ProfilePage.class);
            ArrayList<String> strs = new ArrayList<String>();
            strs.add(name1.getText().toString());
            intent.putStringArrayListExtra("NAME", strs);
            startActivity(intent);
        }
    };

    View.OnClickListener imageTwoListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            intent = new Intent(getActivity(), ProfilePage.class);
            ArrayList<String> strs = new ArrayList<String>();
            strs.add(name2.getText().toString());
            intent.putStringArrayListExtra("NAME", strs);
            startActivity(intent);
        }
    };

    View.OnClickListener imageThreeListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            intent = new Intent(getActivity(), ProfilePage.class);
            ArrayList<String> strs = new ArrayList<String>();
            strs.add(name3.getText().toString());
            intent.putStringArrayListExtra("NAME", strs);
            startActivity(intent);
        }
    };

    View.OnClickListener imageFourListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            intent = new Intent(getActivity(), ProfilePage.class);
            ArrayList<String> strs = new ArrayList<String>();
            strs.add(name4.getText().toString());
            intent.putStringArrayListExtra("NAME", strs);
            startActivity(intent);
        }
    };

    View.OnClickListener imageFiveListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            intent = new Intent(getActivity(), ProfilePage.class);
            ArrayList<String> strs = new ArrayList<String>();
            strs.add(name5.getText().toString());
            intent.putStringArrayListExtra("NAME", strs);
            startActivity(intent);
        }
    };

    View.OnClickListener imageSixListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            intent = new Intent(getActivity(), ProfilePage.class);
            ArrayList<String> strs = new ArrayList<String>();
            strs.add(name6.getText().toString());
            intent.putStringArrayListExtra("NAME", strs);
            startActivity(intent);
        }
    };

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class PopulateMatches extends AsyncTask<Void, Void, Boolean> {

        PopulateMatches(){}

        @Override
        protected Boolean doInBackground(Void... params) {

            matches = Comms.populateMatches();

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            Log.i("success", "success");
            name1.setText(matches[0]);
            name2.setText(matches[1]);
            name3.setText(matches[2]);
            name4.setText(matches[3]);
            name5.setText(matches[4]);
            name6.setText(matches[5]);
        }
    }


}
