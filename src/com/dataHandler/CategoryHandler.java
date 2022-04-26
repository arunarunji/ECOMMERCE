package com.dataHandler;


import com.dataBase.CategoryDb;
import com.dataBase.CategoryInt;
import com.model.Category;

import java.util.ArrayList;

public class CategoryHandler implements CategoryHandle {
    private static  CategoryHandler CATEGORY_HANDLER ;
    private final CategoryInt categoryInt= CategoryDb.getInstance();

    private CategoryHandler() {

    }

    public static CategoryHandler getInstance() {
        if(CATEGORY_HANDLER==null)
            CATEGORY_HANDLER = new CategoryHandler();
        return CATEGORY_HANDLER;

    }

    @Override
    public ArrayList<Category> getCategoriesList() {
        return categoryInt.getCategoryList();
    }
    @Override
    public ArrayList<Integer> getCategoryList(int categoryId) {
        for (Category category : categoryInt.getCategoryList())
            if (category.getCategoryId() == categoryId)
                return category.getProducts();
        return null;
    }
    @Override
    public Category getCategory(int categoryId) {
        for (Category category : categoryInt.getCategoryList())
            if (category.getCategoryId() == categoryId)
                return category;

        return null;

    }




    @Override
    public void setCategoryList(Category category) {
        categoryInt.getCategoryList().add(category);
    }

}
