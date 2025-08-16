package com.plansoft.marulo_market.domain;

public class Category {
    private int caterogyId;
    private String description;
    private boolean active;



    public int getCaterogyId() {
        return caterogyId;
    }

    public void setCaterogyId(int caterogyId) {
        this.caterogyId = caterogyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}