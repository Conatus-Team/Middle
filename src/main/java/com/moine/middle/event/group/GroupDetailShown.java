package com.moine.middle.event.group;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDetailShown {

    Long id;
    Long userId;
    Long groupId;
    String category;
}
