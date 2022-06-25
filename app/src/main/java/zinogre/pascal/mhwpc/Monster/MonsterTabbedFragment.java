package zinogre.pascal.mhwpc.Monster;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zinogre.pascal.mhwpc.Shared.BaseFragment;
import zinogre.pascal.mhwpc.R;
import zinogre.pascal.mhwpc.Shared.PagerAdapter;

public class MonsterTabbedFragment extends BaseFragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pager_tabs, container, false);
        ViewPager viewPager = rootView.findViewById(R.id.view_pager);
        TabLayout tabLayout = rootView.findViewById(R.id.tabs);
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());
        // Add Fragments to adapter one by one
        adapter.addFragment(new LargeMonsterListFragment(), "Large");
        adapter.addFragment(new SmallMonsterListFragment(), "Small");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

    @Override
    public String getName(){
        return "MonsterTab";
    }

    @Override
    public String getTitle(){
        return "Monsters";
    }
}


