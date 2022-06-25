package zinogre.pascal.mhwpc.Combinations;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

import zinogre.pascal.mhwpc.R;
import zinogre.pascal.mhwpc.Shared.CursorRecyclerViewAdapter;

import static zinogre.pascal.mhwpc.Utils.IconUtils.findIconFolder;

public class CombinationListAdapterCursor extends CursorRecyclerViewAdapter<CombinationListAdapterCursor.ViewHolder> {

    private final AssetManager assetManager;

    public CombinationListAdapterCursor(Context context, Cursor cursor){
        super(context,cursor);
        assetManager = context.getAssets();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;
        final ImageView mImageView;
        final TextView mItem1;
        final TextView mItem2;
        final ImageView mItem1icon;
        final ImageView mItem2icon;
        ViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.tvCombinationName);
            mImageView = view.findViewById(R.id.ivCombinationIcon);

            mItem1 = view.findViewById(R.id.tvItem1);
            mItem1icon = view.findViewById(R.id.ivItem1);

            mItem2 = view.findViewById(R.id.tvItem2);
            mItem2icon = view.findViewById(R.id.ivItem2);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.combination_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        BackgroundTask b = new BackgroundTask();
        b.execute(cursor);

        String iconName = "";
        try {
            viewHolder.mTextView.setText(b.get().getName());
            viewHolder.mItem1.setText(b.get().getItem1());
            viewHolder.mItem2.setText(b.get().getItem2());
            iconName = Integer.toString(b.get().getUid()) + ".png";
            // get input stream
            InputStream ims = assetManager.open(findIconFolder("combination", iconName));
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            viewHolder.mImageView.setImageDrawable(d);
            viewHolder.mItem1icon.setImageDrawable(d);
            Log.e("a", b.get().getItem2());
            if (b.get().getItem2().isEmpty()){
                viewHolder.mItem2icon.setVisibility(View.INVISIBLE);
            }
            else {
                viewHolder.mItem2icon.setVisibility(View.VISIBLE);
                viewHolder.mItem2icon.setImageDrawable(d);
            }
        }
        catch(Exception ex) {
            Log.e("CombinationAdapter", findIconFolder("combination", iconName) + " not found");
        }
    }

    private static class BackgroundTask extends AsyncTask<Cursor, Integer, Combination> {

        protected Combination doInBackground(Cursor... c) {
            Cursor cursor = c[0];
            return Combination.fromCursor(cursor);
        }

        protected void onProgressUpdate(Integer... progress) {}

        protected void onPostExecute(Combination m) {}
    }
}
