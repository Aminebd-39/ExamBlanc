package ma.enset.badri.conferenceservice.controllers;

import ma.enset.badri.conferenceservice.entities.Conference;
import ma.enset.badri.conferenceservice.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences/")
@CrossOrigin("*")
public class ConferenceRestController {
    ConferenceService conferenceService;
    @Autowired
    public ConferenceRestController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping()
    public ResponseEntity<List<Conference>> getConferences() {
        return ResponseEntity.ok(conferenceService.getConferences());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferences(@PathVariable Long id) {
        return ResponseEntity.ok(conferenceService.getConferenceById(id));
    }

    @PostMapping("")
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        return ResponseEntity.ok(conferenceService.saveConference(conference));
    }

    @PutMapping("")
    public ResponseEntity<Conference> updateConference(@RequestBody Conference conference) {
        return ResponseEntity.ok(conferenceService.updateConference(conference));
    }
}
