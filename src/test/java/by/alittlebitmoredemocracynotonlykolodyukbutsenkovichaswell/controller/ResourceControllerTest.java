package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Resource;

@RunWith(SpringRunner.class)
public class ResourceControllerTest {
    private ResourceController resourceController = new ResourceController();

    private static final String TEST_RESOURCE_ID = "testResourceId";


    @Test
    public void invalidResourceIsReturnedResourceIdIsNull()
    {
        Resource returnedResource = resourceController.getResource(null);

        assertThat("Resource id should be null", returnedResource.getId(), is(nullValue()));
    }


    @Test
    public void invalidResourceIsReturnedResourceIdIsEmpty()
    {
        Resource returnedResource = resourceController.getResource("");

        assertThat("Resource id should be null", returnedResource.getId(), is(isEmptyString()));
    }


    @Test
    public void validResourceIsReturned()
    {
        Resource returnedResource = resourceController.getResource(TEST_RESOURCE_ID);

        assertThat("Resource id should be equals to the test one", returnedResource.getId(), is(equalTo(TEST_RESOURCE_ID)));
    }
}
