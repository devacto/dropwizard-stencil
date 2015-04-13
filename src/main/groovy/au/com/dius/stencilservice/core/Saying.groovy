package au.com.dius.stencilservice.core

import org.hibernate.validator.constraints.Length

class Saying {
    private final long id

    @Length(max = 3)
    private final String content

    Saying(long id, String content) {
        this.id = id
        this.content = content
    }
}
