package au.com.dius.stencilservice

import au.com.dius.stencilservice.health.TemplateHealthCheck
import au.com.dius.stencilservice.resources.HelloResource
import groovy.util.logging.Slf4j
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

@Slf4j
class StencilService extends Application<StencilServiceConfiguration> {
    final String name = 'Stencil Service'

    @Override
    void initialize(Bootstrap<StencilServiceConfiguration> bootstrap) {
        // nothing to do at the moment
    }

    @Override
    void run(StencilServiceConfiguration configuration, Environment environment) throws Exception {
        HelloResource resource = new HelloResource(configuration.template,
                configuration.defaultName)
        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.template)
        environment.healthChecks().register('templateHealthCheck', healthCheck)
        environment.jersey().register(resource)
    }

    static void main(String[] args) throws Exception {
        new StencilService().run(args)
    }
}
