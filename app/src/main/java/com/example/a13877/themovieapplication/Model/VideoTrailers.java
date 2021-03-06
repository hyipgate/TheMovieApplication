package com.example.a13877.themovieapplication.Model;

import java.util.List;

public class VideoTrailers {
    private int id;

    private List<VideoTrailerContent> results;

    public List<VideoTrailerContent> getResults() {
        return results;
    }

    public void setResults(List<VideoTrailerContent> results) {
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public class VideoTrailerContent {

        private String name;
        private String key;
        private String site;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }
    }

}
