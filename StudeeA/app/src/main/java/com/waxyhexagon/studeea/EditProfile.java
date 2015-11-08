package com.waxyhexagon.studeea;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


public class EditProfile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String dataReceived[];

    Spinner schoolSpinner;
    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText email;
    CheckBox taken1;
    CheckBox taken2;
    CheckBox taken3;
    CheckBox taken4;
    CheckBox taken5;
    CheckBox tutor1;
    CheckBox tutor2;
    CheckBox tutor3;
    CheckBox tutor4;
    CheckBox tutor5;
    Button updateButton;

    private OnFragmentInteractionListener mListener;

    public static EditProfile newInstance() {
        EditProfile fragment = new EditProfile();
        return fragment;
    }

    public EditProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfile newInstance(String param1, String param2) {
        EditProfile fragment = new EditProfile();
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

        View v = inflater.inflate(R.layout.fragment_edit_profile, container, false);


        firstName = (EditText)v.findViewById(R.id.firstNameField);
        lastName = (EditText)v.findViewById(R.id.lastNameField);
        phoneNumber = (EditText)v.findViewById(R.id.phoneField);
        email = (EditText)v.findViewById(R.id.emailField);
        taken1 = (CheckBox)v.findViewById(R.id.takenC121);
        taken1 = (CheckBox)v.findViewById(R.id.takenC122);
        taken1 = (CheckBox)v.findViewById(R.id.takenC221);
        taken1 = (CheckBox)v.findViewById(R.id.takenM140);
        taken1 = (CheckBox)v.findViewById(R.id.takenM141);
        tutor1 = (CheckBox)v.findViewById(R.id.tutorC121);
        tutor2 = (CheckBox)v.findViewById(R.id.tutorC122);
        tutor3 = (CheckBox)v.findViewById(R.id.tutorC221);
        tutor4 = (CheckBox)v.findViewById(R.id.tutorM140);
        tutor5 = (CheckBox)v.findViewById(R.id.tutorM141);

        updateButton = (Button)v.findViewById(R.id.updateButton);
        updateButton.setOnClickListener(updateButtonListener);

        FillForm populateMatches = new FillForm();
        populateMatches.execute();

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        schoolSpinner = (Spinner) getView().findViewById(R.id.schoolSpinner);
        ArrayAdapter<CharSequence> schoolAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.schoolList, android.R.layout.simple_spinner_item);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (schoolAdapter == null){
            Log.i("a", "schoolAdapter is null");
        } else if (schoolSpinner == null){
            Log.i("b", "schoolSpinner is null");
        } else {
            Log.i("c", "no null");
        }

        schoolSpinner.setAdapter(schoolAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Edit Profile");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    View.OnClickListener updateButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            UpdateProfile profileUpdater = new UpdateProfile();
            profileUpdater.execute();
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class FillForm extends AsyncTask<Void, Void, Boolean> {

        FillForm(){}

        @Override
        protected Boolean doInBackground(Void... params) {

            dataReceived = Comms.viewProfile("Olivia");


            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            Log.i("success", "success");
            firstName.setText(dataReceived[0]);
            phoneNumber.setText(dataReceived[1]);
            email.setText(dataReceived[2]);
        }
    }

    public class UpdateProfile extends AsyncTask<Void, Void, Boolean> {

        UpdateProfile(){}

        @Override
        protected Boolean doInBackground(Void... params) {

            Comms.updateProfile(firstName,lastName,phoneNumber,email);

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            Log.i("success", "database updated (I hope)");
        }
    }
}
