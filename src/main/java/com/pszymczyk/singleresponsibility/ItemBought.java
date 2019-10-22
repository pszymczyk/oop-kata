package com.pszymczyk.singleresponsibility;

/**
 * @author pawel szymczyk
 */
class ItemBought {

    enum Type {
        MOBILE,
        DESKTOP
    }

    private final String id;
    private final Type type;
    private final String itemId;
    private final long timestamp;

    public ItemBought(String id, Type type, String itemId, long timestamp) {
        this.id = id;
        this.type = type;
        this.itemId = itemId;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getItemId() {
        return itemId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
