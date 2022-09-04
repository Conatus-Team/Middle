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
public class LectureSearched {
    String eventType;
    Long timestamp;

    private List<SearchDto> searchDtoList = new ArrayList<SearchDto>();

    public LectureSearched(List<LectureSearch> searchList) {
//        super(searchList);
        for (LectureSearch element : searchList) {
            SearchDto dto = new SearchDto(
                    element.getId(),
                    element.getUser().getUserId(),
                    element.getKeyword()
            );

            searchDtoList.add(dto);
        }
    }

    // static
    // @Builder
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SearchDto {
        private Long id;
        private Long userId;
        private String keyword;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class LectureSearch {
        private long id;
        private boolean isDeleted = Boolean.FALSE; // 디폴트 false
        private String keyword;
        private User user;
    }

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
