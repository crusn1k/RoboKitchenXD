package in.nishikant_patil;

import java.util.concurrent.*;

/**
 * The Kitchen!
 */
public enum Kitchen {
    INSTANCE;

    private static final ExecutorService kitchenService = Executors.newFixedThreadPool(1);

    public static final int MAX_ORDERS = 10;
    private final BlockingQueue<Order> orders = new ArrayBlockingQueue<>(MAX_ORDERS);


    public void takeOrder(Order order) {
        orders.offer(order);
    }

    public void start() throws InterruptedException {
        kitchenService.submit(() -> {
            while (true) {
                Order order = orders.take();
                processOrder(order);
                order.setOrderStatus(Order.OrderStatus.COMPLETE);
                order.notifyWaiter();
            }
        });
    }

    private void processOrder(Order order) throws InterruptedException {
        order.setOrderStatus(Order.OrderStatus.PROCESSING);
        TimeUnit.SECONDS.sleep(10);
    }
}
