package earthquakes.ziegler.zieglerearthquakes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuakeAdapter extends RecyclerView.Adapter<QuakeViewHolder>{

    private Quake[] quakes;

    public QuakeAdapter(Quake[] quakes) {
        this.quakes = quakes;
    }

    @Override
    public QuakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quake_list_item, parent, false);
        return new QuakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final QuakeViewHolder holder, final int position) {
        holder.bind(quakes[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("QUAKES", quakes);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quakes.length;
    }
}
