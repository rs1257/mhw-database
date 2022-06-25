package zinogre.pascal.mhwpc.Utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.Objects;

import zinogre.pascal.mhwpc.Shared.BaseFragment;

public class FragmentUtils {

    private static final String tag = "FragUtils";

    public static void replaceFragment(int container, BaseFragment f, String currentTitle, FragmentTransaction t){
        t.addToBackStack(currentTitle);
        t.replace(container, f, f.getTitle());

        Log.d(tag, f.getName());
        // Commit the transaction
        t.commit();
    }

}
