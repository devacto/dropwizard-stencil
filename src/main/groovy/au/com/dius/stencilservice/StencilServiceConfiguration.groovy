package au.com.dius.stencilservice

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

class StencilServiceConfiguration extends Configuration {
    @NotEmpty
    private String template

    @NotEmpty
    private String defaultName = 'Stranger'

    @JsonProperty
    String getTemplate() {
        template
    }

    @JsonProperty
    void setTemplate(String template) {
        this.template = template
    }

    @JsonProperty
    String getDefaultname() {
        defaultName
    }

    @JsonProperty
    void setDefaultname(String defaultName) {
        this.defaultName = defaultName
    }
}
