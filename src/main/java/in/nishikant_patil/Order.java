package in.nishikant_patil;

import java.util.HashSet;
import java.util.Set;

/**
 * Model class for orders created and served in the Kitchen
 */
public final class Order {

    private final Set<Item> items = new HashSet<>();
    private final RoboWaiter waiter;
    private OrderStatus status;

    public Order(RoboWaiter waiter, Set<Item> items) {
        this.waiter = waiter;
        this.items.addAll(items);
        status = OrderStatus.NEW;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public void setOrderStatus(OrderStatus status) {
        this.status = status;
    }

    public void notifyWaiter() {
        waiter.serve(items);
    }

    public enum OrderStatus {
        NEW, PROCESSING, COMPLETE
    }
}
