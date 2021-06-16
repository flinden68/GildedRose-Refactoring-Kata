package com.gildedrose.model;

import com.gildedrose.Item;

/**
 * will decrease in quality twice as fast a categorized item
 */
public class ConjuredItem extends CategorizedItem {
	protected void updateExpired(Item item) {
		decrementQuality(item);
		decrementQuality(item);
	}
	protected void updateQuality(Item item) {
		decrementQuality(item);
		decrementQuality(item);
	}
}
