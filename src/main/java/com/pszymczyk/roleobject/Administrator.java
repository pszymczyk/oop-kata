package com.pszymczyk.roleobject;

import java.util.Arrays;
import java.util.List;

class Administrator extends PersonRole {

    List<String> getSupportedSustems() {
        return Arrays.asList("Graphite", "Kubernetes", "Oracle");
    }

    @Override
    boolean hasType(String roleName) {
        return "admin".equals(roleName);
    }
}
