package model;

import java.io.Serializable;

/**
 * Created by Minea on 1/24/2018.
 */

public class Categories implements Serializable{
    private String cate_id;
    private String cate_name;

    public Categories(String cate_id, String cate_name) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    @Override
    public String toString() {
        return cate_name;
    }
}
