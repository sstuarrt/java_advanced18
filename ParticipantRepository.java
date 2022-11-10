package com.spring.springmvc.dao;

import com.spring.springmvc.Participant;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Repository
public class ParticipantRepository {
    private List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init() {
        Participant participant1 = new Participant();
        participant1.setName("Mark");
        participant1.setEmail("mark@gmail.com");
        participant1.setLevel(3);
        participant1.setPrimarySkill("Drawing");
        participant1.setId(1);

        Participant participant2 = new Participant();
        participant1.setName("Maria");
        participant1.setEmail("maria@gmail.com");
        participant1.setLevel(5);
        participant1.setPrimarySkill("Writing");
        participant1.setId(2);

        Participant participant3 = new Participant();
        participant1.setName("Luka");
        participant1.setEmail("luka@gmail.com");
        participant1.setLevel(1);
        participant1.setPrimarySkill("Counting");
        participant1.setId(3);

        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);
    }

    public List<Participant> findAll() {
        return participants;
    }

    public Participant findOne(Integer id) {
        return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
    }

    public void save(Participant participant) {
        Participant participantToUpdate = null;

        if (participant.getId() != null) {
            participantToUpdate = findOne(participant.getId());
            int participantIndex = participant.indexOf(participantToUpdate);
            participantToUpdate.setName(participant.getName());
            participantToUpdate.setEmail(participant.getEmail());
            participantToUpdate.setLevel(participant.getLevel());
            participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
            participants.set(participantIndex, participantToUpdate);
        } else {
            participant.setId(participants.size()+1);
            participants.add(participant);
        }
    }

    public void delete(int id) {
        Iterator<Participant> iter = participants.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId() == id) {
                iter.remove();
            }
        }
    }
}
