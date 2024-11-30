package org.example.api;

public interface Api {
    PetApi PET_API = new PetApi();
    StoreApi STORE_API = new StoreApi();
    UserApi USER_API = new UserApi();
}
