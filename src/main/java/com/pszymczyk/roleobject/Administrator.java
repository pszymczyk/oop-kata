package com.pszymczyk.roleobject;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

class Administrator extends Person {

    private final List<String> supportedSystems = new ArrayList<>();

    Administrator(String id) {
        super(id);
    }

    void addSupportedSystem(String supportedSystem) {
        supportedSystems.add(supportedSystem);
    }

    List<String> getSupportedSystems() {
        return unmodifiableList(supportedSystems);
    }

}
