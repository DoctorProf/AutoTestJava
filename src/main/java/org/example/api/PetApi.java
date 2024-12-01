package org.example.api;

import io.restassured.http.ContentType;
import org.example.model.BaseResponse;
import org.example.model.User;
import org.example.model.pet.Pet;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {

    public BaseResponse uploadImageToPet(long petId, String additionalMetadata, File file) {
        return given().
                contentType(ContentType.MULTIPART)
                .baseUri("https://petstore.swagger.io/v2")
                .multiPart("additionalMetadata", additionalMetadata)
                .multiPart("file", file)
                .when()
                .log().all()
                .post("/pet/" + petId + "/uploadImage")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
    public Pet createPet(Pet pet) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .body(pet)
                .log().all()
                .post("/pet")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(Pet.class);
    }
    public Pet updatePet(Pet pet) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .body(pet)
                .log().all()
                .put("/pet")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(Pet.class);
    }
    public List<Pet> findByStatus(String status) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .queryParam("status", status)
                .when()
                .log().all()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().jsonPath().getList("", Pet.class);
    }
    public Pet getPetById(int petId) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .log().all()
                .get("/pet/" + petId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(Pet.class);
    }
    public BaseResponse updatePetById(int petId, String name, String status) {
        return given().
                contentType(ContentType.URLENC)
                .baseUri("https://petstore.swagger.io/v2")
                .formParam("name", name)
                .formParam("status", status)
                .when()
                .log().all()
                .post("/pet/" + petId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
    public BaseResponse deletePetById(long petId, String apiKey) {
        return given().
                contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .header("api_key", apiKey)
                .when()
                .log().all()
                .delete("/pet/" + petId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(BaseResponse.class);
    }
}
