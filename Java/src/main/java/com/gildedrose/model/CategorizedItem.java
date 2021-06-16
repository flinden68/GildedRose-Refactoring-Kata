package com.gildedrose.model;

import com.gildedrose.Item;

/**
 * For not a special item, with basic rules. Never higher as 50 and lower as 0. And normal decrease of quality
 */
public class CategorizedItem {
	protected void incrementQuality(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
	protected void decrementQuality(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}
	protected void updateExpired(Item item) {
		decrementQuality(item);
	}
	protected void updateSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}
	protected void updateQuality(Item item) {
		decrementQuality(item);
	}
	public void updateItem(Item item) {
		updateQuality(item);
		updateSellIn(item);
		if (item.sellIn < 0) {
			updateExpired(item);
		}
	}
}
