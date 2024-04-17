package com.meeting.jpa.controller;

import com.meeting.jpa.dto.RequestDto;
import com.meeting.jpa.entity.Employee;
import com.meeting.jpa.entity.Meeting;
import com.meeting.jpa.entity.Participants;
import com.meeting.jpa.repository.MeetingRepository;
import com.meeting.jpa.repository.EmployeeRepository;
import com.meeting.jpa.repository.ParticipantsRepository;
import com.meeting.jpa.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MeetingController {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private ParticipantsRepository participantsRepository;

   @Autowired
   private EmployeeRepository employeeRepository;

   @Autowired
   private MeetingService meetingService;

    @PostMapping("/addMeeting")
    public Meeting addMeeting(@RequestBody RequestDto request){
       return this.meetingService.addMeeting(request);
    }

    @GetMapping("/findAllmeetings")
    public List<Meeting> findAllmeetings(){

        return this.meetingService.findAllmeetings();
    }

    @GetMapping("/meeting/{meetingId}/participants")
    public ResponseEntity<List<Participants>> getParticipantsByMeetingId(@PathVariable int meetingId) {

        return new ResponseEntity<>(this.meetingService.getParticipantsByMeetingId(meetingId), HttpStatus.OK);
    }

}
