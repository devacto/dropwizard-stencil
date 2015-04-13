package au.com.dius.service;

import au.com.dius.service.core.People;
import au.com.dius.service.health.TemplateHealthCheck;
import au.com.dius.service.resources.CSVConsumerServiceResource;
import au.com.dius.service.resources.PeopleResource;
import au.com.dius.service.utils.CSVParser;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class StencilService extends Application<CSVConsumerServiceConfiguration> {

    @Override
    public String getName() {
        return "Stencil Service";
    }

    @Override
    public void initialize(Bootstrap<CSVConsumerServiceConfiguration> bootstrap) {
        // nothing to do at the moment
    }

    @Override
    public void run(CSVConsumerServiceConfiguration configuration, Environment environment) throws Exception {

        People people = new People();
        CSVParser csvParser = new CSVParser();
        csvParser.parseCSVToPeople("incoming/20140703.csv", people);
        final PeopleResource peopleResource = new PeopleResource(people);

        final CSVConsumerServiceResource resource = new CSVConsumerServiceResource(configuration.getTemplate(), configuration.getDefaultname());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("templateHealthCheck", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(peopleResource);
    }

    public static void main(String[] args) throws Exception {
        new StencilService().run(args);
    }

}
