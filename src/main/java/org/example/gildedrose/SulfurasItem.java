package com.gildedrose;

import org.example.gildedrose.Item;

public class SulfurasItem extends Item {
    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItemQuality() {
    }

    @Override
    public void updateSellIn() {
    }
}
