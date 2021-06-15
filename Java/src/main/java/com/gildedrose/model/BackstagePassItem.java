package com.gildedrose.model;

import com.gildedrose.Item;

/**
 * will increase in quality as the sellIn is getting closer to 0, after concert there is no quality left
 */
public class BackstagePassItem extends CategorizedItem {
	protected void updateExpired(Item item) {
		item.quality = 0;
	}
	protected void updateQuality(Item item) {
		incrementQuality(item);
		if (item.sellIn <= 10) {
			incrementQuality(item);
		}
		if (item.sellIn <= 5) {
			incrementQuality(item);
		}
	}
}
