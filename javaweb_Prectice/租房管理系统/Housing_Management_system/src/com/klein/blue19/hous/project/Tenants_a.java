package com.klein.blue19.hous.project;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Tenants_a implements Serializable {
    private int tenant;
    private String name;
    private String contact;
    private String identity_card;
    private Date rent_start_date;
    private Date rent_end_date;
    private String password;

    public Tenants_a() {
    }


    @Override
    public String toString() {
        return "tenants_a{" +
                "tenant=" + tenant +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", identity_card='" + identity_card + '\'' +
                ", rent_start_date=" + rent_start_date +
                ", rent_end_date=" + rent_end_date +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenants_a tenantsA = (Tenants_a) o;
        return tenant == tenantsA.tenant && Objects.equals(name, tenantsA.name) && Objects.equals(contact, tenantsA.contact) && identity_card.equals(tenantsA.identity_card) && Objects.equals(rent_start_date, tenantsA.rent_start_date) && Objects.equals(rent_end_date, tenantsA.rent_end_date) && Objects.equals(password, tenantsA.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenant, name, contact, identity_card, rent_start_date, rent_end_date, password);
    }

    public int getTenant() {
        return tenant;
    }

    public void setTenant(int tenant) {
        this.tenant = tenant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public Date getRent_start_date() {
        return rent_start_date;
    }

    public void setRent_start_date(Date rent_start_date) {
        this.rent_start_date = rent_start_date;
    }

    public Date getRent_end_date() {
        return rent_end_date;
    }

    public void setRent_end_date(Date rent_end_date) {
        this.rent_end_date = rent_end_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
