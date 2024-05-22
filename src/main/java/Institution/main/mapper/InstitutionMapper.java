package Institution.main.mapper;

import Institution.main.dto.InstitutionDTO;
import Institution.main.model.Institution;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class InstitutionMapper {

    public static InstitutionDTO toDTO(Institution institution) {
        InstitutionDTO institutionDTO = new InstitutionDTO();
        BeanUtils.copyProperties(institution,institutionDTO);
        return institutionDTO;
    }

    public static Institution toEntity(InstitutionDTO dto) {
        Institution institution = new Institution();
        BeanUtils.copyProperties(dto,institution);
        return institution;
    }
}