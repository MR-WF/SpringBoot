package com.wf.model;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Mr_WF on 2018/6/30.
 */
@Getter
@Setter
public class Role {
    private Long id;
    private String name;
    private Role parent;
    private Set<Role> children = new HashSet<Role>();


}
