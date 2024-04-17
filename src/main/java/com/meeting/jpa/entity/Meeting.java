package com.meeting.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Meeting {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meetingId;
    private Date meetingDate;
    private Integer duration;
    private Time startTime;
    private Time endTime;
    private String topic;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
    private List<Participants> participants;

//    @OneToMany(targetEntity = Participants.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="participants_fk",referencedColumnName = "meetingId")
//    private List<Participants> participants;
}
