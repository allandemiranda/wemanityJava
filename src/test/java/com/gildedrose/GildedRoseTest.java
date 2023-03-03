package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

  @Test
  void foo() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items[0].name);
  }

  @Test
  void integrationTest() {
    //given
    Item[] items = new Item[]{
      new Item("+5 Dexterity Vest", 10, 20), //
      new Item("Aged Brie", 2, 0), //
      new Item("Elixir of the Mongoose", 5, 7), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 3, 6)};

    //when
    GildedRose app = new GildedRose(items);

    //then
    app.updateQuality();
    Item[] items1Day = new Item[]{
      new Item("+5 Dexterity Vest", 9, 19), //
      new Item("Aged Brie", 1, 1), //
      new Item("Elixir of the Mongoose", 4, 6), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
      new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
      new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 2, 5)};
    assertEquals(Arrays.toString(items1Day), Arrays.toString(items));

    app.updateQuality();
    Item[] items2Day = new Item[]{
      new Item("+5 Dexterity Vest", 8, 18), //
      new Item("Aged Brie", 0, 2), //
      new Item("Elixir of the Mongoose", 3, 5), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
      new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
      new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 1, 4)};
    assertEquals(Arrays.toString(items2Day), Arrays.toString(items));

    app.updateQuality();
    Item[] items3Day = new Item[]{
      new Item("+5 Dexterity Vest", 7, 17), //
      new Item("Aged Brie", -1, 4), //
      new Item("Elixir of the Mongoose", 2, 4), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 12, 23),
      new Item("Backstage passes to a TAFKAL80ETC concert", 7, 50),
      new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 0, 3)};
    assertEquals(Arrays.toString(items3Day), Arrays.toString(items));

    app.updateQuality();
    Item[] items4Day = new Item[]{
      new Item("+5 Dexterity Vest", 6, 16), //
      new Item("Aged Brie", -2, 6), //
      new Item("Elixir of the Mongoose", 1, 3), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 11, 24),
      new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50),
      new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", -1, 1)};
    assertEquals(Arrays.toString(items4Day), Arrays.toString(items));

    app.updateQuality();
    Item[] items5Day = new Item[]{
      new Item("+5 Dexterity Vest", 5, 15), //
      new Item("Aged Brie", -3, 8), //
      new Item("Elixir of the Mongoose", 0, 2), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
      new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", -2, 0)};
    assertEquals(Arrays.toString(items5Day), Arrays.toString(items));

    app.updateQuality();
    Item[] items6Day = new Item[]{
      new Item("+5 Dexterity Vest", 4, 14), //
      new Item("Aged Brie", -4, 10), //
      new Item("Elixir of the Mongoose", -1, 0), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 9, 27),
      new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
      new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", -3, 0)};
    assertEquals(Arrays.toString(items6Day), Arrays.toString(items));

    app.updateQuality();
    Item[] items7Day = new Item[]{
      new Item("+5 Dexterity Vest", 3, 13), //
      new Item("Aged Brie", -5, 12), //
      new Item("Elixir of the Mongoose", -2, 0), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 8, 29),
      new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
      new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", -4, 0)};
    assertEquals(Arrays.toString(items7Day), Arrays.toString(items));

  }

}
