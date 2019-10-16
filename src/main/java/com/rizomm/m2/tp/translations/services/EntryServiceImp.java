package com.rizomm.m2.tp.translations.services;

import com.rizomm.m2.tp.translations.entities.Application;
import com.rizomm.m2.tp.translations.entities.Entry;
import com.rizomm.m2.tp.translations.entities.Translation;
import com.rizomm.m2.tp.translations.repositories.AppRepository;
import com.rizomm.m2.tp.translations.repositories.EntryRepository;
import com.rizomm.m2.tp.translations.repositories.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EntryServiceImp implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public Entry updateEntry(Entry entry, Integer applicationId, Integer translationId, Integer entryId) {
        Optional<Application> application = appRepository.findById(applicationId);
        if(application.isPresent())
        {
            Optional<Translation> translation = translationRepository.findById(translationId);
            if (translation.isPresent()) {
                Optional<Entry> entry1 = entryRepository.findById(entryId);
                if (entry1.isPresent()) {
                    entry.setTranslation(translation.get());
                    entry.setId(entryId);
                    return entryRepository.save(entry);
                }
            }
        }
        return null;
    }

    @Override
    public Entry getEntry(Integer applicationId, Integer translationId, Integer entryId) {
        Optional<Application> application = appRepository.findById(applicationId);
        if(application.isPresent()) {
            Optional<Translation> translation = translationRepository.findById(translationId);
            if (translation.isPresent()) {
                Optional<Entry> entry = entryRepository.findById(entryId);
                if (entry.isPresent()) {
                    return entry.get();
                }
            }
        }
        return null;
    }

    @Override
    public void deleteEntry(Integer applicationId, Integer translationId, Integer entryId) {
        Entry entry = getEntry(applicationId, translationId, entryId);
        if(entry != null)
        {
            entryRepository.deleteById(entryId);
        }
    }
}
