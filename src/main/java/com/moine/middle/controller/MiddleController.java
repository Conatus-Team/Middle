package com.moine.middle.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moine.middle.event.auth.SignedUp;
import com.moine.middle.event.group.GroupDetailShown;
import com.moine.middle.event.group.GroupJoined;
import com.moine.middle.event.group.GroupSearched;
import com.moine.middle.event.group.PostAccessCounted;
import com.moine.middle.service.MiddleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/middle")
public class MiddleController {
    private final MiddleService middleService;

    private static final String LOCAL_URL = "http://localhost:";
    private static final String RELEASE_URL = "";

    private static final String AUTH = LOCAL_URL + "8082" + "/auth/connect_middle";
    private static final String LECTURE = LOCAL_URL + "8084" + "/lecture/connect_middle";
    private static final String GROUP = LOCAL_URL + "8083" + "/group/connect_middle";
    private static final String CHATTING = LOCAL_URL +  "8085"+ "/chatting/connect_middle";
    private static final String RECOMMEND = LOCAL_URL + "8086" + "/recommend/connect_middle";
    private static final String FRONT = "";

    // PUBLISHER : AUTH
    // CONSUMER : LECTURE, GROUP, CHATTING, RECOMMEND
    @PostMapping("/SignedUp")
    public String sendSignedUp(@RequestBody SignedUp signedUp) {
//        {eventType=SignedUp, timestamp=1662031796711, userId=20, email=ddgf55@gmail.com, password=385, userName=co, userNickname=co}

        middleService.sendTo(GROUP+"/SignedUp", signedUp);
//        middleService.sendTo(LECTURE+"/SignedUp", signedUp);
//        middleService.sendTo(CHATTING+"/SignedUp", signedUp);
//        middleService.sendTo(RECOMMEND+"/SignedUp", signedUp);

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
//        middleService.sendTo(CHATTING+"/GroupJoined", groupJoined);
//        middleService.sendTo(RECOMMEND+"/GroupJoined", groupJoined);

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
//        middleService.sendTo(RECOMMEND+"/GroupSearched", groupSearched);

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
//        middleService.sendTo(RECOMMEND+"/GroupDetailShown", groupDetailShown);

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
//        middleService.sendTo(RECOMMEND+"/PostAccessCounted", postAccessCounted);

        return "PostAccessCounted Success";
    }








}
