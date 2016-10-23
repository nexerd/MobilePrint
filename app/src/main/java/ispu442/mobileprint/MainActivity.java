package ispu442.mobileprint;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import ispu442.mobileprint.fragments.OrdersFragment;
import ispu442.mobileprint.fragments.PrintShopsFragment;
import ispu442.mobileprint.models.Order;
import ispu442.mobileprint.models.Printshop;

public class MainActivity extends AppCompatActivity
        implements ListView.OnItemClickListener,
        PrintShopsFragment.OnListFragmentInteractionListener,
        OrdersFragment.OnListFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView l = (ListView)findViewById(R.id.MainPanelList);
        String[] menu = {"Заказы", "Серсисы", "Выход"};
        l.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        l.setOnItemClickListener(this);

        Fragment fragment = new PrintShopsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_comtainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Printshop item)
    {
        Toast.makeText(this, item.Name + " is clicked", Toast.LENGTH_LONG);
    }

    @Override
    public void onListFragmentInteraction(Order item)
    {
        Toast.makeText(this, item.Hash + " is clicked", Toast.LENGTH_LONG);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new OrdersFragment();
                break;
            case 1:
                fragment = new PrintShopsFragment();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_comtainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
