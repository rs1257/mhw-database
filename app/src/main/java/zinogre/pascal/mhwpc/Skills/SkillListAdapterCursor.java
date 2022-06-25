package zinogre.pascal.mhwpc.Skills;

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

import static zinogre.pascal.mhwpc.Utils.IconUtils.findIconFolder;

public class SkillListAdapterCursor extends CursorRecyclerViewAdapter<SkillListAdapterCursor.ViewHolder> {

    private final AssetManager assetManager;

    public SkillListAdapterCursor(Context context, Cursor cursor){
        super(context,cursor);
        assetManager = context.getAssets();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;
        final ImageView mImageView;
        ViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.tvSkillName);
            mImageView = view.findViewById(R.id.ivSkillIcon);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skill_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        BackgroundTask b = new BackgroundTask();
        b.execute(cursor);

        try {
            viewHolder.mTextView.setText(b.get().getName());
            viewHolder.mImageView.setImageResource(R.drawable.armor_skill);
        }
        catch(Exception ex) {
            Log.e("SkillAdapter", "Error : " + ex);
        }
    }

    private static class BackgroundTask extends AsyncTask<Cursor, Integer, Skill> {

        protected Skill doInBackground(Cursor... c) {
            Cursor cursor = c[0];
            return Skill.fromCursor(cursor);
        }

        protected void onProgressUpdate(Integer... progress) {}

        protected void onPostExecute(Skill m) {}
    }
}
