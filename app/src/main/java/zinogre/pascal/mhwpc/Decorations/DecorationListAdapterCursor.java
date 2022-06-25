package zinogre.pascal.mhwpc.Decorations;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import zinogre.pascal.mhwpc.Shared.CursorRecyclerViewAdapter;
import zinogre.pascal.mhwpc.R;
import zinogre.pascal.mhwpc.Shared.RecyclerViewClickListener;

public class DecorationListAdapterCursor extends CursorRecyclerViewAdapter<DecorationListAdapterCursor.ViewHolder> {

    private final AssetManager assetManager;
    private final RecyclerViewClickListener mListener;

    public DecorationListAdapterCursor(Context context, Cursor cursor, RecyclerViewClickListener listener){
        super(context,cursor);
        assetManager = context.getAssets();
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final RecyclerViewClickListener mListener;
        final TextView mTextView;
        final ImageView mImageView;
        ViewHolder(View view, RecyclerViewClickListener listener) {
            super(view);
            mTextView = view.findViewById(R.id.tvDecorationName);
            mImageView = view.findViewById(R.id.ivDecorationIcon);
            mListener = listener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.decoration_list_row, parent, false);
        return new ViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        BackgroundTask b = new BackgroundTask();
        b.execute(cursor);

        try {
            String decorationName = b.get().getName();
            int decorationIconType = R.drawable.decoration_1_slot;
            if (decorationName.contains("2")){
                decorationIconType = R.drawable.decoration_2_slot;
            }
            else if (decorationName.contains("3")){
                decorationIconType = R.drawable.decoration_3_slot;
            }
            viewHolder.mImageView.setImageResource(decorationIconType);
            viewHolder.mTextView.setText(b.get().getName());
        }
        catch(Exception ex) {
            Log.e("DecorationAdapter",  "Error : " + ex);
        }
    }

    private static class BackgroundTask extends AsyncTask<Cursor, Integer, Decoration> {

        protected Decoration doInBackground(Cursor... c) {
            Cursor cursor = c[0];
            return Decoration.fromCursor(cursor);
        }

        protected void onProgressUpdate(Integer... progress) {}

        protected void onPostExecute(Decoration m) {}
    }
}
