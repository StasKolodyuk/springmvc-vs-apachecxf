package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller.controller;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller.ResourceController;
import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Resource;

@RunWith(SpringRunner.class)
@WebMvcTest(ResourceController.class)
public class ResourceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String RESOURCE_API_URL = "/resources";
    private static final String TEST_RESOURCE_ID = "testResource";
    private static final String URL_SEPARATOR = "/";


    @Test
    public void emptyResourceHasNotBeenFound() throws Exception {
        mockMvc.perform(get(RESOURCE_API_URL))
                .andExpect(request().asyncNotStarted())
                .andExpect(status().isNotFound())
                .andReturn();
    }


    @Test
    public void resourceHasBeenFound() throws Exception {
        Resource resource = new Resource();
        resource.setId(TEST_RESOURCE_ID);

        mockMvc.perform(get(RESOURCE_API_URL + URL_SEPARATOR + TEST_RESOURCE_ID))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(samePropertyValuesAs(resource)))
                .andExpect(status().isOk())
                .andReturn();
    }
}
