package com.rizomm.m2.tp.translations.services;

import com.rizomm.m2.tp.translations.entities.Entry;

public interface EntryService {
    Entry updateEntry (Entry entry, Integer applicationId, Integer translationId, Integer entryID);
    Entry getEntry (Integer applicationId, Integer translationId, Integer entryID);
    void deleteEntry (Integer applicationId, Integer translationId, Integer entryID);
}
