package com.moine.middle.event.group;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GroupCreated {
    String eventType;
    Long timestamp;

    Long groupId;
    Long userId;
    String Category;
    String name;

}
