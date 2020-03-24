package tech.hahue.baikiemtraso1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import tech.hahue.baikiemtraso1.Models.Food;
import tech.hahue.baikiemtraso1.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Food> arrFoods;

    public HomeAdapter(Context context, ArrayList<Food> arrFoods) {
        this.context = context;
        this.arrFoods = arrFoods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.line_food, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Food food = arrFoods.get(position);
        holder.imv_thumnail.setImageResource(food.getImages());
        holder.tv_name.setText(food.getName());
        holder.tv_price.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(food.getPrice()));
        holder.tv_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(context, holder.tv_options);
                menu.inflate(R.menu.option_menu);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_edit:
                                Toast.makeText(context, "Sửa món " + food.getName(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item_delete:
                                Toast.makeText(context, "Xoá món " + food.getName(), Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                menu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv_thumnail;
        TextView tv_name, tv_price, tv_options;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_thumnail = itemView.findViewById(R.id.imv_thumnail);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_options = itemView.findViewById(R.id.tv_options);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, arrFoods.get(getPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
