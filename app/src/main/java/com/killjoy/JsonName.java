package com.killjoy;

public class JsonName {
    private String JSON;
    private String name;

    public JsonName(String JSON, String name) {
        this.JSON = JSON;
        this.name = name;
    }

    public String getJSON() {
        return JSON;
    }

    public void setJSON(String JSON) {
        this.JSON = JSON;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
