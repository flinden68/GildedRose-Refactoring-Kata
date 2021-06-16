package com.gildedrose.helper;

import com.gildedrose.Item;
import com.gildedrose.model.*;

public class ItemCategorizer {

	public ItemCategorizer(){}

	public CategorizedItem categorizeItems(Item item) {
		if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
			return new LegendaryItem();
		}
		if (item.name.equals("Aged Brie")) {
			return new CheeseItem();
		}
		if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			return new BackstagePassItem();
		}
		if (item.name.startsWith("Conjured")) {
			return new ConjuredItem();
		}
		return new CategorizedItem();
	}

}
