package com.pszymczyk.singleresponsibility;

import org.springframework.context.event.EventListener;

/**
 * @author pawel szymczyk
 */
class ItemBoughtEventHandler {

    private ItemBoughtEventHandlerPolicyFactory itemBoughtEventHandlerPolicyFactory;

    public ItemBoughtEventHandler(ItemBoughtEventHandlerPolicyFactory itemBoughtEventHandlerPolicyFactory) {
        this.itemBoughtEventHandlerPolicyFactory = itemBoughtEventHandlerPolicyFactory;
    }

    @EventListener
    public void handle(ItemBought itemBought) {
        itemBoughtEventHandlerPolicyFactory.create(itemBought.getType()).handle(itemBought);
    }
}
