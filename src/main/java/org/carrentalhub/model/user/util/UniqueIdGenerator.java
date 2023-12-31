package org.carrentalhub.model.user.util;

import java.util.UUID;

public class UniqueIdGenerator {

    public int generateId() {
        UUID randomId = UUID.randomUUID();
        String result = randomId.toString();
        return Math.abs(result.hashCode());
    }
}