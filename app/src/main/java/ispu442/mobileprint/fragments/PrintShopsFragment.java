package ispu442.mobileprint.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ispu442.mobileprint.adapters.PrintShopsRecyclerViewAdapter;
import ispu442.mobileprint.R;
import ispu442.mobileprint.contolers.PrintshopContoller;
import ispu442.mobileprint.models.Printshop;
import ispu442.mobileprint.utilities.AsyncAction;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnPrintShopItemClick}
 * interface.
 */
public class PrintShopsFragment extends Fragment {

    private OnPrintShopItemClick mListener;
    private RecyclerView recyclerView;

    public PrintShopsFragment() {
    }

    public static PrintShopsFragment newInstance() {
        PrintShopsFragment fragment = new PrintShopsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_printshops_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            AsyncAction act = new AsyncAction(new AsyncAction.Action() {
                @Override
                public void Execute() {
                    final List<Printshop> printshops = PrintshopContoller.GetPrintshops();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (printshops != null)
                            {
                                recyclerView.setAdapter(new PrintShopsRecyclerViewAdapter(printshops, mListener));
                            }
                            else
                            {
                                Toast.makeText(getContext(), "Неудалось получить список типографий",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            });
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPrintShopItemClick) {
            mListener = (OnPrintShopItemClick) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnPrintShopItemClick {
        void onPrintShopItemClick(Printshop item);
    }
}
