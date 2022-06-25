package zinogre.pascal.mhwpc.DamageCalc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import zinogre.pascal.mhwpc.Shared.Globals;

import zinogre.pascal.mhwpc.R;

class RVListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final Context c;
    private final ArrayList<String> numbers;


    public RVListAdapter(Context c, ArrayList<String> numbers) {
        this.c = c;
        this.numbers = numbers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.damage_calc_rv_list_row, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ArrayList<Integer> spinnerArray =  new ArrayList<>();

        int i = 0;
        while (i <= Globals.MAX.get(position)){
            spinnerArray.add(i);
            ++i;
        }

        ArrayAdapter<Integer> sAdapter = new ArrayAdapter<>(
                c, android.R.layout.simple_spinner_item, spinnerArray);

        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //BIND DATA
        holder.nameTxt.setText(numbers.get(position));
        holder.spinnerNumber.setAdapter(sAdapter);
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }
}

    class MyViewHolder extends RecyclerView.ViewHolder {

        final TextView nameTxt;
        final Spinner spinnerNumber;
        private final TextInputLayout rawValue;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameTxt = itemView.findViewById(R.id.tvAdditionalSkill);
            spinnerNumber = itemView.findViewById(R.id.sNumber);
            rawValue = itemView.findViewById(R.id.raw_input);
        }
}

