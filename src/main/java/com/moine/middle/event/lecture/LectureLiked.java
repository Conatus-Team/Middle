package com.moine.middle.event.lecture;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureLiked {

    private List<LikeDto> likeDtoList = new ArrayList<LikeDto>();
    String eventType;
    Long timestamp;

    public LectureLiked(List<LectureLike> likeList) {
//        super(likeList);
        for (LectureLike element : likeList) {
            LikeDto dto = new LikeDto(
                    element.getId(),
                    element.getUser().getUserId(),
                    element.getLectureCrawling().getLectureId(),
                    element.getCategoryName()
            );

            likeDtoList.add(dto);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
//    @Builder
    public static class LikeDto {
        private Long id;
        private Long userId;
        private Long lectureId;
        private String category;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
//    @Builder
    public class LectureLike {
        private long id;
        private boolean isDeleted = Boolean.FALSE; // 디폴트 false
        private LectureCrawling lectureCrawling;
        private String categoryName;
        private User user;

    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class LectureCrawling {
        private long lectureId;
        private boolean isDeleted = Boolean.FALSE; // 디폴트 false
        private String lectureUrl;
        private String imagePath;
        private String siteName;
        private String lectureName;
        private String teacherName;
        private String price;
        private String introduction;
        private String amount;
        private String curriculum;
        private String categoryName;
        private Integer originLikeCount = 0;
        private Integer userLikeCount = 0;

    }

    // @Builder
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class User {
        private Long userId;
        private boolean isDeleted = Boolean.FALSE; // 디폴트 false
        private String userName;
        private String userNickname;
        private String email;
    }


}
