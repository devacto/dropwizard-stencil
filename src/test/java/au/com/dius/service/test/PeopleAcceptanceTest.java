package au.com.dius.service.test;

import com.sun.jersey.api.client.ClientResponse;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PeopleAcceptanceTest extends BaseAcceptanceTest {

    @Test
    public void shouldReceivePerson() {
        ClientResponse response = webResourceBuilder("/people").get(ClientResponse.class);
        String actual = response(response);
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(actual).contains("Victor");
    }
}
