package com.encharity.encharity_v1.blog;

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

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {

    /*private int[] images;
    private String[] titles;
    private String[] descriptions;*/
    private List<Blog> blogList;
    private BlogAdapter.Listener listener;

    public interface Listener{
        void onClick(int position);
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
        notifyDataSetChanged();
    }

    public void setListener(BlogAdapter.Listener listener) {
        this.listener = listener;
    }

    public BlogAdapter(List<Blog> blogList/*int[] images, String[] titles, String[] descriptions*/) {
        this.blogList= blogList;
        /*this.images = images;
        this.titles = titles;
        this.descriptions = descriptions;*/
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
    public BlogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.for_blog_adapter,viewGroup,false);

        return new BlogAdapter.ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.ViewHolder viewHolder, final int i) {
        CardView cardView = viewHolder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.blog_photo);
        TextView titleTextView = (TextView) cardView.findViewById(R.id.blog_title);
        TextView descriptionTextView = (TextView) cardView.findViewById(R.id.blog_description);

        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), R.drawable.kid2);
        imageView.setImageDrawable(drawable);
        titleTextView.setText(blogList.get(i).getBlogTitle());
        descriptionTextView.setText(blogList.get(i).getBlogDescription());

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
        return blogList.size();
    }
}
