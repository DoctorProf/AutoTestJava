package org.example.api;

import io.restassured.http.ContentType;
import org.example.model.BaseResponse;
import org.example.model.InventoryResponse;
import org.example.model.Order;
import org.example.model.User;

import static io.restassured.RestAssured.given;

public class StoreApi {
    public InventoryResponse getInventory() {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/store/inventory")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(InventoryResponse.class);
    }
    public Order createOrder(Order order) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .body(order)
                .log().all()
                .post("/store/order")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(Order.class);
    }
    public Order getOrderById(long orderId) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/store/order/" + orderId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(Order.class);
    }
    public BaseResponse deleteOrderById(int orderId) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .delete("/store/order/" + orderId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
}
