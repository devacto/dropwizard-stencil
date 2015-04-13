package au.com.dius.service.resources;

import au.com.dius.service.core.People;
import au.com.dius.service.core.Person;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

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
