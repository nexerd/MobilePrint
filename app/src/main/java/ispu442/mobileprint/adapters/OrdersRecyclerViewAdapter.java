package ispu442.mobileprint.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ispu442.mobileprint.R;
import ispu442.mobileprint.fragments.OrdersFragment.OnOrderItemClick;
import ispu442.mobileprint.models.Order;


import java.util.List;

public class OrdersRecyclerViewAdapter extends RecyclerView.Adapter<OrdersRecyclerViewAdapter.ViewHolder> {

    private final List<Order> mValues;
    private final OnOrderItemClick mListener;

    public OrdersRecyclerViewAdapter(List<Order> items, OnOrderItemClick listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mOrderHashView.setText(mValues.get(position).Hash);
        holder.mOrderStatustView.setText(mValues.get(position).Status);
        holder.mOrderPriceView.setText(String.valueOf(mValues.get(position).Price));
        holder.mOrderNameView.setText(mValues.get(position).FileName);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onOrderItemClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mOrderHashView;
        public final TextView mOrderStatustView;
        public final TextView mOrderPriceView;
        public final TextView mOrderNameView;
        public Order mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mOrderNameView = (TextView) view.findViewById(R.id.OrderName);
            mOrderHashView = (TextView) view.findViewById(R.id.OrderHash);
            mOrderStatustView = (TextView) view.findViewById(R.id.OrderStatus);
            mOrderPriceView = (TextView) view.findViewById(R.id.OrderPrice);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mOrderHashView.getText() + "'";
        }
    }
}
