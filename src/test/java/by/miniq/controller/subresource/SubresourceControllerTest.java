package by.miniq.controller.subresource;

import by.miniq.model.Subresource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
public class SubresourceControllerTest {
    private SubresourceController subresourceController = new SubresourceController();

    private static final String TEST_RESOURCE_ID = "testResourceId";
    private static final String TEST_SUBRESOURCE_ID = "testSubresourceId";


    @Test
    public void invalidSubresourceIsReturnedSubresourceIdIsNullResourceIdIsNull()
    {
        Subresource returnedSubresource = subresourceController.getSubresource(null, null);

        assertThat("Subresource id should be null", returnedSubresource.getId(), is(nullValue()));
        assertThat("Resource id should be null", returnedSubresource.getResourceId(), is(nullValue()));
    }


    @Test
    public void invalidSubresourceIsReturnedSubresourceIdIsEmptyResourceIdIsNull()
    {
        Subresource returnedSubresource = subresourceController.getSubresource(null, "");

        assertThat("Subresource id should be empty string", returnedSubresource.getId(), is(isEmptyString()));
        assertThat("Resource id should be null", returnedSubresource.getResourceId(), is(nullValue()));
    }


    @Test
    public void invalidSubresourceIsReturnedSubresourceIdIsNullResourceIdIsEmpty()
    {
        Subresource returnedSubresource = subresourceController.getSubresource("", null);

        assertThat("Subresource id should be null", returnedSubresource.getId(), is(nullValue()));
        assertThat("Resource id should be empty string", returnedSubresource.getResourceId(), is(isEmptyString()));
    }


    @Test
    public void invalidSubresourceIsReturnedSubresourceIdIsEmptyResourceIdIsEmpty()
    {
        Subresource returnedSubresource = subresourceController.getSubresource("", "");

        assertThat("Subresource id should be empty string", returnedSubresource.getId(), is(isEmptyString()));
        assertThat("Resource id should be empty string", returnedSubresource.getResourceId(), is(isEmptyString()));
    }


    @Test
    public void invalidSubresourceIsReturnedSubresourceIdIsNullResourceIdIsValid()
    {
        Subresource returnedSubresource = subresourceController.getSubresource(TEST_RESOURCE_ID, null);

        assertThat("Subresource id should be empty string", returnedSubresource.getId(), is(nullValue()));
        assertThat("Resource id should be equal to the test one", returnedSubresource.getResourceId(), is(equalTo(TEST_RESOURCE_ID)));
    }


    @Test
    public void invalidSubresourceIsReturnedSubresourceIdIsEmptyResourceIdIsValid()
    {
        Subresource returnedSubresource = subresourceController.getSubresource(TEST_RESOURCE_ID, "");

        assertThat("Subresource id should be empty string", returnedSubresource.getId(), is(isEmptyString()));
        assertThat("Resource id should be equal to the test one", returnedSubresource.getResourceId(), is(equalTo(TEST_RESOURCE_ID)));
    }


    @Test
    public void validSubresourceIsReturnedSubresourceIdIsTestResourceIdIsNull()
    {
        Subresource returnedSubresource = subresourceController.getSubresource(null, TEST_SUBRESOURCE_ID);

        assertThat("Subresource id should be equal to the test one", returnedSubresource.getId(), is(equalTo(TEST_SUBRESOURCE_ID)));
        assertThat("Resource id should be null", returnedSubresource.getResourceId(), is(nullValue()));
    }


    @Test
    public void validSubresourceIsReturnedSubresourceIdIsTestResourceIdIsEmpty()
    {
        Subresource returnedSubresource = subresourceController.getSubresource("", TEST_SUBRESOURCE_ID);

        assertThat("Subresource id should be equal to the test one", returnedSubresource.getId(), is(equalTo(TEST_SUBRESOURCE_ID)));
        assertThat("Resource id should be empty string", returnedSubresource.getResourceId(), is(isEmptyString()));
    }


    @Test
    public void validSubresourceIsReturnedSubresourceIdIsTestResourceIdIsTest()
    {
        Subresource returnedSubresource = subresourceController.getSubresource(TEST_RESOURCE_ID, TEST_SUBRESOURCE_ID);

        assertThat("Subresource id should be equal to the test one", returnedSubresource.getId(), is(equalTo(TEST_SUBRESOURCE_ID)));
        assertThat("Resource id should be equal to the test one", returnedSubresource.getResourceId(), is(equalTo(TEST_RESOURCE_ID)));
    }
}
