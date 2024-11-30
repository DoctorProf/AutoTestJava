package org.example.api;

import io.restassured.http.ContentType;
import org.example.model.BaseResponse;
import org.example.model.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserApi {
    public User getUserByUserName(String userName) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/user/" + userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(User.class);
    }
    public BaseResponse createUser(User user) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .body(user)
                .when()
                .log().all()
                .post("/user")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
    public BaseResponse updateUser(User user) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .body(user)
                .when()
                .log().all()
                .put("/user/" + user.getUsername())
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
    public BaseResponse deleteUser(String username) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .delete("/user/" + username)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
    public BaseResponse loginUser(String username, String password) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/user/login?username=" + username + "&password=" + password)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
    public BaseResponse logoutUser() {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/user/logout")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
    public BaseResponse createListUsers(List<User> users) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .body(users)
                .log().all()
                .post("/user/createWithList")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
}
