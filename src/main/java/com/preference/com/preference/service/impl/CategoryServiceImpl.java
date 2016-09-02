package com.preference.com.preference.service.impl;

import com.preference.com.preference.service.CategoryService;
import com.preference.model.Category;
import com.preference.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {

        if (!categoryRepository.exists(category.getId())) {
            //throw
        }
        return categoryRepository.updateCategory(category.getId(), category.getInternalName(),
                category.getDisplayName(), category.getParentId());
    }

    public boolean delete(Long id) {
        Category deleted = categoryRepository.findOne(id);
        return delete(deleted);
    }

    public boolean delete(Category category) {
        Long deletedId = category.getId();
        categoryRepository.delete(category);
        return !categoryRepository.exists(deletedId);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    public Category getRoot() {
        return categoryRepository.getRoot();
    }
}
