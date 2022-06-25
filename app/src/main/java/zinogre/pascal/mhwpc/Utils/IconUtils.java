package zinogre.pascal.mhwpc.Utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class IconUtils {

    public static Drawable convertAsset(Context context, String icon){
        Drawable draw = null;
        try {
            InputStream ims = context.getAssets().open(icon);
            // load image as Drawable
            draw = Drawable.createFromStream(ims, null);
            ims.close();
        }
        catch (IOException e){
            Log.w("error", e.toString());
        }
        return draw;
    }

    public static Bitmap getBitmapFromAssets(Context context, String fileName){
        AssetManager assetManager = context.getAssets();
        InputStream is;
        Bitmap bitmap = null;
        try {
            is = assetManager.open(fileName);
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch (IOException e){
            Log.w("error", e.toString());
            try {
                is = assetManager.open("garbage.png");
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
            }
            catch (IOException ex){
                Log.w("error", ex.toString());
            }
        }

        return bitmap;
    }

    private static boolean listAssetFiles(Context context, String path) {

        String [] list;
        try {
            list = context.getAssets().list(path);
            if (list.length > 0) {
                // This is a folder
                for (String file : list) {
                    if (!listAssetFiles(context, path + "/" + file))
                        return false;
                    else {
                        Log.d("a", file);
                    }
                }
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }
    public static String findIconFolder(String type, String icon){
        switch (type) {
            case "weapon":
                return "weapon_icons/" + icon;
            case "monsters":
                return "monster_icons/" + icon;
            case "location":
                return "location_icons/" + icon;
            case "achievement":
                return "achievement_icons/" + icon;
            default:
                return "garbage.png";
        }
    }
}

