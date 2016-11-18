package ispu442.mobileprint.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import ispu442.mobileprint.R;
import ispu442.mobileprint.contolers.UserController;
import ispu442.mobileprint.utilities.AsyncAction;

public class SingInFragment extends Fragment {

    private OnSignUpButtonClick mListener;

    private Button SingUpButton;
    private Button EnterButton;
    private CheckBox Remember;
    private EditText Login;
    private EditText Passord;

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
        Login = (EditText) view.findViewById(R.id.SingInLogin);
        Passord = (EditText) view.findViewById(R.id.SingInPassword);
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
                AsyncAction act = new AsyncAction(new AsyncAction.Action() {
                    @Override
                    public void Execute()
                    {
                        UserController.SignIn(Login.getText().toString(), Passord.getText().toString());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String name = UserController.UserName();
                                if (name != null)
                                {
                                    Toast.makeText(getContext(), "Привет, " + name, Toast.LENGTH_LONG).show();
                                    getActivity().finish();
                                }
                                else
                                    Toast.makeText(getContext(), "Проблемы с авторизацией", Toast.LENGTH_LONG).show();
                            }
                        });

                    }

                });

            }
        });
    }

    @Override
    public void onStart()
    {
        super.onStart();
        GetViews();
        SubscribeViews();
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

