
package com.ford.apps.findx.domain.model;

import java.util.ArrayList;
import java.util.List;

public class MapResult {

    private int status = 0;
    private String message = null;
    private List<Place> results = new ArrayList<Place>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Place> getResults() {
        return results;
    }

    public void setResults(List<Place> results) {
        this.results = results;
    }
}