package com.preference.controller;

import com.preference.model.Preferenceable;
import com.preference.service.CategoryService;
import com.preference.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PreferenceableController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PreferenceService preferenceService;

    //TODO

    public List<Preferenceable> getAll() {

        List<Preferenceable> preferenceables = new ArrayList<>();
        preferenceables.addAll(categoryService.findAll());
        preferenceables.addAll(preferenceService.findAll());
        return preferenceables;
    }

    public List<Preferenceable> getChildren(Long id) {

        List<Preferenceable> preferenceables = new ArrayList<>();
        preferenceables.addAll(categoryService.findAllByParentId(id));
        preferenceables.addAll(preferenceService.findAllByParentId(id));
        return preferenceables;
    }



}
