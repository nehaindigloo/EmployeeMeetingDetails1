package com.meeting.jpa.dto;

import com.meeting.jpa.entity.Meeting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestDto {

    private Meeting meeting;
}
