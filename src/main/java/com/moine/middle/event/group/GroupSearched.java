package com.moine.middle.event.group;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupSearched {
    Long id;
    Long userId;
    String keyword;
}
