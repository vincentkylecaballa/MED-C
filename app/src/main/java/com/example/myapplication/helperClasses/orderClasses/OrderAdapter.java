package com.example.myapplication.helperClasses.orderClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<OrderModel> orders;


    public OrderAdapter(ArrayList<OrderModel> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.user_orders, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderModel orderModel = orders.get(position);
        holder.orderImage.setImageResource(orderModel.getOrderImg());
        holder.orderName.setText(orderModel.getOrderName());
        holder.orderQuan.setText(orderModel.getQuan());
        holder.orderTotalPrice.setText(orderModel.getTotalPrice());

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView orderName, orderTotalPrice, orderQuan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage = itemView.findViewById(R.id.productsImg);
            orderName = itemView.findViewById(R.id.tvOrderTitle);
            orderTotalPrice = itemView.findViewById(R.id.tvOrdersTotalPrice);
            orderQuan = itemView.findViewById(R.id.tvOrdersQuan);

        }
    }
}
