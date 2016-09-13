package com.preference.service;

import com.preference.exception.PreferenceException;
import com.preference.model.Preference;

import java.util.List;

public interface PreferenceService {

    Preference create(Preference preference);

    Preference update(Preference preference) throws PreferenceException;

    boolean delete(Long id);

    boolean delete(Preference preference);

    List<Preference> findAll();

    Preference findById(Long id);

    List<Preference> findAllByParentId(Long parentId);

}
