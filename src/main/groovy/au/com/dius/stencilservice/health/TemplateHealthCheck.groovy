package au.com.dius.stencilservice.health;

import com.codahale.metrics.health.HealthCheck
import com.codahale.metrics.health.HealthCheck.Result
import static com.codahale.metrics.health.HealthCheck.Result.*

public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return unhealthy("Template doesn't include a name!");

        }
        return healthy();
    }
}
