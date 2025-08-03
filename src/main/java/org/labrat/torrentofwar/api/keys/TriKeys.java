package org.labrat.torrentofwar.api.keys;

import lombok.Getter;

public class TriKeys<A, B, C> {
    @Getter
    private final A a;
    @Getter
    private final B b;
    @Getter
    private final C c;

    public TriKeys(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Getters, equals(), and hashCode() are crucial for use in a Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TriKeys)) return false;
        TriKeys<?, ?,?> that = (TriKeys<?, ?,?>) o;
        return a.equals(that.a) && b.equals(that.b) && c.equals(that.c);
    }

    @Override
    public int hashCode() {
        return 31 * a.hashCode() + b.hashCode() + c.hashCode();
    }
}
