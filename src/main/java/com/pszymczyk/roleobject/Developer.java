package com.pszymczyk.roleobject;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

class Developer extends Person {

    private final List<String> knownLanguages = new ArrayList<>();

    Developer(String id) {
        super(id);
    }

    void addKnownLanguage(String knownLanguage) {
        knownLanguages.add(knownLanguage);
    }

    List<String> getProgramingLanguages() {
        return unmodifiableList(knownLanguages);
    }

}
