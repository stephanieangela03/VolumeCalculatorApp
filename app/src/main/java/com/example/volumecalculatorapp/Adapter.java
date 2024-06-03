package com.example.volumecalculatorapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private List<Shape> shapeList;

    public ShapeClickListener clickListener;

    public void setClickListener(ShapeClickListener myListener){
        this.clickListener = myListener;
    }

    public Adapter(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Untuk membuat view holder baru
        View shapeView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.shape_layout, parent, false);

        return new MyViewHolder(shapeView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Binds data dari dataset ke tampilan di view holder
        Shape shape = shapeList.get(position);

        holder.shapeName.setText(shape.getShapeName());
        holder.shapeImg.setImageResource(shape.getShapeImg());

    }

    @Override
    public int getItemCount() {
        // Returns total shape ke dataset
        return shapeList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView shapeImg;
        TextView shapeName;

        public MyViewHolder(@NonNull View shapeView) {
            super(shapeView);
            shapeName = shapeView.findViewById(R.id.shapeName);
            shapeImg = shapeView.findViewById(R.id.shapeImg);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}
