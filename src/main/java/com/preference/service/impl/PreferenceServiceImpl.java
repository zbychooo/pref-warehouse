package com.preference.service.impl;

import com.preference.exception.PreferenceException;
import com.preference.model.Preference;
import com.preference.repository.PreferenceRepository;
import com.preference.service.PreferenceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    @Resource
    PreferenceRepository preferenceRepository;

    @Override
    public Preference create(Preference preference) {
        return preferenceRepository.save(preference);
    }

    @Override
    public Preference update(Preference preference) throws PreferenceException {

        if (!preferenceRepository.exists(preference.getId())) {
            throw new PreferenceException("Given category cannot be updated because does not exist in database!");
        }
        preferenceRepository.updatePreference(preference.getId(), preference.getInternalName(),
                preference.getDisplayName(), preference.getParentId(), preference.getValueType(), preference.getValue());

        return findById(preference.getId());
    }

    @Override
    public boolean delete(Long id) {
        preferenceRepository.delete(id);
        return !preferenceRepository.exists(id);
    }

    @Override
    public boolean delete(Preference preference) {
        return delete(preference.getId());
    }

    @Override
    public List<Preference> findAll() {
        return preferenceRepository.findAll();
    }

    @Override
    public Preference findById(Long id) {
        return preferenceRepository.findOne(id);
    }

    @Override
    public List<Preference> findAllByParentId(Long parentId) {
        return preferenceRepository.findAllByParentId(parentId);
    }
}
