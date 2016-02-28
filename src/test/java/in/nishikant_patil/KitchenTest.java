package in.nishikant_patil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Test for kitchen
 */
public class KitchenTest {

    private Item chai = new Item("chai", new BigDecimal("10"), 2);
    private Item sutta = new Item("sutta", new BigDecimal("15"), 2);

    private RoboWaiter tommy = new RoboWaiter("tommy");
    private RoboWaiter ganpat = new RoboWaiter("ganpat");

    @Test
    public void dummyTest() {
        Assert.assertTrue(true);
    }

    @Before
    public void startKitchen() throws InterruptedException {
        Kitchen.INSTANCE.start();
    }

    @Test
    public void testKitchen() throws InterruptedException {
        Order order1 = new Order(tommy, getItems());
        Order order2 = new Order(ganpat, getItems());

        Kitchen.INSTANCE.takeOrder(order1);
        Kitchen.INSTANCE.takeOrder(order2);
        TimeUnit.MINUTES.sleep(2);
    }

    public Set<Item> getItems() {
        Set<Item> items = new HashSet<>();
        items.add(chai);
        items.add(sutta);
        return items;
    }
}

