package com.gildedrose;

import com.gildedrose.helper.ItemCategorizer;
import com.gildedrose.model.CategorizedItem;

class GildedRose {
    private Item[] items;

    public GildedRose() {}

    public void updateQuality() {
        ItemCategorizer itemCategorizer = new ItemCategorizer();

        for (Item item : items) {
            // first determine what kind of items we are dealing with
            CategorizedItem categorizedItem = itemCategorizer.categorizeItems(item);

            //run the update functionality
            categorizedItem.updateOneItem(item);
        }
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items){
        this.items = items;
    }
}
