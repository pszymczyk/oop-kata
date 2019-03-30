package com.pszymczyk.roleobject;

import java.util.Collections;
import java.util.List;

class Developer extends PersonRole {

    List<String> programingLanguages() {
        return Collections.singletonList("Java");
    }

    @Override
    public boolean hasType(String roleName) {
        return "developer".equalsIgnoreCase(roleName);
    }
}
