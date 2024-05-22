package Institution.main.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import Institution.main.enums.Status;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstitutionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long institution_id;
    private String institution_name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long max_nbr_of_users;
    private Long max_nbr_of_protocols;
    private Long max_nbr_of_channels;
    private Long max_tps;
}