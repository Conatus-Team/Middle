package com.moine.middle.event.group;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostAccessCounted {
    private Long id;
    private Long groupId;
    private Long userId;
    private Integer postAccessCount;
}
