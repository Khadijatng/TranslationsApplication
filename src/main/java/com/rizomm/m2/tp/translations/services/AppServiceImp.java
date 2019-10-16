package com.rizomm.m2.tp.translations.services;


import com.rizomm.m2.tp.translations.entities.Application;
import com.rizomm.m2.tp.translations.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppServiceImp implements  AppService{

    @Autowired
    private AppRepository appRepository;

    @Override
    public Application createApplication(Application application) {
        return appRepository.save(application);
    }
}
