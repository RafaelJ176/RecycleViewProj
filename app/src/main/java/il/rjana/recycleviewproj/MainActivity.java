package il.rjana.recycleviewproj;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import il.rjana.recycleviewproj.adapter.ItemAdapter;
import il.rjana.recycleviewproj.data.Item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get data
        List<Item> items = Item.getItems();
        Log.d("MainActivity", "Got " + items.size() + " items");

        // Set adapter
        ItemAdapter adapter = new ItemAdapter(items, this);
        recyclerView.setAdapter(adapter);
    }
}