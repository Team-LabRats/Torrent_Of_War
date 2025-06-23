package org.labrat.torrentofwar.utils;

import lombok.Getter;

public class KeyPair<A, B> {
    @Getter
    private final A key1;
    @Getter
    private final B key2;

    public KeyPair(A key1, B key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    // Getters, equals(), and hashCode() are crucial for use in a Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyPair)) return false;
        KeyPair<?, ?> that = (KeyPair<?, ?>) o;
        return key1.equals(that.key1) && key2.equals(that.key2);
    }

    @Override
    public int hashCode() {
        return 31 * key1.hashCode() + key2.hashCode();
    }
}
