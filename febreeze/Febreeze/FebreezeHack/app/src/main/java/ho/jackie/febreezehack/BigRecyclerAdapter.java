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

public class BigRecyclerAdapter extends RecyclerView.Adapter<BigRecyclerAdapter.BigViewHolder> {

    private Context context;

    public BigRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BigViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_image, parent, false);
        BigViewHolder tvh = new BigViewHolder(view);
        return tvh;
    }

    @Override
    public void onBindViewHolder(BigViewHolder holder, int position) {
        switch (position) {
            case 0:
            Picasso.with(context)
                    .load(R.drawable.venice_beach)
                    .fit()
                    .centerInside()
                    .into(holder.imageView);
                holder.textView.setText("VENICE BEACH");
                break;
            case 1:
                Picasso.with(context)
                        .load(R.drawable.saint_martin)
                        .fit()
                        .centerInside()
                        .into(holder.imageView);
                holder.textView.setText("SAINT MARTIN");
        }
        holder.textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Brandon_bld.ttf"));

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class BigViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public BigViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image1);
            textView = (TextView) itemView.findViewById(R.id.location);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            context.startActivity(intent);
        }
    }
}
