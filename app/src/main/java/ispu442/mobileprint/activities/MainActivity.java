package ispu442.mobileprint.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import ispu442.mobileprint.R;
import ispu442.mobileprint.fragments.OrdersFragment;
import ispu442.mobileprint.fragments.PrintShopsFragment;
import ispu442.mobileprint.models.Order;
import ispu442.mobileprint.models.Printshop;

public class MainActivity extends AppCompatActivity
        implements ListView.OnItemClickListener,
        PrintShopsFragment.OnPrintShopItemClick,
        OrdersFragment.OnOrderItemClick
{

    final String[] menu = {"Заказы", "Серсисы", "Выход"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView l = (ListView)findViewById(R.id.MainPanelList);

        l.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        l.setOnItemClickListener(this);

        Fragment fragment = new PrintShopsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_comtainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        getSupportActionBar().setTitle(menu[0]);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.MainPanel);
    }

    @Override
    public void onPrintShopItemClick(Printshop item)
    {
        Toast toast = Toast.makeText(this, item.Name + " is clicked", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onOrderItemClick(Order item)
    {
        Toast toast =Toast.makeText(this, item.Hash + " is clicked", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new OrdersFragment();
                getSupportActionBar().setTitle(menu[0]);
                break;
            case 1:
                fragment = new PrintShopsFragment();
                getSupportActionBar().setTitle(menu[1]);
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_comtainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.MainPanel);
        ListView l = (ListView)findViewById(R.id.MainPanelList);
        drawerLayout.closeDrawer(l);
    }
}
