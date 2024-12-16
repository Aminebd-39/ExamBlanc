package ma.enset.badri.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.badri.conferenceservice.model.ConferenceType;
import ma.enset.badri.conferenceservice.model.Keynote;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private ConferenceType conferenceType;
    private Date date;
    private Long duree;
    private Integer nbrInscrits;
    private Integer score;
    @Transient
    private List<Keynote> keynotes;
}
