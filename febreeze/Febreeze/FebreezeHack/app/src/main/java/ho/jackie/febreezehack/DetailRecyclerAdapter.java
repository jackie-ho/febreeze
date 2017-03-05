package ho.jackie.febreezehack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by JH on 3/4/17.
 */

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.DetailViewHolder> {

    private Context context;
    public DetailRecyclerAdapter(Context context) {
        this.context = context;
    }
    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_image, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        Picasso
                .with(context)
                .load("https://c402277.ssl.cf1.rackcdn.com/photos/10034/images/story_full_width/NV2A9918.jpg?1444318174")
                .fit()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public DetailViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image2);
        }
    }
}
