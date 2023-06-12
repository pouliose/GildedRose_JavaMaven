package com.gildedrose;

import org.example.gildedrose.Item;

public class BackstagePassesItem extends Item {
    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItemQuality() {
        if (this.getSellIn() < 0) {
            this.setQuality(0);
        } else if (this.getSellIn() < 5) {
            this.increaseQualityBy(3);
        } else if (this.getSellIn() < 10) {
            this.increaseQualityBy(2);
        }
    }
}
