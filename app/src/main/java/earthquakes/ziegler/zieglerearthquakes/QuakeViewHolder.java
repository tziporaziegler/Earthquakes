package earthquakes.ziegler.zieglerearthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class QuakeViewHolder extends RecyclerView.ViewHolder {

    private TextView name;

    public QuakeViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    public void bind(Quake quake) {
        name.setText(quake.getProperties().getPlace());
    }
}