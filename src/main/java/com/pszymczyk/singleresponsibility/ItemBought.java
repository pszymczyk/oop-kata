package com.pszymczyk.singleresponsibility;

/**
 * @author pawel szymczyk
 */
class ItemBought {


    private final String id;
    private final String itemId;
    private final long timestamp;

    public ItemBought(String id, String itemId, long timestamp) {
        this.id = id;
        this.itemId = itemId;
        this.timestamp = timestamp;
    }
}
