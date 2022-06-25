package zinogre.pascal.mhwpc.Weapon;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import zinogre.pascal.mhwpc.Shared.BaseFragment;
import zinogre.pascal.mhwpc.Database.DatabaseHelper;
import zinogre.pascal.mhwpc.R;

public class WeaponListFragment extends BaseFragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    String tag = "Weapon";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.weapon_list_fragment, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        //getActivity().setContentView(R.layout.activity_main);
        // data to populate the RecyclerView with
        WeaponListAdapterCursor adapter;

        // set up the RecyclerView
        RecyclerView recyclerView = Objects.requireNonNull(getActivity()).findViewById(R.id.rvWeapons);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //adapter = new WeaponListAdapter(getContext(), weaponNames);

        Cursor c = DatabaseHelper.getDatabase(getContext()).rawQuery("SELECT * FROM weapon_type", null);
        adapter = new WeaponListAdapterCursor(getContext(), c);
        //adapter.setClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()),
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public String getName(){
        return "WeaponList";
    }

    @Override
    public String getTitle(){
        return "Weapons";
    }
}
