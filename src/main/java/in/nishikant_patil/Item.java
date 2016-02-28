package in.nishikant_patil;

import java.math.BigDecimal;

/**
 * Domain model for items served by the Kitchen.
 */
public final class Item {
    private final String name;
    private final BigDecimal cost;
    private final int count;

    public Item(String name, BigDecimal cost, int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return name.equals(item.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                '}';
    }
}
