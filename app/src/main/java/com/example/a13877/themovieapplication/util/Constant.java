package com.example.a13877.themovieapplication.util;



public class Constant {

    public static final String BASE_URL = "https://api.themoviedb.org";
    public static final String IMG_URL = "http://image.tmdb.org/t/p/w185";
    public static final String API_KEY = "95ffbd804001d42bb7eb88c69bf5a9cd";
    public static final String API_KEY_NEWS = "741d4a06cc35476395aea4a2d8b294ac";
    public static final String VERSION = "/3";
    public static final String VERSION_NEWS = "/v2";
    public static final String MOVIE = "/movie";
    public static final String TV = "/tv";
    public static final String REVIEWS = "/reviews";
    public static final String VIDEOS = "/videos";
    public static final String HEADLINES = "/top-headlines";


    public static final String GENRE = "/genre";
    public static final String LANG_EN = "en-US";
    public static final String SOURCES = "entertainment-weekly";
    public static final String MOVIE_PATH = VERSION + MOVIE;
    public static final String TV_PATH = VERSION + TV;
    public static final String GENRE_PATH = VERSION + GENRE+MOVIE;
    public static final String GENRE_PATH2 = VERSION + GENRE+TV;


    //https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1
}
