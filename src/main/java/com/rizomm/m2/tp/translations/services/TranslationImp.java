package com.rizomm.m2.tp.translations.services;

import com.rizomm.m2.tp.translations.entities.Application;
import com.rizomm.m2.tp.translations.entities.Translation;
import com.rizomm.m2.tp.translations.repositories.AppRepository;
import com.rizomm.m2.tp.translations.repositories.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TranslationImp implements TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private AppRepository appRepository;

    @Override
    public Translation createTranslation(Translation translation, Integer applicationId) {
        Optional<Application> application = appRepository.findById(applicationId);
        if (application.isPresent()) {
            translation.setApplication(application.get());
            return  translationRepository.save(translation);
        }
        return null;
    }
}
