package com.gildedrose.model;

import com.gildedrose.Item;

/**
 * Will never decrease in quality and never has to been sold
 */
public class LegendaryItem extends CategorizedItem {
	protected void updateExpired(Item item) {}
	protected void updateSellIn(Item item) {}
	protected void updateQuality(Item item) {}
}

