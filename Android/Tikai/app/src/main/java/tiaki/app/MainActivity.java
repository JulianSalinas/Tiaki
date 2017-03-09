package tiaki.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import model.Session;
import model.User;
import model.Permission;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Session session;
    private User user;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = Session.getInstance();
        user = session.getUser();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setUserOptions(navigationView.getMenu());
        setFragment(new WelcomeFragment());
    }

    private void setUserOptions(Menu menu){
        menu.findItem(R.id.nav_customers).setVisible(user.hasPermission(Permission.LOOK_CUSTOMERS));
        menu.findItem(R.id.nav_visitors).setVisible(user.hasPermission(Permission.LOOK_VISITORS));
        menu.findItem(R.id.nav_registry).setVisible(user.hasPermission(Permission.LOOK_REGISTRY));
        menu.findItem(R.id.nav_guards).setVisible(user.hasPermission(Permission.LOOK_GUARDS));
        menu.findItem(R.id.nav_residents).setVisible(user.hasPermission(Permission.LOOK_RESIDENTS));
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        TextView username = (TextView) findViewById(R.id.username_in_menu);
        TextView id_username = (TextView) findViewById(R.id.username_id_in_menu);
        username.setText(user.getUsername());
        id_username.setText("ID " + String.valueOf(user.getId()));
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    @Override //Temporal
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_customers: setFragment(new ListCustomerFragment()); break;
            case R.id.nav_residents: break;
            case R.id.nav_guards: break;
            case R.id.nav_registry: break;
            default: setFragment(new WelcomeFragment()); break;
        }   return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        navigateToItem(item);
        setTitle("TIAKI > "+ item.getTitle());
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void navigateToItem(MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_customers: setFragment(new ListCustomerFragment()); break;
            case R.id.nav_residents: break;
            case R.id.nav_guards: break;
            case R.id.nav_registry: break;
            default: setFragment(new WelcomeFragment()); break;
        }
    }

}
