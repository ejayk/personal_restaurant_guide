package ca.gbc.comp3074.personalrestaurantguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    private static final String TAG = RestaurantsActivity.class.getSimpleName();

    private SqliteDatabase mDatabase;
    private ArrayList<Entries> allEntries;
    private EntryAdapter mAdapter;
    private TextView restaurantsTitle;
    private Button addBtn;
    private SearchView simpleSearchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LinearLayoutManager fLayout = (LinearLayoutManager) findViewById(R.id.frame_layout);
        RecyclerView entryView = (RecyclerView) findViewById(R.id.entryView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        entryView.setLayoutManager(linearLayoutManager);
        entryView.setHasFixedSize(true);
        restaurantsTitle = (TextView) findViewById(R.id.restaurantsTitle);
        allEntries = new ArrayList<>();
        mDatabase = new SqliteDatabase(this);
        allEntries = mDatabase.listEntries();
        addBtn = (Button) findViewById(R.id.main_add_btn);
        simpleSearchView=(SearchView)findViewById(R.id.simpleSearchView);

        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


        if (allEntries.size() > 0) {
            entryView.setVisibility(View.VISIBLE);
            mAdapter = new EntryAdapter(this, allEntries);
            entryView.setAdapter(mAdapter);

        } else {
            entryView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addRestaurant:
                Intent intent = new Intent(this, AddRestaurantActivity.class);
                this.startActivity(intent);
                break;
        }
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                this.startActivity(intent);
                break;
        }
        switch (item.getItemId()) {
            case R.id.restaurants:
                Intent intent = new Intent(this, RestaurantsActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, AddRestaurantActivity.class);
        this.startActivity(intent);
    }

    /*public void openEditRestaurantActivity(){
        Intent intent=new Intent(this,EditRestaurantActivity.class);
        startActivity(intent);
    }*/


}
