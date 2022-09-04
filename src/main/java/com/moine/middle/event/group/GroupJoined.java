package com.moine.middle.event.group;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GroupJoined {
    String eventType;
    Long timestamp;

    Member member;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class Member {
        LocalDateTime createdTime;
        LocalDateTime updatedTime;
        Long id;
        Boolean isDeleted = Boolean.FALSE;
        Long userId;
        String nickname;
        Boolean isLeader = Boolean.FALSE;
        Long groupId;
    }
}
