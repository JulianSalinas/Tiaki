package tiaki.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import model.Permission;
import model.Session;

public class ActivityMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private Session sess;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbarConfiguration();
        setDrawerConfiguration();
        setToggleConfiguration();
        setNavigationViewConfiguration();
        setFragment(new FragmentWelcome());
    }

    private void setToolbarConfiguration(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setDrawerConfiguration(){
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void setToggleConfiguration(){
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        toggle.syncState();
    }

    private void setNavigationViewConfiguration(){
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setUserOptions(navigationView.getMenu());
    }

    private void setUserOptions(Menu menu){
        sess = Session.getInstance();
        menu.findItem(R.id.nav_customers).setVisible(sess.hasPermission(Permission.LOOK_CUSTOMERS));
        menu.findItem(R.id.nav_visitors).setVisible(sess.hasPermission(Permission.LOOK_VISITORS));
        menu.findItem(R.id.nav_registry).setVisible(sess.hasPermission(Permission.LOOK_REGISTRY));
        menu.findItem(R.id.nav_guards).setVisible(sess.hasPermission(Permission.LOOK_GUARDS));
        menu.findItem(R.id.nav_residents).setVisible(sess.hasPermission(Permission.LOOK_RESIDENTS));
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        TextView username = (TextView) findViewById(R.id.username_in_menu);
        TextView userId = (TextView) findViewById(R.id.user_id_in_menu);
        username.setText(Session.getInstance().getUsername());
        userId.setText(String.valueOf(Session.getInstance().getId()));
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        navigateToItem(item);
        setTitle("TIAKI > " + item.getTitle());
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void navigateToItem(MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_customers: setFragment(new FragmentCustomer()); break;
            case R.id.nav_residents: break;
            case R.id.nav_guards: break;
            case R.id.nav_registry: break;
            default: setFragment(new FragmentWelcome()); break;
        }
    }

}
