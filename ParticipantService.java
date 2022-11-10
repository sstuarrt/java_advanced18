package com.spring.springmvc.srvice;

import com.spring.springmvc.Participant;
import com.spring.springmvc.dao.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> findAllBooks() {
        return participantRepository.findAll();
    }

    public Participant findOne(int id) {
        return participantRepository.findOne(id);
    }

    public void save(Participant participant) {
        participantRepository.save(participant);
    }

    public void delete(int id) {
        participantRepository.delete(id);
    }
}
