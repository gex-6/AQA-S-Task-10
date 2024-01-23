package org.example.TrelloRest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = false, chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDTO {

    String id;
    String cardName;
    String description;
    String comment;
    String listId;
}
