package com.gildedrose;

import com.gildedrose.helper.ItemCategorizer;
import com.gildedrose.model.CategorizedItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemCategorizer itemCategorizer = new ItemCategorizer();

        for (Item item : items) {
            // first determine what kind of
            CategorizedItem categorizedItem = itemCategorizer.categorizeItems(item);
            categorizedItem.updateOneItem(item);
        }
    }
}
