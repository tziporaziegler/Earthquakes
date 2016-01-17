package earthquakes.ziegler.zieglerearthquakes;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        Quake quakes[] = (Quake[]) getIntent().getSerializableExtra("QUAKES");
        QuakePagerAdapter adapter = new QuakePagerAdapter(quakes, this.getBaseContext());
        viewPager.setAdapter(adapter);

        int position = getIntent().getIntExtra("POSITION", 0);

        viewPager.setCurrentItem(position);
    }
}