package zinogre.pascal.mhwpc.Achievements;

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

public class AchievementListAdapterCursor extends CursorRecyclerViewAdapter<AchievementListAdapterCursor.ViewHolder> {

    private final AssetManager assetManager;

    public AchievementListAdapterCursor(Context context, Cursor cursor){
        super(context,cursor);
        assetManager = context.getAssets();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;
        final ImageView mImageView;
        final TextView mDescription;
        ViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.tvAchievementName);
            mImageView = view.findViewById(R.id.ivAchievementIcon);
            mDescription = view.findViewById(R.id.tvAchievementDes);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.achievement_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        BackgroundTask b = new BackgroundTask();
        b.execute(cursor);

        String iconName = "";
        try {
            viewHolder.mTextView.setText(b.get().getName());
            viewHolder.mDescription.setText(b.get().getDescription());
            iconName = Integer.toString(b.get().getUid()) + ".png";
            // get input stream
            InputStream ims = assetManager.open(findIconFolder("achievement", iconName));
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            viewHolder.mImageView.setImageDrawable(d);
        }
        catch(Exception ex) {
            Log.e("AchievementAdapter", findIconFolder("achievement", iconName) + " not found");
        }
    }

    private static class BackgroundTask extends AsyncTask<Cursor, Integer, Achievement> {

        protected Achievement doInBackground(Cursor... c) {
            Cursor cursor = c[0];
            return Achievement.fromCursor(cursor);
        }

        protected void onProgressUpdate(Integer... progress) {}

        protected void onPostExecute(Achievement m) {}
    }
}
