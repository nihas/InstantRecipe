package com.nihas.recipe.pojos;

/**
 * Created by snyxius on 10/14/2015.
 */
public class AllPojo {

    private String title;
    private String url;

    public AllPojo(String titl, String urll){
        this.title=titl;
        this.url=urll;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
