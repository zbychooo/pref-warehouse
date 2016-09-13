package com.preference.main;

import com.preference.config.WarehouseConfig;
import com.preference.model.Category;
import com.preference.model.Preference;
import com.preference.model.ValueType;
import com.preference.service.CategoryService;
import com.preference.service.PreferenceService;
import com.preference.service.impl.CategoryServiceImpl;
import com.preference.service.impl.PreferenceServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RemoteRunner {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(WarehouseConfig.class);

        CategoryService categoryService = context.getBean(CategoryServiceImpl.class);
        Category category = new Category("root", "root", null);
        categoryService.create(category);


        PreferenceService preferenceService = context.getBean(PreferenceServiceImpl.class);
        Preference preference = new Preference("inter","display",1L, ValueType.BOOLEAN, "true");
        preferenceService.create(preference);

    }
}
