package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

  @Test
  void testValues() {
    //given
    String name = Mockito.anyString();
    int sellIn = Mockito.anyInt();
    int quality = Mockito.anyInt();

    //when
    Item item = new Item(name, sellIn, quality);

    //then
    assertEquals(name, item.name);
    assertEquals(sellIn, item.sellIn);
    assertEquals(quality, item.quality);
  }

  @Test
  void testToString() {
    //given
    String name = Mockito.anyString();
    int sellIn = Mockito.anyInt();
    int quality = Mockito.anyInt();

    //when
    Item item = new Item(name, sellIn, quality);

    //then
    assertEquals(name.concat(", ").concat(String.valueOf(sellIn)).concat(", ").concat(String.valueOf(quality)) , item.toString());
  }
}