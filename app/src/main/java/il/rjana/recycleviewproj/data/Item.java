package il.rjana.recycleviewproj.data;

import java.util.ArrayList;
import java.util.List;
import il.rjana.recycleviewproj.R;

public class Item {
    private final int image;
    private final String title;
    private final String description;

    public Item(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    // Getters
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // Static method to get items list
    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        
        items.add(new Item(
                R.drawable.ted_mosby,
                "Ted Mosby",
                "The main protagonist and narrator. An architect searching for true love while telling his kids the story of how he met their mother."
        ));
        
        items.add(new Item(
                R.drawable.barney_stinson,
                "Barney Stinson",
                "The suit-loving womanizer who evolves from a manipulative player to a caring husband. Known for catchphrases like 'Legen-wait for it-dary!'"
        ));
        
        items.add(new Item(
                R.drawable.marshall_eriksen,
                "Marshall Eriksen",
                "Ted's best friend from college and lawyer. The devoted husband to Lily, known for his optimistic nature and belief in supernatural phenomena."
        ));
        
        items.add(new Item(
                R.drawable.lily_aldrin,
                "Lily Aldrin",
                "Kindergarten teacher and Marshall's wife. The group's maternal figure who often meddles in others' relationships with good intentions."
        ));
        
        items.add(new Item(
                R.drawable.robin_scherbatsky,
                "Robin Scherbatsky",
                "Canadian news reporter and Ted's on-again-off-again love interest. Career-focused, commitment-phobic, and secretly former teen pop star Robin Sparkles."
        ));
        
        items.add(new Item(
                R.drawable.tracy_mosby,
                "Tracy McConnell",
                "The Mother. A bass player whose life intertwined with the gang's for years before meeting Ted. Known for her charm and similar personality to Ted."
        ));
        
        items.add(new Item(
                R.drawable.ranjit,
                "Ranjit",
                "The gang's favorite cab/limo driver who appears throughout the series. Always greets the group with a cheerful 'Hello!'"
        ));
        
        items.add(new Item(
                R.drawable.carl,
                "Carl the Bartender",
                "The longtime bartender at MacLaren's Pub, the gang's favorite hangout spot. A constant presence throughout the series."
        ));
        
        items.add(new Item(
                R.drawable.quinn,
                "Quinn Garvey",
                "A stripper-turned-girlfriend of Barney's who almost became his wife. Known for her sharp wit and matching Barney's manipulation skills."
        ));
        
        items.add(new Item(
                R.drawable.victoria,
                "Victoria",
                "Ted's girlfriend and talented baker. One of Ted's most significant relationships before meeting the Mother, known for her wedding escape with Ted."
        ));
        
        return items;
    }
} 