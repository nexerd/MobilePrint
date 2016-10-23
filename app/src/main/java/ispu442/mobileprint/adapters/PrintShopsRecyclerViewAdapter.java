package ispu442.mobileprint.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ispu442.mobileprint.R;
import ispu442.mobileprint.fragments.PrintShopsFragment.OnListFragmentInteractionListener;
import ispu442.mobileprint.models.Printshop;

import java.util.List;

public class PrintShopsRecyclerViewAdapter extends RecyclerView.Adapter<PrintShopsRecyclerViewAdapter.ViewHolder> {

    private final List<Printshop> mValues;
    private final OnListFragmentInteractionListener mListener;

    public PrintShopsRecyclerViewAdapter(List<Printshop> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_printshops, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).Name);
        holder.mAddresstView.setText(mValues.get(position).Address);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
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
        public final TextView mNameView;
        public final TextView mAddresstView;
        public Printshop mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.PrintshopName);
            mAddresstView = (TextView) view.findViewById(R.id.PrintshopAddress);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
