package com.preference.controller;

import com.preference.model.Preferenceable;
import com.preference.service.CategoryService;
import com.preference.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/preference")
public class PreferenceableController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PreferenceService preferenceService;

    //TODO

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public Collection<Preferenceable> getAll() {

        List<Preferenceable> preferenceables = new ArrayList<>();
        preferenceables.addAll(categoryService.findAll());
        preferenceables.addAll(preferenceService.findAll());
        return preferenceables;
    }

    @RequestMapping(value="/getChildren/{id}", method = RequestMethod.GET)
    public Collection<Preferenceable> getChildren(@PathVariable Long id) {

        List<Preferenceable> preferenceables = new ArrayList<>();
        preferenceables.addAll(categoryService.findAllByParentId(id));
        preferenceables.addAll(preferenceService.findAllByParentId(id));
        return preferenceables;
    }
}
