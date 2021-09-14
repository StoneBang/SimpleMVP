package com.zkbl.toutiaojava.bean;

import java.util.List;

/**
 * Create by StoneBang at 2021/9/14
 */
public class BaseModel<T> {
    public String msg;
    public String code;
    public List<T> data;
}
