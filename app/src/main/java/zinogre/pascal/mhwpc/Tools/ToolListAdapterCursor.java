package zinogre.pascal.mhwpc.Tools;

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

import static zinogre.pascal.mhwpc.Utils.IconUtils.findIconFolder;

public class ToolListAdapterCursor extends CursorRecyclerViewAdapter<ToolListAdapterCursor.ViewHolder> {

    private final AssetManager assetManager;

    public ToolListAdapterCursor(Context context, Cursor cursor){
        super(context,cursor);
        assetManager = context.getAssets();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;
        final ImageView mImageView;
        ViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.tvToolName);
            mImageView = view.findViewById(R.id.ivToolIcon);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tools_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        BackgroundTask b = new BackgroundTask();
        b.execute(cursor);

        String iconName = "";
        try {
            String mantleName = b.get().getName();
            viewHolder.mTextView.setText(mantleName);
            if (mantleName.contains("Mantle")) {
                // set image to ImageView
                viewHolder.mImageView.setImageResource(R.drawable.mantle_icon);
            }
            else {
               viewHolder.mImageView.setImageResource(R.drawable.garbage_icon);
            }

        }
        catch(Exception ex) {
            Log.e("ToolAdapter", findIconFolder("Tool", iconName) + " not found");
        }
    }

    private static class BackgroundTask extends AsyncTask<Cursor, Integer, Tool> {

        protected Tool doInBackground(Cursor... c) {
            Cursor cursor = c[0];
            return Tool.fromCursor(cursor);
        }

        protected void onProgressUpdate(Integer... progress) {}

        protected void onPostExecute(Tool m) {}
    }
}
