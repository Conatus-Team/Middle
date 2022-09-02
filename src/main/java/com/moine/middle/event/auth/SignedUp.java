package com.moine.middle.event.auth;


import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignedUp {
    String eventType;
    Long timestamp;

    Long userId;
    String email;
    String password;
    String userName;
    String userNickname;
}
