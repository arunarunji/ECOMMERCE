package com.dataHandler;


import com.model.Category;
import java.util.ArrayList;


public interface CategoryHandle {
    ArrayList<Category> getCategoriesList();
    ArrayList<Integer> getCategoryList(int categoryId);
    Category getCategory(int categoryId);
    void setCategoryList(Category category);
}
