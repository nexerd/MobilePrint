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

import ispu442.mobileprint.R;
import ispu442.mobileprint.adapters.OrdersRecyclerViewAdapter;
import ispu442.mobileprint.contolers.OrderController;
import ispu442.mobileprint.models.Order;
import ispu442.mobileprint.utilities.AsyncAction;

public class OrdersFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnOrderItemClick mListener;

    RecyclerView recyclerView;

    public OrdersFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static OrdersFragment newInstance(int columnCount) {
        OrdersFragment fragment = new OrdersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            AsyncAction act = new AsyncAction(new AsyncAction.Action(){
                @Override
                public void Execute()
                {
                    final List<Order> orders = OrderController.GetOrders();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (orders != null)
                                recyclerView.setAdapter(new OrdersRecyclerViewAdapter(orders, mListener));
                            else
                                Toast.makeText(getContext(), "Не удалось получить список заказов.",
                                        Toast.LENGTH_LONG).show();
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
        if (context instanceof OnOrderItemClick) {
            mListener = (OnOrderItemClick) context;
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

    public interface OnOrderItemClick {
        void onOrderItemClick(Order item);
    }
}
