package au.com.ioof.retailinsurance.aiaconsumerservice;

import au.com.ioof.retailinsurance.aiaconsumerservice.health.TemplateHealthCheck;
import au.com.ioof.retailinsurance.aiaconsumerservice.resources.AIAConsumerServiceResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AIAConsumerServiceApplication extends Application<AIAConsumerServiceConfiguration> {
    @Override
    public String getName() {
        return "AIA Consumer Service Application";
    }

    @Override
    public void initialize(Bootstrap<AIAConsumerServiceConfiguration> bootstrap) {
        // nothing to do at the moment
    }

    @Override
    public void run(AIAConsumerServiceConfiguration configuration, Environment environment) throws Exception {
        final AIAConsumerServiceResource resource = new AIAConsumerServiceResource(configuration.getTemplate(), configuration.getDefaultname());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("templateHealthCheck", healthCheck);
        environment.jersey().register(resource);
    }


    public static void main(String[] args) throws Exception {
        new AIAConsumerServiceApplication().run(args);
    }
}
