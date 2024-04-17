package com.meeting.jpa.service;

import com.meeting.jpa.dto.RequestDto;
import com.meeting.jpa.entity.Employee;
import com.meeting.jpa.entity.Meeting;
import com.meeting.jpa.entity.Participants;
import com.meeting.jpa.repository.EmployeeRepository;
import com.meeting.jpa.repository.MeetingRepository;
import com.meeting.jpa.repository.ParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private ParticipantsRepository participantsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public Meeting addMeeting( RequestDto request){


        Meeting meeting=new Meeting();
        meeting.setMeetingId(request.getMeeting().getMeetingId());
        meeting.setDuration(request.getMeeting().getDuration());
        meeting.setMeetingDate(request.getMeeting().getMeetingDate());
        meeting.setTopic(request.getMeeting().getTopic());
        meeting.setStartTime(request.getMeeting().getStartTime());
        meeting.setEndTime(request.getMeeting().getEndTime());

        meetingRepository.save(meeting);

        List<Participants> participants=request.getMeeting().getParticipants();

        //List<Participants> participants1=new ArrayList<>();

        for(int i=0;i<participants.size();i++)
        {
            Participants participants1=new Participants();
            Participants participants2=participants.get(i);
            participants1.setMeeting(meeting);
            participants1.setDuration(participants2.getDuration());
            participants1.setParticipantId(participants2.getParticipantId());
            participants1.setIsPresent(participants2.getIsPresent());
            participants1.setAssessmentScore(participants2.getAssessmentScore());
            participants1.setTimeJoined(participants2.getTimeJoined());
            participants1.setTimeExited(participants2.getTimeJoined());

            participantsRepository.save(participants1);
            Employee employee=participants2.getEmpEmailId();
            participants.get(i).setMeeting(meeting);

            Employee employee1=new Employee();
            employee1.setEmployeeId(employee.getEmployeeId());
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmail(employee.getEmail());
            employee1.setProjectCode(employee.getProjectCode());
            employee1.setProjectLocation(employee.getProjectLocation());
            System.out.println(participants2);
            employee1.setParticipants(participants2);
            employeeRepository.save(employee1);

        }

        return meeting;
    }

    public List<Meeting> findAllmeetings(){
        List<Meeting> allmeeting=meetingRepository.findAll();
        List<Meeting> meetingList=new ArrayList<>();
        for(int i=0;i<allmeeting.size();i++){
            Meeting meeting=new Meeting();
            Meeting meeting1=allmeeting.get(i);
            meeting.setMeetingId(meeting1.getMeetingId());
            meeting.setDuration(meeting1.getDuration());
            meeting.setMeetingDate(meeting1.getMeetingDate());
            meeting.setTopic(meeting1.getTopic());
            meeting.setStartTime(meeting1.getStartTime());
            meeting.setEndTime(meeting1.getEndTime());
            meetingList.add(meeting);
        }
        return meetingList;
    }



    public List<Participants> getParticipantsByMeetingId(@PathVariable int meetingId) {
        Optional<Meeting> meeting = meetingRepository.findById(meetingId);
        Meeting meetingObj=meeting.get();



        List<Participants> participants=meetingObj.getParticipants();
        System.out.println(participants.size());

        List<Participants> participants4=new ArrayList<>();
        for(int i=0;i<participants.size();i++)
        {

            Participants participants1=new Participants();
            Participants participants2=participants.get(i);


            participants1.setDuration(participants2.getDuration());
            participants1.setParticipantId(participants2.getParticipantId());
            participants1.setIsPresent(participants2.getIsPresent());
            participants1.setAssessmentScore(participants2.getAssessmentScore());
            participants1.setTimeJoined(participants2.getTimeJoined());
            participants1.setTimeExited(participants2.getTimeJoined());

            Employee employee=participants2.getEmpEmailId();
            Employee employee1=new Employee();
            employee1.setEmployeeId(employee.getEmployeeId());
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmail(employee.getEmail());
            employee1.setProjectCode(employee.getProjectCode());
            employee1.setProjectLocation(employee.getProjectLocation());
            participants1.setEmpEmailId(employee1);

            participants4.add(participants1);

        }


        // System.out.println(participants);
        if(participants.isEmpty())
        {
            System.out.println("participantlist is Empty");
        }
        return participants4;
    }


}
