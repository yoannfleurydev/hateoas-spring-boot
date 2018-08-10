package io.github.yoannfleurydev.hateoasspringboot.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactResource extends ResourceSupport {
    @JsonProperty("id")
    private String resourceId;

    private String firstName;

    private String lastName;
}
