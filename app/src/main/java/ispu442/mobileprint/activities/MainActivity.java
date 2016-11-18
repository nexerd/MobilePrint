package ispu442.mobileprint.activities;

import android.content.Intent;
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
import ispu442.mobileprint.contolers.UserController;
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
    private ListView leftBarList;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetViews();
        SetLeftBarList();
        SubscribeViews();
    }

    @Override
    public void onStart()
    {
        super.onStart();
        if (!UserController.IsSignedIn()) {
            Intent intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
        }
        else
        {
            RunFragment(new OrdersFragment(), menu[0]);
        }
    }

    private void GetViews()
    {
        leftBarList = (ListView) findViewById(R.id.MainPanelList);
        drawerLayout = (DrawerLayout)findViewById(R.id.MainPanel);
    }

    private void SetLeftBarList()
    {
        leftBarList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
    }

    private void SubscribeViews()
    {
        leftBarList.setOnItemClickListener(this);
    }

    private void RunFragment(Fragment fragment, String nameFragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_comtainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        getSupportActionBar().setTitle(nameFragment);
    }

    @Override
    public void onPrintShopItemClick(Printshop item)
    {
        Toast.makeText(this, item.Name + " is clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onOrderItemClick(Order item)
    {
        Toast.makeText(this, item.Hash + " is clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        switch (position)
        {
            case 0:
                RunFragment(new OrdersFragment(), menu[0]);
                break;
            case 1:
                RunFragment(new PrintShopsFragment(), menu[1]);
                break;
            case 2:
                finish();
                break;
        }
        drawerLayout.closeDrawer(leftBarList);
    }
}
