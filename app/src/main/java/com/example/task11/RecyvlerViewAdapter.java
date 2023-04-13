package com.example.task11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyvlerViewAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<Food> foods= new ArrayList<>();

    public RecyvlerViewAdapter(Context context, ArrayList<Food> users) {
        this.context = context;
        this.foods = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.one_line_crousery, parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.tv_food.setText(foods.get(position).getTimeCounter()+". " + foods.get(position).getName());
        holder.tv_mem.setText(foods.get(position).getMemo());
        holder.editName.setText(foods.get(position).getName());
        //remove:
        holder.removeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=holder.getAdapterPosition();
                Storage.getInstance().removeFood(foods.get(pos).getName());
                notifyItemRemoved(pos);
            }
        });
        //edit:
        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=holder.getAdapterPosition();
                if(holder.editName.getVisibility() == view.VISIBLE){
                    Food food= Storage.getInstance().getFoodById(pos);
                    food.setName(holder.editName.getText().toString());
                    holder.editName.setVisibility(view.GONE);
                    notifyDataSetChanged();
                }else {
                    holder.editName.setVisibility(view.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    /**public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tv_food;
        TextView tv_mem;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_food=itemView.findViewById(R.id.tv_foodName);
            tv_mem=itemView.findViewById(R.id.tv_memo);

        }
    }**/
}
