package com.hjc.menu.model;

import java.util.Date;

public class Menu {
    private Long id;

    private String code;

    private String name;

    private String url;

    private Long parentFk;

    private String menuPath;

    private Short menuLevel;

    private Long createFk;

    private Long updateFk;

    private Date dateCreate;

    private Date dateUpdate;

    private Boolean isValid;

    private Boolean isDisable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentFk() {
        return parentFk;
    }

    public void setParentFk(Long parentFk) {
        this.parentFk = parentFk;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public Short getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Short menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Long getCreateFk() {
        return createFk;
    }

    public void setCreateFk(Long createFk) {
        this.createFk = createFk;
    }

    public Long getUpdateFk() {
        return updateFk;
    }

    public void setUpdateFk(Long updateFk) {
        this.updateFk = updateFk;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Boolean getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Boolean isDisable) {
        this.isDisable = isDisable;
    }
}