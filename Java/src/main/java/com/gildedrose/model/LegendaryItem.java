package com.gildedrose.model;

import com.gildedrose.Item;

/**
 * Will never decrease in quality and never has to been sold
 */
public class LegendaryItem extends CategorizedItem {
	protected void updateExpired(Item item) {
		// a legendary item will never expire
	}
	protected void updateSellIn(Item item) {
		// a legendary item will never sell out
	}
	protected void updateQuality(Item item) {
		// a legendary item will never decrease of increase in quality
	}
}

