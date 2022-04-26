package com.dataBase;


import com.model.Category;

import java.util.ArrayList;

public class CategoryDb implements CategoryInt {

    private static  CategoryDb CATEGORY_DB =null;

    private CategoryDb() {

    }
    public static CategoryDb getInstance() {
        if(CATEGORY_DB == null)
            CATEGORY_DB = new CategoryDb();
        return CATEGORY_DB;
    }
    private final Category electronics = new Category("Electronics", new ArrayList<Integer>() {
        {
            add(2000);
            add(2001);
            add(2002);
            add(2003);
            add(1000);
            add(1001);
            add(1002);
            add(1003);
            add(1004);
            add(1005);
            add(1006);
            add(1007);
            add(2005);
            add(2006);
            add(2007);
            add(2009);
            add(2100);
            add(2101);
            add(2102);
            add(2103);

        }
    });
    private final Category books = new Category("Books", new ArrayList<Integer>() {
        {
            add(3000);
            add(3001);
            add(3002);
            add(3003);
            add(3004);
            add(3100);
            add(3102);
        }
    });
    private final ArrayList<Category> categoryList = new ArrayList<Category>() {
        {
            add(electronics);
            add(books);
        }
    };


    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }
}
