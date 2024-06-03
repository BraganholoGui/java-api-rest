package br.com.api.model.validations;

import br.com.api.model.repository.MedicoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoExistsValidator implements ConstraintValidator<MedicoExists, Long> {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void initialize(MedicoExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long medico_id, ConstraintValidatorContext context) {
        if (medico_id == null) {
            return false;
        }
        return medicoRepository.existsById(medico_id);
    }
}
