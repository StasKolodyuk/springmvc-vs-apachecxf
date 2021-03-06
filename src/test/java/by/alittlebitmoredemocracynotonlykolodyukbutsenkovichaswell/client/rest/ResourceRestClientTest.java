package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ResourceRestClientConfiguration.class)
public class ResourceRestClientTest
{
    @Autowired
    private WebClient webClient;

    private ResourceRestClient resourceRestClient;

    private static final String TEST_RESOURCE_ID = "testResource";
    private static final String RESOURCE_DESCRIPTION = " resource description";
    private static final String NULL_RESOURCE_ID = "null";


    @Before
    public void init()
    {
        resourceRestClient = new ResourceRestClient(webClient);
    }


    @Test
    public void descriptionWithNullIdHasBeenReturnedNullResourceId()
    {
        String returnedDescription = resourceRestClient.getResourceDescription(null);

        assertThat("The returned description should have empty id",
                returnedDescription, is(equalTo(NULL_RESOURCE_ID + RESOURCE_DESCRIPTION)));
    }


    @Test
    public void descriptionWithEmptyIdHasBeenReturnedEmptyResourceId()
    {
        String returnedDescription = resourceRestClient.getResourceDescription("");

        assertThat("The returned description should have empty id",
                returnedDescription, is(equalTo(RESOURCE_DESCRIPTION)));
    }


    @Test
    public void descriptionWithTestIdHasBeenReturnedTestResourceId()
    {
        String returnedDescription = resourceRestClient.getResourceDescription(TEST_RESOURCE_ID);

        assertThat("The returned description should have empty id",
                returnedDescription, is(equalTo(TEST_RESOURCE_ID + RESOURCE_DESCRIPTION)));
    }
}
