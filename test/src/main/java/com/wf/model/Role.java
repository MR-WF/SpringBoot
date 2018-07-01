package com.wf.model;


import lombok.Getter;
import lombok.Setter;


/**
 * Created by Mr_WF on 2018/6/30.
 */
@Getter
@Setter
public class Role {
    private Long id;
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
