package com.pszymczyk.strategy;

import java.util.UUID;

public class Driver {

    enum Type {
        REGULAR,
        BUSINNES
    }

    private final UUID id;
    private final Type type;

    static Driver business(UUID id) {
        return new Driver(id, Type.BUSINNES);
    }

    static Driver regular(UUID id) {
        return new Driver(id, Type.REGULAR);
    }

    public Driver(UUID id) {
        this.id = id;
        type = null;
    }

    private Driver(UUID id, Type type) {
        this.id = id;
        this.type = type;
    }

    public boolean isBusiness() {
        return type == Type.BUSINNES;
    }

    public boolean isRegular() {
        return type == Type.REGULAR;
    }
}
