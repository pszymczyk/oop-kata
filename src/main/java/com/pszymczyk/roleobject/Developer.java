package com.pszymczyk.roleobject;

import java.util.Arrays;
import java.util.List;

class Developer extends PersonRole {

    private final String[] knowLanguage;

    Developer(String... knowLanguage) {
        this.knowLanguage = knowLanguage;
    }

    List<String> programingLanguages() {
        return Arrays.asList(knowLanguage);
    }

    @Override
    public boolean hasType(String roleName) {
        return "developer".equalsIgnoreCase(roleName);
    }
}
