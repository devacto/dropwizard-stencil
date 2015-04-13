package au.com.dius.stencilservice.resources

import au.com.dius.stencilservice.core.Saying
import com.codahale.metrics.annotation.Timed
import com.google.common.base.Optional

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong

@Path('hello')
@Produces(MediaType.APPLICATION_JSON)
class StencilServiceResource {
    private final String template
    private final String defaultName

    private final AtomicLong counter

    StencilServiceResource(String template, String defaultName) {
        this.template = template
        this.defaultName = defaultName
        this.counter = new AtomicLong()
    }

    @GET
    @Timed
    Saying sayHello(@QueryParam('name')Optional<String> name) {
        final String value = String.format(template, name | defaultName)
        new Saying(counter.incrementAndGet(), value)
    }
}
