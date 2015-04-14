package au.com.dius.stencilservice.core

import com.fasterxml.jackson.annotation.JsonProperty

class Saying {
    @JsonProperty
    private final long id

    @JsonProperty
    private final String content

    Saying(long id, String content) {
        this.id = id
        this.content = content
    }
}
