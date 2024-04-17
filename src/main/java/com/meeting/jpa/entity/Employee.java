package com.meeting.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class  Employee {

    @Id
    private String email;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String projectCode;
    private String projectLocation;

    @OneToOne
    @JoinColumn(name = "participants_Id")
    private Participants participants;

}
