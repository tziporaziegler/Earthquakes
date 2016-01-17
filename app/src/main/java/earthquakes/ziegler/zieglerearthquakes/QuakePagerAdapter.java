package earthquakes.ziegler.zieglerearthquakes;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuakePagerAdapter extends PagerAdapter {

    private Quake[] quakes;
    private Context context;

    public QuakePagerAdapter(Quake[] quakes, Context context) {
        this.quakes = quakes;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //LayoutInflater reads xml and gives you Java views
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.quake_pager_item, null);
        TextView name = (TextView) view.findViewById(R.id.name);

        Quake president = quakes[position];
        name.setText(president.getProperties().getPlace());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return quakes.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
