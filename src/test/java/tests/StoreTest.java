package tests;

import org.example.model.BaseResponse;
import org.example.model.InventoryResponse;
import org.example.model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class StoreTest extends BaseTest{
    @Test(priority = 1)
    public void getInventoryTest() {
        InventoryResponse model = STORE_API.getInventory();
        Assert.assertEquals(model.equals(model), true);
    }
    @Test (priority = 2)
    public void createOrderTest() {
        Order order = new Order(1, 1, 5, new Date(), "placed", true);
        Order model = STORE_API.createOrder(order);
        Assert.assertEquals(model.getId(), 1);
    }
    @Test(priority = 3)
    public void getOrderByIdTest() {
        Order model = STORE_API.getOrderById(1);
        Assert.assertEquals(model.getId(), 1);
    }
    @Test(priority = 4)
    public void deleteOrderByIdTest() {
        BaseResponse model = STORE_API.deleteOrderById(1);
        Assert.assertEquals(model.getCode(), "200");
    }
}
