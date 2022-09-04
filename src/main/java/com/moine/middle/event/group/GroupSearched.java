package com.moine.middle.event.group;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupSearched {
    String eventType;
    Long timestamp;

    Long id;
    Long userId;
    String keyword;
}
