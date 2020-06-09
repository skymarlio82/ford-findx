
package com.ford.apps.findx.data.entity;

import java.util.Date;

public class LocationPoint {

    private long id = 0L;
    private String name = null;
    private String address = null;
    private String province = null;
    private String city = null;
    private String area = null;
    private String streetId = null;
    private String loginId = null;
    private Date dateTime = null;

    public LocationPoint() {

    }

    public LocationPoint(long id, String name, String address, String province,
                         String city, String area, String streetId, String loginId, Date dateTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.province = province;
        this.city = city;
        this.area = area;
        this.streetId = streetId;
        this.loginId = loginId;
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}