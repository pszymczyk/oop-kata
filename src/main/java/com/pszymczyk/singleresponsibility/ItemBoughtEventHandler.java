package com.pszymczyk.singleresponsibility;

import org.springframework.context.event.EventListener;

/**
 * @author pawel szymczyk
 */
class ItemBoughtEventHandler {

    private final ItemBoughtRepository itemBoughtRepository;

    public ItemBoughtEventHandler(ItemBoughtRepository itemBoughtRepository) {
        this.itemBoughtRepository = itemBoughtRepository;
    }

    @EventListener
    public void handle(ItemBought itemBought) {
        itemBoughtRepository.save(itemBought);
    }
}
