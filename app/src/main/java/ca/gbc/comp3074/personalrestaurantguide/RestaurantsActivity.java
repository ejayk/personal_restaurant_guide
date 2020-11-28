package ca.gbc.comp3074.personalrestaurantguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Logger;

public class RestaurantsActivity extends AppCompatActivity {

    private static final String TAG = RestaurantsActivity.class.getSimpleName();

    private SqliteDatabase mDatabase;
    private ArrayList<Entries>allEntries;
    private EntryAdapter mAdapter;
    private TextView restaurantsTitle;
    //private ListView restaurantsListView;
   // private TextView getRestaurantName;
    //private EditText editTxtId;
   // private SQLiteDatabase db;
    // private EntryAdapter entryAdapter;
    RecyclerView entryView;
    //EntryAdapter adapter;
    //ArrayList<Entry> entries = new ArrayList<>();
    //private Button deleteBtn;
    //private SearchView searchView;
    //DatabaseHelper ourdb;
    // ArrayAdapter adapter;
    //ArrayList list;
    //ArrayList list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout fLayout = (FrameLayout) findViewById(R.id.frame_layout);
        RecyclerView entryView=(RecyclerView)findViewById(R.id.entryView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        entryView.setLayoutManager(linearLayoutManager);
        entryView.setHasFixedSize(true);
        restaurantsTitle = (TextView) findViewById(R.id.restaurantsTitle);
        allEntries=new ArrayList<>();
        mDatabase=new SqliteDatabase(this);
        allEntries=mDatabase.listEntries();

        //System.out.println(allEntries);


        if(allEntries.size() > 0){
            entryView.setVisibility(View.VISIBLE);
            mAdapter = new EntryAdapter(this, allEntries);
            entryView.setAdapter(mAdapter);

        }else {
            entryView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }


        //Logger logger=Logger.getLogger(RestaurantsActivity.class.getName());

       // deleteBtn = (Button) findViewById(R.id.deleteEntry);
        //editTxtId=(EditText)findViewById(R.id.editTxtId);
       // ourdb = new SqliteDatabase(this);
        //db = ourdb.getWritableDatabase();
        //restaurantsListView = (ListView) findViewById(R.id.restaurantsListView);
        //rv = findViewById(R.id.entryView);
        //rv.setLayoutManager(new LinearLayoutManager(this));
        //entryAdapter=new EntryAdapter(this,getAllItems());
        //searchView=(SearchView)findViewById(R.id.searchView);

        //recyclerView.setAdapter(entryAdapter);
       // adapter = new EntryAdapter(this, entries);

        //getAllItems();
        //getEntries();

        //retrieve();
        //delete();
/*
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                              @Override
                                              public boolean onQueryTextSubmit(String query) {
                                                  if(entries.contains(query)){
                                                      adapter.getFilter().filter(query);
                                                  }else{
                                                      Toast.makeText(RestaurantsActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                                                  }
                                                  return false;
                                              }
                                              @Override
                                              public boolean onQueryTextChange(String newText) {
                                                  adapter.getFilter().filter(newText);
                                                  return false;
                                              }
*/

        //showBtn = (Button) findViewById(R.id.showBtn);

        //showList();

        /*restaurantsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RestaurantsActivity.this, String.valueOf(restaurantsListView.getAdapter().getItem(i)),
                        Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    /*
    private void showDialog() {
        Dialog d = new Dialog(this);

        //NO TITLE
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //layout of dialog
        d.setContentView(R.layout.custom_layout);

    }*/

    /*
    public void getEntries() {
        SqliteDatabase db = new SqliteDatabase(this);
        Cursor c = db.showData();

        while (c.moveToNext()) {
            int id = c.getInt(0);
            String address = c.getString(2);
            String phone = c.getString(3);
            String description = c.getString(4);
            String rating = c.getString(5);
            String name = c.getString(1);
            String tags = c.getString(6);
            Entry entry = new Entry(id, name, address, phone, description, rating, tags);
            entries.add(entry);
        }

        try{
        rv.setAdapter(adapter);}
        catch(NullPointerException e){
            System.out.println(adapter);
        }
    }*/

            /*if (!(entries.size() < 1))*/

/*
    public void retrieve(){
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        entries.clear();
        Cursor c=db.getAllEntries();

        while(c.moveToNext()){
            int id=c.getInt(0);
            String name=c.getString(1);
            String address=c.getString(2);
            String phone=c.getString(3);
            String description=c.getString(4);
            String rating=c.getString(5);
            String tags=c.getString(6);

            Entry e=new Entry(id,name,address,phone,description,rating,tags);
            entries.add(e);
        }

        if(!(entries.size()<1)){
            recyclerView.setAdapter(adapter);
        }
    }*/
    /*
    private Cursor getAllItems(){
        return ourdb.showNameAndTag();
    }*/
/*
    public void delete(){
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Integer delete=ourdb.delete(editTxtId.getText().toString());
                if(delete>0){
                    Toast.makeText(RestaurantsActivity.this,"Entry deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RestaurantsActivity.this,"Entry not deleted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/


    /*public void showList() {


        //showBtn.setOnClickListener(new View.OnClickListener() {
           // @Override
          //  public void onClick(View view) {

                ArrayList list=new ArrayList();
                list.clear();
                Cursor cursor = ourdb.showData();
                if (cursor.getCount() == 0) {
                    Toast.makeText(RestaurantsActivity.this, "No data", Toast.LENGTH_SHORT).show();
                }
                    while (cursor.moveToNext()) {
                        list.add("Id: "+cursor.getString(0));
                        list.add("Name: "+cursor.getString(1));
                      //  list.add(cursor.getString(2));
                       // list.add(cursor.getString(3));
                       // list.add(cursor.getString(4));
                       // list.add(cursor.getString(5));
                        list.add("Tags: "+cursor.getString(6));
                    }

                   // ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_restaurant_list, R.id.nameTxtView, list);

                    adapter = new ArrayAdapter(RestaurantsActivity.this,android.R.layout.simple_list_item_1, list);
                    restaurantsListView.setAdapter(adapter);
                }*/
/*
    public void delete()
    {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete = ourdb.delete(etid.getText().toString());
                if(delete > 0)
                {
                    Toast.makeText(RestaurantsActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RestaurantsActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // });
    //}*/


        //showEntriesFromDatabase();
        /*adapter=new EntryAdapter(this,R.layout.activity_restaurant_list,restaurantsList,database);
        restaurantsListView.setAdapter(adapter);
*/
       /* editBtn=(Button)findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEditRestaurantActivity();
            }
        });*/


        //List<String[]>entries=new ArrayList<String[]>();

/*
        try(BufferedReader br=new BufferedReader(new FileReader("Restaurant-Data.txt"))){
            String line;
            while((line=br.readLine())!=null) {
                String[] entries = line.split("\n");
                entriesall.add(Arrays.asList(entries));


            }
        } catch(IOException e){
            e.printStackTrace();
        }
*/


        /*
        String[]entries;
           try{
                FileInputStream fileInputStream= openFileInput("Restaurant-Data.txt");
                int read=-1;
                StringBuffer buffer=new StringBuffer();
                while((read=fileInputStream.read())!=-1){
                    String[]line;
                    buffer.append((char)read);

                }
                Log.d("Restaurant-Data",buffer.toString());
                String name=buffer.substring(0,buffer.indexOf(","));
                String address=buffer.substring(buffer.indexOf(",")+1);
                String phone=buffer.substring(buffer.indexOf(",")+2);
                String description=buffer.substring(buffer.indexOf(",")+3);
                String rating=buffer.substring(buffer.indexOf(",")+4);
                String tags=buffer.substring(buffer.indexOf(",")+5);


            }catch(Exception e){
                e.printStackTrace();
            }



        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_main,entries);
            ListView listView=(ListView)findViewById(R.id.restaurantsList);
            listView.setAdapter(adapter);



        FileInputStream fis = null;
        String contents = "";
        String array[];
        ArrayList<String> entries = new ArrayList<String>();
        try {
            fis = openFileInput("Restaurant-Data.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
               // System.out.println(line);
                //String[] values = line.split(",");
               // ArrayList<String> row = new ArrayList<String>();
                //Collections.addAll(row, values);
               // entries.add(row);
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            contents = stringBuilder.toString();
            array=contents.split("\n");
            Collections.addAll(entries,array);
           // System.out.println(contents);
        }
        using a for loop, iterate over array called array, construct a string using
        the required array elements then push that string into a new array. This new array
        can then be passed into the array adapter for the listview

        for(int i = 0; i<entries.size(); i++){

            String k="Name: "+entries.get(0)+"Tags: "+entries.get(6);


        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_restaurant_list, R.id.entryTextView, entries);
        restaurantsList.setAdapter(adapter);
        restaurantsList.
        View v;
        int count=restaurantsList.getChildCount();

        System.out.println(count);
        for(int i=0;i<count;i++){
            v=restaurantsList.getChildAt(i);
            //TextView nameTextView=(TextView)v.getch
        }*/

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchmenu, menu);

        MenuItem search = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }*/
/*
    private void search(SearchView searchView){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(mAdapter!=null)
                    mAdapter.getFilter().filter(newText);
                    return true;
            }
        });
    }*/



        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
                case R.id.restaurantDetails:
                    Intent intent = new Intent(this, RestaurantDetailsActivity.class);
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

    /*public void openEditRestaurantActivity(){
        Intent intent=new Intent(this,EditRestaurantActivity.class);
        startActivity(intent);
    }*/


}
