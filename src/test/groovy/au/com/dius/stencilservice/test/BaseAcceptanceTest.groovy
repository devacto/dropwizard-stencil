package au.com.dius.stencilservice.test

import au.com.dius.stencilservice.StencilService
import au.com.dius.stencilservice.StencilServiceConfiguration
import com.google.common.io.CharStreams
import com.google.common.io.Resources
import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.WebResource
import io.dropwizard.testing.junit.DropwizardAppRule
import org.junit.ClassRule

class BaseAcceptanceTest {

    @ClassRule
    public static final DropwizardAppRule<StencilServiceConfiguration> RULE =
            new DropwizardAppRule<>(StencilService.class, resourceFilePath('test-config.yml'))

    protected WebResource.Builder webResourceBuilder(String path, Object... arguments) {
        Client client = new Client()
        return client.resource(String.format('http://localhost:%d%s', RULE.getLocalPort(),
                String.format(path, arguments)))
                .accept('application/json')
                .type('application/json')
    }

    private static String resourceFilePath(String resourceClassPathLocation) {
        try {
            return new File(Resources.getResource(resourceClassPathLocation).toURI()).getAbsolutePath()
        } catch (Exception e) {
            throw new RuntimeException(e)
        }
    }

    protected String response(ClientResponse response) {
        try {
            return CharStreams.toString(new InputStreamReader(response.getEntityInputStream()))
        } catch (IOException e) {
            throw new RuntimeException(e)
        }
    }
}
