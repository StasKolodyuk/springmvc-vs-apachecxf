package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller.controller.subresource;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest.ResourceRestClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller.subresource.SubresourceController;
import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Subresource;

@RunWith(SpringRunner.class)
@WebMvcTest(SubresourceController.class)
public class SubresourceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String RESOURCE_API_URL = "/resources";
    private static final String SUBRESOURCE_API_URL = "/subresources";
    private static final String TEST_RESOURCE_ID = "testResource";
    private static final String TEST_SUBRESOURCE_ID = "testSubresource";
    private static final String URL_SEPARATOR = "/";


    @Test
    public void emptySubresourceHasNotBeenFoundEmptyResource() throws Exception {
        mockMvc.perform(get(RESOURCE_API_URL + SUBRESOURCE_API_URL))
                .andExpect(request().asyncNotStarted())
                .andExpect(status().isNotFound())
                .andReturn();
    }


    @Test
    public void emptySubresourceHasNotBeenFoundEmptySubresource() throws Exception {
        mockMvc.perform(get(RESOURCE_API_URL + URL_SEPARATOR + TEST_RESOURCE_ID + SUBRESOURCE_API_URL))
                .andExpect(request().asyncNotStarted())
                .andExpect(status().isNotFound())
                .andReturn();
    }


    @Test
    public void subresourceHasBeenFound() throws Exception {
        Subresource subresource = new Subresource();
        subresource.setId(TEST_SUBRESOURCE_ID);
        subresource.setResourceId(TEST_RESOURCE_ID);

        mockMvc.perform(get(RESOURCE_API_URL + URL_SEPARATOR + TEST_RESOURCE_ID + SUBRESOURCE_API_URL + URL_SEPARATOR + TEST_SUBRESOURCE_ID))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(samePropertyValuesAs(subresource)))
                .andExpect(status().isOk())
                .andReturn();
    }
}
