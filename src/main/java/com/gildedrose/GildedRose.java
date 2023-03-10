package com.gildedrose;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

class GildedRose {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String CONJURED = "Conjured Mana Cake";

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    // parallel processor if Item's
    Arrays.stream(items).parallel().forEach(item -> {
      switch (item.name) {
        case AGED_BRIE -> {
          item.sellIn--;
          updateAgedBrieItem(item);
        }
        case SULFURAS -> item.quality = 80;
        case BACKSTAGE_PASSES -> {
          item.sellIn--;
          updateBackstagePassesItem(item);
        }
        case CONJURED -> {
          item.sellIn--;
          updateConjuredItem(item);
        }
        default -> {
          item.sellIn--;
          updateNormalItem(item);
        }
      }
    });
  }

  /**
   * Update 'Conjured Mana Cake' Quality.
   *
   * @param item the item
   */
  private void updateConjuredItem(@NotNull Item item) {
    updateNormalItem(item);
    updateNormalItem(item);
  }

  /**
   * Update normal item Quality.
   *
   * @param item the item
   */
  private void updateNormalItem(@NotNull Item item) {
    if (item.quality > 0) {
      if (item.sellIn >= 0) {
        item.quality--;
      } else {
        item.quality -= 2;
        if (item.quality < 0) {
          item.quality = 0;
        }
      }
    }
  }

  /**
   * Update 'Aged Brie' Quality.
   *
   * @param item the item
   */
  private void updateAgedBrieItem(@NotNull Item item) {
    if (item.quality < 50) {
      item.quality++;
      // this part is in the code line 56, but not in the *Gilded Rose Requirements Specification*
      if (item.sellIn < 0) {
        item.quality++;
      }
    }
  }

  /**
   * Update 'Backstage passes to a TAFKAL80ETC concert' Quality.
   *
   * @param item the item
   */
  private void updateBackstagePassesItem(@NotNull Item item) {
    if (item.sellIn < 0) {
      item.quality = 0;
    } else {
      // *Gilded Rose Requirements Specification* says 5 days or less
      if (item.sellIn < 5) {
        item.quality += 3;
      } else {
        // *Gilded Rose Requirements Specification* says 10 days or less
        if (item.sellIn < 10) {
          item.quality += 2;
        } else {
          item.quality++;
        }
      }
      // The problem is in the position where the decrease of the day is performed, line 40
      if (item.quality > 50) {
        item.quality = 50;
      }
    }
  }
}