package ma.enset.badri.conferenceservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Keynote {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
