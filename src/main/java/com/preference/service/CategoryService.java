package com.preference.service;

import com.preference.exception.PreferenceException;
import com.preference.model.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    Category update(Category category) throws PreferenceException;

    boolean delete(Long id);

    boolean delete(Category category);

    List<Category> findAll();

    Category findById(Long id);

    Category findRoot();

    List<Category> findAllByParentId(Long parentId);
}
