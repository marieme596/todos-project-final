package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sn.ept.git.seminaire.cicd.dto.TagDTO;
import sn.ept.git.seminaire.cicd.dto.vm.TagVM;
import sn.ept.git.seminaire.cicd.resources.TagResource;
import sn.ept.git.seminaire.cicd.services.impl.TagServiceImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class TagResourceStepDefinitions {
    @Autowired
    private TagServiceImpl tagService;
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private ResultActions result;

    private String tagDetails;

    @Given("I have a new tag:")
    public void iHaveANewTag(String tagData) {
        this.tagDetails = tagData;
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @When("I send a POST request to {string} with the tag details")
    public void iSendAPostRequestToWithTheTagDetails(String url) throws Exception {
        this.result = mockMvc.perform(MockMvcRequestBuilders
                        .post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tagDetails))
                .andDo(MockMvcResultHandlers.print()); // Pour déboguer la réponse
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(Integer expectedStatusCode) throws Exception {
        result.andExpect(status().is(expectedStatusCode));
    }

    @And("the response should contain the created tag details:")
    public void theResponseShouldContainTheCreatedTagDetails(String expectedTagDetails) throws Exception {

    }
//    @Autowired
//    private TagResource tagResource;
//    private TagVM tagToAdd;
//    private ResponseEntity<TagDTO> response;
//    @Given("I have a new tag:")
//    public void iHaveANewTag() {
//        tagToAdd = new TagVM();
//        tagToAdd.setName("NewTag");
//        tagToAdd.setDescription("New tag desc");
//    }
//    @When("I send a POST request to {string} with the tag details")
//    public void iSendAPOSTRequestToWithTheTagDetails() {
//        response = tagResource.create(tagToAdd);
//    }
//
//    @Then("the response status code should be {int}")
//    public void theResponseStatusCodeShouldBe() {
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//    }
//
//    @And("the response should contain the created tag details:")
//    public void theResponseShouldContainTheCreatedTagDetails() {
//        TagDTO addedTag = response.getBody();
//        assert addedTag != null;
//        assertEquals(addedTag.getName(),"NewTag" );
//        assertEquals(addedTag.getDescription(), "New tag desc");
//    }


}
