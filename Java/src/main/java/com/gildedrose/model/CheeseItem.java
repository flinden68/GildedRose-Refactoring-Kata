package com.gildedrose.model;

import com.gildedrose.Item;

/**
 * will increase in quality if times
 */
public class CheeseItem extends CategorizedItem {
	protected void updateExpired(Item item) {
		incrementQuality(item);
	}

	protected void updateQuality(Item item) {
		incrementQuality(item);
	}
}
