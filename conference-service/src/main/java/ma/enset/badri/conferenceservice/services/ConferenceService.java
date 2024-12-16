package ma.enset.badri.conferenceservice.services;

import ma.enset.badri.conferenceservice.entities.Conference;
import ma.enset.badri.conferenceservice.repos.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {
    ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> getConferences() {
        return conferenceRepository.findAll();
    }

    public Conference getConferenceById(Long id) {
        return conferenceRepository.findById(id).orElse(null);
    }

    public Conference saveConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public Conference updateConference(Conference updatedConference) throws RuntimeException {
        Conference oldConference = conferenceRepository.findById(updatedConference.getId()).orElseThrow(() -> new RuntimeException("Conference not found"));

        if (updatedConference.getConferenceType() != null)
            oldConference.setConferenceType(updatedConference.getConferenceType());

        if (updatedConference.getTitre() != null)
            oldConference.setTitre(updatedConference.getTitre());

        if (updatedConference.getNbrInscrits() != null)
            oldConference.setNbrInscrits(updatedConference.getNbrInscrits());

        if (updatedConference.getDate() != null)
            oldConference.setDate(updatedConference.getDate());

        if (updatedConference.getDuree() != null)
            oldConference.setDuree(updatedConference.getDuree());

        if (updatedConference.getScore() != null)
            oldConference.setScore(updatedConference.getScore());

        return conferenceRepository.save(oldConference);
    }
}
