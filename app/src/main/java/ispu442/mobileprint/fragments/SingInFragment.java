package ispu442.mobileprint.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import ispu442.mobileprint.R;

public class SingInFragment extends Fragment {

    private OnSignUpButtonClick mListener;

    private Button SingUpButton;
    private Button EnterButton;
    private CheckBox Remember;


    public SingInFragment() {
        // Required empty public constructor
    }

    public static SingInFragment newInstance() {
        SingInFragment fragment = new SingInFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sing_in, container, false);
    }

    private void GetViews()
    {
        View view = getView();
        SingUpButton = (Button) view.findViewById(R.id.SingInSignUpButton);
        EnterButton = (Button) view.findViewById(R.id.SingInEnterButton);
        Remember = (CheckBox) view.findViewById(R.id.SingInRemember);
    }

    private void SubscribeViews()
    {
        SingUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mListener.onSignUpButtonClick();
            }
        });

        EnterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "Вход", Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSignUpButtonClick) {
            mListener = (OnSignUpButtonClick) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSignUpButtonClick");
        }
        GetViews();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        SingUpButton = null;
        EnterButton = null;
        Remember = null;
    }

    public interface OnSignUpButtonClick {
        void onSignUpButtonClick();
    }
}
