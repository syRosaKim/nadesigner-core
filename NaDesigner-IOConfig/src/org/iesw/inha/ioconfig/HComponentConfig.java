package org.iesw.inha.ioconfig;

public class HComponentConfig {
    
    private String componentName;
    private String componentDir;
    private String category;
    private int componentInput;
    private int componentOutput;
    private String keyword;
    private String description;
    private String author;

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentDir() {
        return componentDir;
    }

    public void setComponentDir(String componentDir) {
        this.componentDir = componentDir;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getComponentInput() {
        return componentInput;
    }

    public void setComponentInput(int componentInput) {
        this.componentInput = componentInput;
    }

    public int getComponentOutput() {
        return componentOutput;
    }

    public void setComponentOutput(int componentOutput) {
        this.componentOutput = componentOutput;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

