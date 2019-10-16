package com.rizomm.m2.tp.translations.services;

import com.rizomm.m2.tp.translations.entities.Translation;

public interface TranslationService {
    Translation createTranslation(Translation translation, Integer applicationId);
}
