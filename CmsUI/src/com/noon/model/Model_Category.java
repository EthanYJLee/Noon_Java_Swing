
package com.noon.model;

import javax.swing.ImageIcon;

public class Model_Category {
    String icon;
    String name;
    CategoryType type;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public Model_Category() {
    }

    public Model_Category(String icon, String name, CategoryType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
    public ImageIcon toIcon(){
        return new ImageIcon(getClass().getResource("/com/noon/icon/"+icon+".png"));
       
    }
    
    public static enum CategoryType{
        CATEGORY,SUBCATEGORY,EMPTY
    }
}
