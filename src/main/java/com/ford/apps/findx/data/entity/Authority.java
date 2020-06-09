
package com.ford.apps.findx.data.entity;

public class Authority {

    private Long id = 0L;
    private String name = null;

    public Authority() {

    }

    @Override
    public String toString() {
        return "Authority#{id=" + id + ",name=" + name + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}