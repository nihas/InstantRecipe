package com.nihas.recipe.recipeapi;

/**
 * Created by AMAN on 01-10-2015.
 */
public class WebServices {
    // public static final String baseUrl =
    // "http://108.166.119.46/projects-ftp/gymchaloAPI/index.php/api/";
    public static final String newbaseUrl = "http://www.recipepuppy.com/api/";




    /*Book a Gym
    Parameters Explained

city – Default to “Bangalore”. Currently we only have Bangalore data.

location – Default to “All”. Pass a locality name based on user’s drop-down selection

keyword – Optional. This is for Search only. If user types a keyword in search pass that keyword here.

category – Defaults to “Gyms”. In this case you can pass “Gyms, Slimming Centers”. You can pass multiple categories here separated by comma.

     */

    public static String getRecipe(String ingredients,String name,int page) {
        return newbaseUrl + "?i="+ingredients+"&q="+name+"&p="+page;
    }

    public static String getRecipebyIngredients(String ingredients,int page) {
        return newbaseUrl + "?i="+ingredients+"&p="+page;
    }

    public static String getRecipebyName(String name,int page) {
        return newbaseUrl + "?q="+name+"&p="+page;
    }

    public static String getRecipe(int page) {
        return newbaseUrl + "?p="+page;
    }




    /*  Book a Fitness Class

    Parameters Explained

city – Default to “Bangalore”. Currently we only have Bangalore data.

location – Default to “All”. Pass a locality name based on user’s drop-down selection

keyword – Optional. This is for Search only. If user types a keyword in search pass that keyword here.

category – Defaults to “Gyms”. In this case you can pass “Dance, Martial Arts, Yoga”. You can pass multiple categories here separated by comma.


     */






    public static String upcomingfetchListings(String city,String keyword,int limit,int offset) {
        return newbaseUrl + "listings/fetchEvents?city=" + city+"&keyword="+keyword+"&limit="+limit+"&offset="+offset;
    }

    public static String upcomingfetchListings(String city,int limit,int offset) {
        return newbaseUrl + "listings/fetchEvents?city=" + city  +"&limit="+ limit +"&offset="+offset;
    }

    public static String upcomingfetchListings(String city,String keyword) {
        return newbaseUrl + "listings/fetchEvents?city=" + city+"&keyword="+keyword;
    }

    public static String upcomingfetchListings(String city) {
        return newbaseUrl + "listings/fetchEvents?city=" + city;
    }


    public static String fetchListingDetails(String id) {
        return newbaseUrl + "listings/fetchListingDetails?id=" + id;
    }

    public static String fetchEventDetails(String id) {
        return newbaseUrl + "listings/fetchEventDetails?id=" + id;
    }


}
