package com.moine.middle.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moine.middle.domain.Url;
import com.moine.middle.event.auth.SignedUp;
import com.moine.middle.event.group.GroupDetailShown;
import com.moine.middle.event.group.GroupJoined;
import com.moine.middle.event.group.GroupSearched;
import com.moine.middle.event.group.PostAccessCounted;
import com.moine.middle.event.lecture.LectureDetailShown;
import com.moine.middle.event.lecture.LectureLiked;
import com.moine.middle.event.lecture.LectureSearched;
import com.moine.middle.service.MiddleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/middle")
public class MiddleController {
    private final MiddleService middleService;

    // PUBLISHER : AUTH
    // CONSUMER : LECTURE, GROUP, CHATTING, RECOMMEND
    @PostMapping("/SignedUp")
    public String sendSignedUp(@RequestBody SignedUp signedUp) throws JsonProcessingException {
//        {eventType=SignedUp, timestamp=1662031796711, userId=20, email=ddgf55@gmail.com, password=385, userName=co, userNickname=co}
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(signedUp);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");

        middleService.sendTo(Url.GROUP.getUrl()+"/SignedUp", signedUp);
        middleService.sendTo(Url.LECTURE.getUrl()+"/SignedUp", signedUp);
        middleService.sendTo(Url.CHATTING.getUrl()+"/SignedUp", signedUp);
        middleService.sendTo(Url.RECOMMEND.getUrl()+"/SignedUp", signedUp);

        return "SignedUp Success";
    }


    // PUBLISHER : GROUP
    // CONSUMER : CHATTING, RECOMMEND */
    @PostMapping("/GroupJoined")
    public String sendGroupJoined(@RequestBody GroupJoined groupJoined) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(groupJoined);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");
        middleService.sendTo(Url.CHATTING.getUrl()+"/GroupJoined", groupJoined);
//        middleService.sendTo(Url.RECOMMEND.getUrl()+"/GroupJoined", groupJoined);

        return "GroupJoined Success";
    }



    // PUBLISHER : GROUP
    // CONSUMER : RECOMMEND
    @PostMapping("/GroupSearched")
    public String sendGroupSearched(@RequestBody GroupSearched groupSearched) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(groupSearched);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");
//        middleService.sendTo(Url.RECOMMEND.getUrl()+"/GroupSearched", groupSearched);

        return "GroupSearched Success";
    }

    // PUBLISHER : GROUP
    // CONSUMER : RECOMMEND
    @PostMapping("/GroupDetailShown")
    public String sendGroupDetailShown(@RequestBody GroupDetailShown groupDetailShown) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(groupDetailShown);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");
//        middleService.sendTo(Url.RECOMMEND.getUrl()+"/GroupDetailShown", groupDetailShown);

        return "GroupDetailShown Success";
    }

    // PUBLISHER : GROUP
    // CONSUMER : RECOMMEND
    @PostMapping("/PostAccessCounted")
    public String sendPostAccessCounted(@RequestBody PostAccessCounted postAccessCounted) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(postAccessCounted);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");
//        middleService.sendTo(Url.RECOMMEND.getUrl()+"/PostAccessCounted", postAccessCounted);

        return "PostAccessCounted Success";
    }


    // PUBLISHER : LECTURE
    // CONSUMER : RECOMMEND
    @PostMapping("/LectureDetailShown")
    public String sendLectureDetailShown(@RequestBody LectureDetailShown lectureDetailShown) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(lectureDetailShown);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");
//        middleService.sendTo(Url.RECOMMEND.getUrl()+"/PostAccessCounted", postAccessCounted);

        return "LectureDetailShown Success";
    }

    // PUBLISHER : LECTURE
    // CONSUMER : RECOMMEND
    @PostMapping("/LectureLiked")
    public String sendLectureLiked(@RequestBody LectureLiked lectureLiked) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(lectureLiked);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");
//        middleService.sendTo(Url.RECOMMEND.getUrl()+"/PostAccessCounted", postAccessCounted);

        return "LectureLiked Success";
    }

    // PUBLISHER : LECTURE
    // CONSUMER : RECOMMEND
    @PostMapping("/LectureSearched")
    public String sendLectureSearched(@RequestBody LectureSearched lectureSearched) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(lectureSearched);
        System.out.println("object" + object);
        System.out.println("==========================================");
        System.out.println("==========================================");
//        middleService.sendTo(Url.RECOMMEND.getUrl()+"/PostAccessCounted", postAccessCounted);

        return "LectureSearched Success";
    }




}
