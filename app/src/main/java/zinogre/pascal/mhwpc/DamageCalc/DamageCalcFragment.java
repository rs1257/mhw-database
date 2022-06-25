package zinogre.pascal.mhwpc.DamageCalc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Objects;

import zinogre.pascal.mhwpc.R;
import zinogre.pascal.mhwpc.Shared.BaseFragment;
import zinogre.pascal.mhwpc.Shared.Globals;

public class DamageCalcFragment extends BaseFragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment


        return inflater.inflate(R.layout.damage_calc, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        ArrayAdapter<String> wAdapter = new ArrayAdapter<>(
                Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, Globals.WEAPONS);

        wAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner wItems = Objects.requireNonNull(getActivity()).findViewById(R.id.weapon_spinner);
        wItems.setAdapter(wAdapter);


        ArrayAdapter<String> sAdapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_spinner_item, Globals.SHARPNESS);

        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = getActivity().findViewById(R.id.sharpness_spinner);
        sItems.setAdapter(sAdapter);

        RecyclerView recyclerView = getActivity().findViewById(R.id.rvAdditionalSkills);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        RVListAdapter rvAdapter = new RVListAdapter(getContext(), Globals.ATTACKSKILLS);
        //rvAdapter.setClickListener(getContext());
        recyclerView.setAdapter(rvAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

    }

    @Override
    public String getName(){
        return "DamageCalc";
    }

    @Override
    public String getTitle(){
        return "Damage Calculator";
    }
}