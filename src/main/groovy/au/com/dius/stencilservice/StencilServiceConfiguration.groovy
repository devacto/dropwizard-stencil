package au.com.dius.stencilservice

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

class StencilServiceConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    String template

    @NotEmpty
    @JsonProperty
    String defaultName = 'Stranger'

}
