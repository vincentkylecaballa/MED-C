package com.example.myapplication.helperClasses.homepageClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.AdapterViewHolder> {

    ArrayList<FeaturedHelper> featuredLocations;

    RecyclerViewClickListener listener;


    public FeaturedAdapter(ArrayList<FeaturedHelper> featuredLocations, RecyclerViewClickListener listener) {
        this.featuredLocations = featuredLocations;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_design_view, parent, false);
        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(v);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        FeaturedHelper featuredHelper = featuredLocations.get(position);


        //holder
        holder.image.setImageResource(featuredHelper.getImg());
        holder.description.setText(featuredHelper.getDesc());
        holder.title.setText(featuredHelper.getTitle());
        holder.price.setText(featuredHelper.getPrice());
        holder.addtocart.setImageResource(featuredHelper.getAddtocart());
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image, addtocart;
        TextView title, description, price;
        Button buy;


        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            //get design via Hooks
            image = itemView.findViewById(R.id.productsImg);
            price = itemView.findViewById(R.id.pricePhp);
            title = itemView.findViewById(R.id.titleTxt);
            description = itemView.findViewById(R.id.descTxt);
            addtocart = itemView.findViewById(R.id.addtoCart);
            buy = itemView.findViewById(R.id.buyBtn);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }
}
