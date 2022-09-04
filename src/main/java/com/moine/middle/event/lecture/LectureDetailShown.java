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
public class LectureDetailShown {
    private List<DetailShowDto> detailShowDtoList = new ArrayList<DetailShowDto>();
    String eventType;
    Long timestamp;

    public LectureDetailShown(List<LectureDetailShow> detailShowList) {
        // super(detailShowList);
        System.out.println("detailShowList.size() = " + detailShowList.size());
        for (LectureDetailShow element: detailShowList) {
            DetailShowDto dto = new DetailShowDto(
                    element.getId(),
                    element.getUser().getUserId(),
                    element.getLectureCrawling().getLectureId(),
                    element.getCategoryName(),
                    element.getClickCount()
            );

            System.out.println("dto = " + dto);
            detailShowDtoList.add(dto);
        }

    }

    // static
    // @Builder
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DetailShowDto {
        private Long id;
        private Long userId;
        private Long lectureId;
        private String category;
        private Integer clickCount;
    }

    // @Builder
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class LectureDetailShow {
        private long id;
        private boolean isDeleted = Boolean.FALSE; // 디폴트 false
        private String categoryName;
        private Integer clickCount = 0;
        private LectureCrawling lectureCrawling;
        private User user;
    }

    // @Builder
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
