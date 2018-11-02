package com.encharity.encharity_v1.archive;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.encharity.encharity_v1.R;

public class ArchiveAdapter extends RecyclerView.Adapter<ArchiveAdapter.ViewHolder> {

    private int[] images;
    private String[] titles;
    private String[] descriptions;
    private Listener listener;

    public interface Listener{
        void onClick(int position);
    }

    public void setListener(ArchiveAdapter.Listener listener) {
        this.listener = listener;
    }

    public ArchiveAdapter(int[] images, String[] titles, String[] descriptions) {
        this.images = images;
        this.titles = titles;
        this.descriptions = descriptions;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.for_archive_adapter,viewGroup,false);

        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        CardView cardView = viewHolder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.archive_photo);
        TextView titleTextView = (TextView) cardView.findViewById(R.id.archive_title);
        TextView descriptionTextView = (TextView) cardView.findViewById(R.id.archive_description);

        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), images[i]);
        imageView.setImageDrawable(drawable);
        titleTextView.setText(titles[i]);
        descriptionTextView.setText(descriptions[i]);

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
