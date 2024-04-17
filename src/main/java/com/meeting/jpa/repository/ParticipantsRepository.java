package com.meeting.jpa.repository;

import com.meeting.jpa.entity.Participants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantsRepository extends JpaRepository<Participants,Integer> {
}
