package com.petshelter.helper;

public enum PetType {
    DOG(1,"Dog"),
    CAT(2,"Cat"),
    FISH(3,"Fish");

    private String desc;
    private Integer id;

    PetType(Integer id, String desc) {
    }

    public String toString() { return this.desc; }

    public void setDesc(String desc){
        this.desc=desc;
    }

}
