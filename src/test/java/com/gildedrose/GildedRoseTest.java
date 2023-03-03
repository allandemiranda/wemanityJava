package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String CONJURED = "Conjured Mana Cake";

  private final GildedRose gildedRose = new GildedRose(new Item[]{});

  @BeforeEach
  void init() {
    gildedRose.items = new Item[]{
      new Item(AGED_BRIE, Mockito.anyInt(), Mockito.anyInt()),
      new Item(SULFURAS, Mockito.anyInt(), Mockito.anyInt()),
      new Item(BACKSTAGE_PASSES, Mockito.anyInt(), Mockito.anyInt()),
      new Item(CONJURED, Mockito.anyInt(), Mockito.anyInt()),
      new Item(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())
    };
  }

  @Test
  void testUpdateNormalItemsellInPositive() {
    //given
    gildedRose.items = Arrays.stream(gildedRose.items).filter(item -> AGED_BRIE.equals(item.name))
      .peek(item -> {
        item.sellIn = 2;
        item.quality = 0;
      }).toArray(Item[]::new);
    //when
    gildedRose.updateQuality();
    //then
    Arrays.stream(gildedRose.items).filter(item -> AGED_BRIE.equals(item.name)).forEach(item -> {
      assertEquals(1, item.sellIn);
      assertEquals(1, item.quality);
    });
  }

  @Test
  void testUpdateNormalItemsellInNegative() {
    //given
    gildedRose.items = Arrays.stream(gildedRose.items).filter(item -> AGED_BRIE.equals(item.name))
      .peek(item -> {
        item.sellIn = -1;
        item.quality = 4;
      }).toArray(Item[]::new);
    //when
    gildedRose.updateQuality();
    //then
    Arrays.stream(gildedRose.items).filter(item -> AGED_BRIE.equals(item.name)).forEach(item -> {
      assertEquals(-2, item.sellIn);
      assertEquals(6, item.quality);
    });
  }

  @ParameterizedTest
  @ValueSource(ints = { -2, -1, 0, 1, 2 })
  void testUpdateSulfurasAnySellIn(int sellIn){
    //given
    gildedRose.items = Arrays.stream(gildedRose.items).filter(item -> SULFURAS.equals(item.name))
      .peek(item -> {
        item.sellIn = sellIn;
        item.quality = 80;
      }).toArray(Item[]::new);
    //when
    gildedRose.updateQuality();
    //then
    Arrays.stream(gildedRose.items).filter(item -> AGED_BRIE.equals(item.name)).forEach(item -> {
      assertEquals(sellIn, item.sellIn);
      assertEquals(80, item.quality);
    });
  }

}
