package au.com.dius.stencilservice.test.acceptance

import com.sun.jersey.api.client.ClientResponse
import groovy.json.JsonSlurper
import org.junit.Test

class HelloResourceAcceptanceTest extends BaseAcceptanceTest {

    @Test
    void 'should produce correct name from query parameter'() {
        ClientResponse clientResponse = webResourceBuilder('/hello?name=Victor').get(ClientResponse)
        def actual = new JsonSlurper().parseText(response(clientResponse))
        assert clientResponse.status == 200
        assert actual.content == 'Hello, Victor!'
    }
}
