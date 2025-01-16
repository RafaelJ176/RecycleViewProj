package il.rjana.recycleviewproj.adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import il.rjana.recycleviewproj.R;
import il.rjana.recycleviewproj.data.Item;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private final List<Item> items;
    private final Context context;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
        Log.d("ItemAdapter", "Created with " + items.size() + " items");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        Log.d("ItemAdapter", "Binding item: " + item.getTitle());
        
        holder.imageView.setImageResource(item.getImage());
        holder.titleView.setText(item.getTitle());
        holder.descriptionView.setText(item.getDescription());

        holder.itemView.setOnClickListener(v -> showDetailsDialog(item));
    }

    private void showDetailsDialog(Item item) {
        Dialog dialog = new Dialog(context, R.style.DialogAnimation);
        dialog.setContentView(R.layout.dialog_item_details);

        ImageView dialogImage = dialog.findViewById(R.id.dialog_image);
        TextView dialogTitle = dialog.findViewById(R.id.dialog_title);
        TextView dialogDescription = dialog.findViewById(R.id.dialog_description);

        dialogImage.setImageResource(item.getImage());
        dialogTitle.setText(item.getTitle());
        dialogDescription.setText(item.getDescription());

        View dialogContent = dialog.findViewById(android.R.id.content);
        dialogContent.setAlpha(0f);
        dialogContent.animate()
                .alpha(1f)
                .setDuration(300)
                .start();

        dialog.findViewById(R.id.dialog_close_button).setOnClickListener(v -> {
            dialogContent.animate()
                    .alpha(0f)
                    .setDuration(300)
                    .withEndAction(dialog::dismiss)
                    .start();
        });

        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
            );
            window.setWindowAnimations(R.style.DialogAnimation);
        }

        dialog.show();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public final TextView titleView;
        public final TextView descriptionView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImage);
            titleView = itemView.findViewById(R.id.itemTitle);
            descriptionView = itemView.findViewById(R.id.itemDescription);
        }
    }
}