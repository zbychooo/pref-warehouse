package com.preference.service.impl;

import com.preference.exception.PreferenceException;
import com.preference.model.Category;
import com.preference.repository.CategoryRepository;
import com.preference.service.CategoryService;
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

    public Category update(Category category) throws PreferenceException {

        if (!categoryRepository.exists(category.getId())) {
            throw new PreferenceException("Given category cannot be updated because does not exist in database!");
        }
        categoryRepository.updateCategory(category.getId(), category.getInternalName(),
                category.getDisplayName(), category.getParentId());

        return findById(category.getId());
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

    public Category findRoot() {
        return categoryRepository.findRoot();
    }

    public List<Category> findAllByParentId(Long parentId) {
        return categoryRepository.findAllByParentId(parentId);
    }
}
