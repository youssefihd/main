package Institution.main.service;

import Institution.main.dto.InstitutionDTO;
import Institution.main.model.Institution;

public interface InstitutionService {
    public InstitutionDTO createInstitution(Institution institution);
    public void deleteInstitution(Long institutionId);
    public InstitutionDTO readInstitution(Long institutionId);
    public InstitutionDTO updateInstitution(Long institutionId, Institution institution);
}