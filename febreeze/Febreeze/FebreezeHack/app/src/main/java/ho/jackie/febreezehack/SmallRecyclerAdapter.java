package ho.jackie.febreezehack;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by JH on 3/4/17.
 */

public class SmallRecyclerAdapter extends RecyclerView.Adapter<SmallRecyclerAdapter.SmallViewHolder> {

    private Context context;
    private int[] picLocation;


    public SmallRecyclerAdapter(int[] picLocation, Context context) {
        this.context = context;
        this.picLocation = picLocation;
    }

    @Override
    public SmallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_image, parent, false);
        SmallViewHolder tvh = new SmallViewHolder(view);
        return tvh;
    }

    @Override
    public void onBindViewHolder(SmallViewHolder holder, int position) {
        switch (picLocation[position]){
            case 0:
                Picasso.with(context)
                        .load(R.drawable.sheldon_forest)
                        .fit().centerInside()
                        .centerInside()
                        .into(holder.imageView);
                holder.textView.setText("SHELDON FOREST");
                break;
            case 1:
                Picasso.with(context)
                        .load(R.drawable.minnesota)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("MINNESOTA");
                break;
            case 2:
                Picasso.with(context)
                        .load(R.drawable.si_chuan)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("SI CHUAN");
                break;
            case 3:
                Picasso.with(context)
                        .load(R.drawable.england)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("ENGLAND");
                break;
            case 4:
                Picasso.with(context)
                        .load(R.drawable.ann_arbor)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("ANN ARBOR");
                break;
            case 5:
                Picasso.with(context)
                        .load(R.drawable.hartford)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("HARTFORD");
                break;
            case 6:
                Picasso.with(context)
                        .load(R.drawable.alexandria)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("ALEXANDRIA");
                break;
            case 7:
                Picasso.with(context)
                        .load(R.drawable.cambridge)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("CAMBRIDGE");
                break;
            case 8:
                Picasso.with(context)
                        .load(R.drawable.yosemite)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("YOSEMITE");
                break;
            case 9:
                Picasso.with(context)
                        .load(R.drawable.boundary_waters)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("BOUNDARY WATERS");
                break;
            case 10:
                Picasso.with(context)
                        .load(R.drawable.redwoods)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("REDWOODS");
                break;
            case 11:
                Picasso.with(context)
                        .load(R.drawable.jasper_park)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("JASPER PARK");
                break;
            case 12:
                Picasso.with(context)
                        .load(R.drawable.kepler)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("KEPLER");
                break;
            case 13:
                Picasso.with(context)
                        .load(R.drawable.kuai)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("KUAI");
                break;
            case 14:
                Picasso.with(context)
                        .load(R.drawable.fitzroy_mountains)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("FITZROY MOUNTAINS");
                break;
            case 15:
                Picasso.with(context)
                        .load(R.drawable.ohau)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("OHAU");
                break;
            case 16:
                Picasso.with(context)
                        .load(R.drawable.summer_with_dad)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("SUMMER WITH DAD");
                break;
            case 17:
                Picasso.with(context)
                        .load(R.drawable.backyard_garden)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("BACKYARD GARDEN");
                break;
            case 18:
                Picasso.with(context)
                        .load(R.drawable.christmas_eve)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("CHRISTMAS EVE");
                break;
            case 19:
                Picasso.with(context)
                        .load(R.drawable.april_air)
                        .fit().centerInside()
                        .into(holder.imageView);
                holder.textView.setText("APRIL AIR");
                break;
        }
        holder.textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Brandon_bld.ttf"));

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class SmallViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public SmallViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image2);
            textView = (TextView)itemView.findViewById(R.id.location);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            context.startActivity(intent);
        }
    }
}
