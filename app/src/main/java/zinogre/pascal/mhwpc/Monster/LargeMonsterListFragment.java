package zinogre.pascal.mhwpc.Monster;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import zinogre.pascal.mhwpc.MainActivity;
import zinogre.pascal.mhwpc.Shared.BaseFragment;
import zinogre.pascal.mhwpc.Database.DatabaseHelper;
import zinogre.pascal.mhwpc.R;
import zinogre.pascal.mhwpc.Shared.RecyclerViewClickListener;
import zinogre.pascal.mhwpc.Utils.FragmentUtils;

public class LargeMonsterListFragment extends BaseFragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.monster_large_list_fragment, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        MonsterListAdapterCursor adapter;

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.d("MonsterFrag", "Position: " + position);
                TextView tv = view.findViewById(R.id.tvMonsterName);
                FragmentTransaction t = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentUtils.replaceFragment(R.id.fragment_container, new LargeMonsterDetailsFragment(), getTitle(), t);
                ((MainActivity)getActivity()).setActionBarTitle(tv.getText().toString());
            }
        };

        // set up the RecyclerView
        RecyclerView recyclerView = Objects.requireNonNull(getActivity()).findViewById(R.id.rvMonstersLarge);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Cursor c = DatabaseHelper.getDatabase(getContext()).rawQuery("SELECT * FROM monsters_list WHERE size = 1", null);
        adapter = new MonsterListAdapterCursor(getContext(), c, listener);
        //adapter.setClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()),
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public String getName(){
        return "MonsterList";
    }

    @Override
    public String getTitle(){
        return "Monsters";
    }
}
