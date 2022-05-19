package com.pszymczyk.singleresponsibility;

import org.springframework.context.event.EventListener;

/**
 * @author pawel szymczyk
 */
class ItemBoughtEventHandler {

    private ItemBoughtEventHandlerFactory itemBoughtEventHandlerFactory;

    public ItemBoughtEventHandler(ItemBoughtEventHandlerFactory itemBoughtEventHandlerFactory) {
        this.itemBoughtEventHandlerFactory = itemBoughtEventHandlerFactory;
    }

    @EventListener
    public void handle(ItemBought itemBought) {
        itemBoughtEventHandlerFactory.create(itemBought.getType()).handle(itemBought);
    }
}
