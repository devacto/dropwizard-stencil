package ac.victor.csvconsumerservice.resources;

import ac.victor.csvconsumerservice.core.People;
import ac.victor.csvconsumerservice.core.Person;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {

    People people;

    public PeopleResource(People people) {
        this.people = people;
    }

    @GET
    @Timed
    @UnitOfWork(readOnly = true, transactional = false)
    public ArrayList<Person> getPeople() {
        return people.getPersonList();
    }


}
