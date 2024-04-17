package com.meeting.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Participants {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantId;
    private Time timeJoined;
    private Time timeExited;
    private Integer duration;
    private Boolean isPresent;
    private Integer assessmentScore;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @OneToOne(mappedBy = "participants",cascade = CascadeType.ALL)
    private Employee empEmailId;

//    @OneToOne
//    @JoinColumn(name = "emp_email")
//    private Employee employee;


//    @OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="employee_fk",referencedColumnName = "participantId")
//    private Employee employee;
//    @OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL)
//    private Employee employee;
}
