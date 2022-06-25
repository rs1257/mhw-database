package zinogre.pascal.mhwpc.Shared;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import zinogre.pascal.mhwpc.Shared.RecyclerViewClickListener;

class RowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final RecyclerViewClickListener mListener;

    RowViewHolder(View v, RecyclerViewClickListener listener) {
        super(v);
        mListener = listener;
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(view, getAdapterPosition());
    }
}
