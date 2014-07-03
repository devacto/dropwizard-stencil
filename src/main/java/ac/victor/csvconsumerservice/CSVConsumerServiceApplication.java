package ac.victor.csvconsumerservice;

import ac.victor.csvconsumerservice.core.People;
import ac.victor.csvconsumerservice.health.TemplateHealthCheck;
import ac.victor.csvconsumerservice.resources.CSVConsumerServiceResource;
import ac.victor.csvconsumerservice.resources.PeopleResource;
import ac.victor.csvconsumerservice.utils.CSVParser;
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
        new CSVConsumerServiceApplication().run(args);
    }

}
