package Institution.main.model;
import Institution.main.enums.Status;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Data @Entity @AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter

public class Institution {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long institution_id;
    private String creation_user;
    private LocalDate creation_date;
    private String last_modif_user;
    private LocalDate last_modif_date;
    private String institution_name;
    @Enumerated(EnumType.STRING)
    private Status Status;
    private Long max_nbr_of_users;
    private Long max_nbr_of_protocols;
    private Long max_nbr_of_channels;
    private Long max_tps;
}