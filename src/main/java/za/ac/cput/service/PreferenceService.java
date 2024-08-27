package za.ac.cput.service;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Preference;
import za.ac.cput.repository.PreferenceRepository;

import java.util.List;

@Service
public class PreferenceService implements IPreferenceService{

    private PreferenceRepository preferenceRepository;

    @Autowired
    public PreferenceService( PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public Preference create(Preference preference) {
        return preferenceRepository.save(preference);
    }

    @Override
    public Preference read(Long preferenceId){
        return preferenceRepository.findById(preferenceId).orElse(null);
    }

    @Override
    public Preference update(Preference preference){
        return preferenceRepository.save(preference);
    }

    @Override
    public void delete(Long preferenceId) {
        preferenceRepository.deleteById(preferenceId);
    }

    @Override
    public List<Preference> getAll(){
        return preferenceRepository.findAll();
    }
}
