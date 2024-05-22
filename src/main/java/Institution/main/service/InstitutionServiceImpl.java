package Institution.main.service;

import Institution.main.dto.InstitutionDTO;
import Institution.main.exception.InstitutionNotFoundException;
import Institution.main.exception.InstitutionServiceException;
import Institution.main.mapper.InstitutionMapper;
import Institution.main.model.Institution;
import Institution.main.repo.InstitutionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional
public class InstitutionServiceImpl implements InstitutionService{
    private InstitutionRepository institutionRepository;
    private InstitutionMapper institutionMapper;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository, InstitutionMapper institutionMapper) {
        this.institutionRepository = institutionRepository;
        this.institutionMapper = institutionMapper;
    }

    @Override
    public InstitutionDTO createInstitution(Institution institution) {
        try {
            institution = institutionRepository.save(institution);

            log.info("Institution created successfully with ID: {}",institution.getInstitution_id());

            return institutionMapper.toDTO(institution);
        } catch (Exception e) {
            log.error("Error occurred while creating institution", e);
            throw new InstitutionServiceException("Failed to create institution", e);
        }
    }
    @Override
    public void deleteInstitution(Long institutionId) {
        try {
            Institution institution = institutionRepository.findById(institutionId)
                    .orElseThrow(() -> new InstitutionNotFoundException("Institution not found with ID: " + institutionId));

            institutionRepository.delete(institution);

            log.info("Institution deleted successfully with ID: {}", institutionId);
        } catch (InstitutionNotFoundException e) {
            log.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error occurred while deleting institution", e);
            throw new InstitutionServiceException("Failed to delete institution", e);
        }
    }
    @Override
    public InstitutionDTO readInstitution(Long institutionId) {
        try {
            Institution institution = institutionRepository.findById(institutionId)
                    .orElseThrow(() -> new InstitutionNotFoundException("Institution not found with ID: " + institutionId));

            log.info("Retrieved institution with ID: {}", institution.getInstitution_id());

            return institutionMapper.toDTO(institution);
        } catch (InstitutionNotFoundException e) {
            log.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error occurred while reading institution", e);
            throw new InstitutionServiceException("Failed to read institution", e);
        }
    }

    @Override
    public InstitutionDTO updateInstitution(Long institutionId, Institution institution) {
        try {
            Institution existingInstitution = institutionRepository.findById(institutionId)
                    .orElseThrow(() -> new InstitutionNotFoundException("Institution not found with ID: " + institutionId));

            existingInstitution.setInstitution_name(institution.getInstitution_name());
            existingInstitution.setStatus(institution.getStatus());
            existingInstitution.setMax_nbr_of_users(institution.getMax_nbr_of_users());
            existingInstitution.setMax_nbr_of_protocols(institution.getMax_nbr_of_protocols());
            existingInstitution.setMax_nbr_of_channels(institution.getMax_nbr_of_channels());
            existingInstitution.setMax_tps(institution.getMax_tps());

            existingInstitution = institutionRepository.save(existingInstitution);

            log.info("Institution updated successfully with ID: {}", existingInstitution.getInstitution_id());

            return institutionMapper.toDTO(existingInstitution);
        } catch (InstitutionNotFoundException e) {
            log.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error occurred while updating institution", e);
            throw new InstitutionServiceException("Failed to update institution", e);
        }
    }
}
