package zinogre.pascal.mhwpc;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Objects;

import zinogre.pascal.mhwpc.Achievements.AchievementListFragment;
import zinogre.pascal.mhwpc.Armor.ArmorTabbedFragment;
import zinogre.pascal.mhwpc.Charms.CharmListFragment;
import zinogre.pascal.mhwpc.Combinations.CombinationListFragment;
import zinogre.pascal.mhwpc.DamageCalc.DamageCalcFragment;
import zinogre.pascal.mhwpc.Decorations.DecorationListFragment;
import zinogre.pascal.mhwpc.Food.FoodTabbedFragment;
import zinogre.pascal.mhwpc.Items.ItemListFragment;
import zinogre.pascal.mhwpc.Life.LifeListFragment;
import zinogre.pascal.mhwpc.Locations.LocationListFragment;
import zinogre.pascal.mhwpc.Monster.MonsterTabbedFragment;
import zinogre.pascal.mhwpc.Palico.PalicoTabbedFragment;
import zinogre.pascal.mhwpc.Quests.QuestTabbedFragment;
import zinogre.pascal.mhwpc.Shared.BaseFragment;
import zinogre.pascal.mhwpc.Shared.Globals;
import zinogre.pascal.mhwpc.Skills.SkillListFragment;
import zinogre.pascal.mhwpc.Tools.ToolListFragment;
import zinogre.pascal.mhwpc.Utils.FragmentUtils;
import zinogre.pascal.mhwpc.Weapon.WeaponListFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String tag = "Main";
    private String currentTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        BaseFragment content = new MonsterTabbedFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(Globals.FragmentContainer, content, content.getTitle());
        transaction.commit();
        Log.e(tag, Integer.toString(getSupportFragmentManager().getBackStackEntryCount() - 1));
        //replaceFragment(frag_container, content);
        currentTitle = content.getTitle();
        setActionBarTitle(currentTitle);
    }

    private void replaceFragment(int container, BaseFragment f){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.addToBackStack(currentTitle);
        transaction.replace(container, f, f.getTitle());

        Log.d(tag, f.getName());
        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            int index = getSupportFragmentManager().getBackStackEntryCount() - 1;
            if (index >= 0) {
                String tag = getSupportFragmentManager().getBackStackEntryAt(index).getName();
                Objects.requireNonNull(getSupportActionBar()).setTitle(tag);
            }

            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        BaseFragment f;
        switch (id) {
            case R.id.monsters:
                f = new MonsterTabbedFragment();
                break;
            case R.id.armor:
                f = new ArmorTabbedFragment();
                break;
            case R.id.weapons:
                f = new WeaponListFragment();
                break;
            case R.id.quests:
                f = new QuestTabbedFragment();
                break;
            case R.id.items:
                f = new ItemListFragment();
                break;
            case R.id.palicos:
                f = new PalicoTabbedFragment();
                break;
            case R.id.combinations:
                f = new CombinationListFragment();
                break;
            case R.id.locations:
                f = new LocationListFragment();
                break;
            case R.id.decorations:
                f = new DecorationListFragment();
                break;
            case R.id.charms:
                f = new CharmListFragment();
                break;
            case R.id.skills:
                f = new SkillListFragment();
                break;
            case R.id.tools:
                f = new ToolListFragment();
                break;
            case R.id.endemic_life:
                f = new LifeListFragment();
                break;
            case R.id.food:
                f = new FoodTabbedFragment();
                break;
            case R.id.achievements:
                f = new AchievementListFragment();
                break;
            case R.id.damage_calc:
                f = new DamageCalcFragment();
                break;
            case R.id.decoration_checklist:
                f = new MissingFragment();
                break;
            case R.id.set_builder:
                f = new MissingFragment();
                break;
            case R.id.about:
                f = new MissingFragment();
                break;
            default:
                f = new MissingFragment();
                break;
        }

        currentTitle = f.getTitle();
        setActionBarTitle(currentTitle);

        //replaceFragment(frag_container, f);
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        FragmentUtils.replaceFragment(Globals.FragmentContainer, f, currentTitle, t);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
