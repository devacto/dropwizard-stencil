package ac.victor.csvconsumerservice;

import ac.victor.csvconsumerservice.health.TemplateHealthCheck;
import ac.victor.csvconsumerservice.resources.CSVConsumerServiceResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CSVConsumerServiceApplication extends Application<CSVConsumerServiceConfiguration> {
    @Override
    public String getName() {
        return "AIA Consumer Service Application";
    }

    @Override
    public void initialize(Bootstrap<CSVConsumerServiceConfiguration> bootstrap) {
        // nothing to do at the moment
    }

    @Override
    public void run(CSVConsumerServiceConfiguration configuration, Environment environment) throws Exception {
        final CSVConsumerServiceResource resource = new CSVConsumerServiceResource(configuration.getTemplate(), configuration.getDefaultname());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("templateHealthCheck", healthCheck);
        environment.jersey().register(resource);
    }

    public static void main(String[] args) throws Exception {
        new CSVConsumerServiceApplication().run(args);
    }
}
