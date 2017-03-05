package ho.jackie.febreezehack;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mikepenz.materialdrawer.DrawerBuilder;

public class MainActivity extends AppCompatActivity {

    RecyclerView bigRecycler;
    ImageView earthImage;
    RecyclerView smallRecycler1;
    RecyclerView smallRecycler2;
    RecyclerView smallRecycler3;
    RecyclerView smallRecycler4;
    RecyclerView smallRecycler5;
    SearchView searchView;
    Toolbar toolbar;

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;

    TextView text;

    int[] arr1 = {0,1,2,3};
    int[] arr2 = {4,5,6,7};
    int[] arr3 = {8,9,10,11};
    int[] arr4 = {12,13,14,15};
    int[] arr5 = {16,17,18,19};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bigRecycler = (RecyclerView)findViewById(R.id.warm_weather_big_list);
        smallRecycler1 = (RecyclerView)findViewById(R.id.list_1);
        smallRecycler2 = (RecyclerView)findViewById(R.id.list_3);
        smallRecycler3 = (RecyclerView)findViewById(R.id.list_5);
        smallRecycler4 = (RecyclerView)findViewById(R.id.list_6);
        smallRecycler5 = (RecyclerView)findViewById(R.id.list_7);
        earthImage = (ImageView) findViewById(R.id.earth_image);
        searchView = (SearchView)findViewById(R.id.search_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);

        text = (TextView) findViewById(R.id.text);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        text7 = (TextView) findViewById(R.id.text7);

        new DrawerBuilder().withActivity(this).withToolbar(toolbar).build();


        bigRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        smallRecycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        smallRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        smallRecycler3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        smallRecycler4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        smallRecycler5.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        BigRecyclerAdapter bigAdapter = new BigRecyclerAdapter(this);
        SmallRecyclerAdapter adapter1= new SmallRecyclerAdapter(arr1,this);
        SmallRecyclerAdapter adapter2= new SmallRecyclerAdapter(arr2,this);
        SmallRecyclerAdapter adapter3= new SmallRecyclerAdapter(arr3, this);
        SmallRecyclerAdapter adapter4= new SmallRecyclerAdapter(arr4, this);
        SmallRecyclerAdapter adapter5= new SmallRecyclerAdapter(arr5, this);
        bigRecycler.setAdapter(bigAdapter);
        smallRecycler1.setAdapter(adapter1);
        smallRecycler2.setAdapter(adapter2);
        smallRecycler3.setAdapter(adapter3);
        smallRecycler4.setAdapter(adapter4);
        smallRecycler5.setAdapter(adapter5);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/SourceCodePro-Bold.ttf");
        Typeface topFont = Typeface.createFromAsset(getAssets(), "fonts/Brandon_bld.ttf");

        text1.setTypeface(topFont);
        text.setTypeface(topFont);
        text2.setTypeface(font);
        text3.setTypeface(font);
        text4.setTypeface(font);
        text5.setTypeface(font);
        text6.setTypeface(font);
        text7.setTypeface(font);

        ApiManager.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        DrawableCompat.setTint(item.getIcon(), Color.WHITE);
        return true;
    }
}

