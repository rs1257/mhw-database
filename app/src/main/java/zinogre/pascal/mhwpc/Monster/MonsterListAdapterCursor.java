package zinogre.pascal.mhwpc.Monster;

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

import zinogre.pascal.mhwpc.Shared.CursorRecyclerViewAdapter;
import zinogre.pascal.mhwpc.R;
import zinogre.pascal.mhwpc.Shared.RecyclerViewClickListener;

import static zinogre.pascal.mhwpc.Utils.IconUtils.findIconFolder;

public class MonsterListAdapterCursor extends CursorRecyclerViewAdapter<MonsterListAdapterCursor.ViewHolder> {

    private final AssetManager assetManager;
    private final RecyclerViewClickListener mListener;

    public MonsterListAdapterCursor(Context context, Cursor cursor,  RecyclerViewClickListener listener){
        super(context,cursor);
        assetManager = context.getAssets();
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final RecyclerViewClickListener mListener;
        final TextView mTextView;
        final TextView mSpecies;
        final ImageView mImageView;

        ViewHolder(View view, RecyclerViewClickListener listener) {
            super(view);
            mTextView = view.findViewById(R.id.tvMonsterName);
            mSpecies = view.findViewById(R.id.tvMonsterType);
            mImageView = view.findViewById(R.id.ivMonsterIcon);
            mListener = listener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.monsters_list_row, parent, false);
        return new ViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        BackgroundTask b = new BackgroundTask();
        b.execute(cursor);

        String iconName = "";
        try {
            viewHolder.mTextView.setText(b.get().getName());
            viewHolder.mSpecies.setText(b.get().getSpecies());
            iconName = Integer.toString(b.get().getUid()) + ".png";
            // get input stream
            InputStream ims = assetManager.open(findIconFolder("monsters", iconName));
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            viewHolder.mImageView.setImageDrawable(d);
        }
        catch(Exception ex) {
            Log.e("MonsterAdapter", findIconFolder("monster", iconName) + " not found");
        }
    }

    private static class BackgroundTask extends AsyncTask<Cursor, Integer, Monster> {

        protected Monster doInBackground(Cursor... c) {
            Cursor cursor = c[0];
            return Monster.fromCursor(cursor);
        }

        protected void onProgressUpdate(Integer... progress) {}

        protected void onPostExecute(Monster m) {}
    }
}