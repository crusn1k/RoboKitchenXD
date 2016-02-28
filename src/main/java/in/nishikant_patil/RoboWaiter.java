package in.nishikant_patil;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Model class for waiter who wait upon the customers.
 */
public final class RoboWaiter {

    public static final AtomicLong waiterSequence = new AtomicLong(Long.MIN_VALUE);

    private final long waiterId = waiterSequence.incrementAndGet();
    private final String name;

    public RoboWaiter(String name) {
        this.name = name;
    }

    public void serve(Set<Item> items) {
        System.out.println(items + " are available for serving by " + name + ".");
    }
}
