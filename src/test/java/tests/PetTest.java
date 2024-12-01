package tests;

import org.example.model.BaseResponse;
import org.example.model.pet.Category;
import org.example.model.pet.Pet;
import org.example.model.pet.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PetTest extends BaseTest {

    @Test(priority = 1)
    public void createPetTest() {
        Tag tag = new Tag(1, "bob");
        Category category = new Category(1, "bob");
        List<String> photoUrs = new ArrayList<>();
        photoUrs.add("src/main/bob.png");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        Pet pet = new Pet(1, category, "bob", photoUrs, tags, "sold");
        Pet model = PET_API.createPet(pet);
        Assert.assertEquals(model.getId(), 1);
    }
    @Test(priority = 2)
    public void updatePetTest() {
        Tag tag = new Tag(1, "bob");
        Category category = new Category(1, "bob");
        List<String> photoUrs = new ArrayList<>();
        photoUrs.add("src/main/bob.png");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        Pet pet = new Pet(1, category, "bob", photoUrs, tags, "sold");
        Pet model = PET_API.updatePet(pet);
        Assert.assertEquals(model.getId(), 1);
    }
    @Test(priority = 3)
    public void uploadImageToPetTest() {
        BaseResponse model = PET_API.uploadImageToPet(1, "bobs", new File("src/main/resources/bob.png"));
        Assert.assertEquals(model.getCode(), "200");
    }
    @Test(priority = 4)
    public void findPetByStatusTest() {
        List<Pet> model = PET_API.findByStatus("sold");
        Assert.assertEquals(model.size(), model.size());
    }
    @Test(priority = 5)
    public void getPetByIdTest() {
        Pet model = PET_API.getPetById(1);
        Assert.assertEquals(model.getId(), 1);
    }
    @Test(priority = 6)
    public void updatePetByIdTest() {
        BaseResponse model = PET_API.updatePetById(1, "bobs", "pending");
        Assert.assertEquals(model.getCode(), "200");
    }
    @Test(priority = 7)
    public void deletePetByIdTest() {
        BaseResponse model = PET_API.deletePetById(1, "special-key");
        Assert.assertEquals(model.getCode(), "200");
    }
}
