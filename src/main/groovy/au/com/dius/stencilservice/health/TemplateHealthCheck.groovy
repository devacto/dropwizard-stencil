package au.com.dius.stencilservice.health

import com.codahale.metrics.health.HealthCheck
import com.codahale.metrics.health.HealthCheck.Result
import static com.codahale.metrics.health.HealthCheck.Result.healthy
import static com.codahale.metrics.health.HealthCheck.Result.unhealthy

class TemplateHealthCheck extends HealthCheck {
    public static final String TEST = 'TEST'
    private final String template

    TemplateHealthCheck(String template) {
        this.template = template
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, TEST)
        if (!saying.contains(TEST)) {
            unhealthy('Template doesn\'t include a name!')

        }
        healthy()
    }
}
