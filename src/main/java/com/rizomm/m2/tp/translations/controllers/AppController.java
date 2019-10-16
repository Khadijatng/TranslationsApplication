package com.rizomm.m2.tp.translations.controllers;

import com.rizomm.m2.tp.translations.entities.Application;
import com.rizomm.m2.tp.translations.entities.Entry;
import com.rizomm.m2.tp.translations.entities.Translation;
import com.rizomm.m2.tp.translations.services.AppService;
import com.rizomm.m2.tp.translations.services.EntryService;
import com.rizomm.m2.tp.translations.services.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/applications")

public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private EntryService entryService;

    @PostMapping
    public ResponseEntity createApplication (@RequestBody @Valid Application application){
        return new ResponseEntity<>(appService.createApplication(application), HttpStatus.CREATED);
    }

    @PostMapping(path = "/{id}/translations")
    public ResponseEntity createTranslation(@PathVariable Integer id, @RequestBody @Valid Translation translation) {
        Translation translation1 = translationService.createTranslation(translation, id);
        if(translation1 != null) {
            return new ResponseEntity<>(translation1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{appId}/translations/{transId}/entries/{entId}")
    public ResponseEntity updateEntry(@PathVariable Integer appId, @PathVariable Integer transId, @PathVariable Integer entId, @RequestBody @Valid Entry entry) {
        Entry entry1 = entryService.updateEntry(entry, appId, transId, entId);
        if(entry1 != null) {
            return ResponseEntity.ok(entry1);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/{appId}/translations/{transId}/entries/{entId}")
    public ResponseEntity getEntry(@PathVariable Integer appId, @PathVariable Integer transId, @PathVariable Integer entId) {
        Entry entry = entryService.getEntry(appId, transId, entId);
        if (entry != null) {
            return ResponseEntity.ok(entry);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{appId}/translations/{transId}/entries/{entId}")
    public ResponseEntity deleteEntity(@PathVariable Integer appId, @PathVariable Integer transId, @PathVariable Integer entId)
    {
        entryService.deleteEntry(appId, transId, entId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
