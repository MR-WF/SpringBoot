package com.wf.study;


import com.wf.model.Role;
import org.junit.Test;

import java.util.*;


/**
 * 递归 简单应用- 树形组织架构
 * Created by Mr_WF on 2018/6/30.
 */
public class Recursion {


    /**
     * 打印所有顶层部门及其子孙部门的信息（名称），用不同的缩进表示层次（使用全角空格）。<br>
     * 子部门的名称前比上级部门多一个空格，最顶层部门的名字前没有空格。
     *
     * 要求打印如下效果：
     *
     * <pre>
     * ┣市场部
     *    ┣宣传部
     *    ┣业务部
     *       ┣业务一部
     *       ┣业务二部
     * ┣开发部
     *    ┣开发一部
     *    ┣开发二部
     * </pre>
     */




    //@Before
    public List<Role> initDatas(){
        Role dept_1_1 = new Role();
        dept_1_1.setId(new Long(11));
        dept_1_1.setName("宣传部");

        Role dept_1_2 = new Role();
        dept_1_2.setId(new Long(12));
        dept_1_2.setName("业务部");

        Role dept_1_2_1 = new Role();
        dept_1_2_1.setId(new Long(121));
        dept_1_2_1.setName("业务一部");

        Role dept_1_2_2 = new Role();
        dept_1_2_2.setId(new Long(122));
        dept_1_2_2.setName("业务二部");

        dept_1_2_1.setParent(dept_1_2);
        dept_1_2_2.setParent(dept_1_2);
        Set<Role> children_0 = new LinkedHashSet<Role>();
        children_0.add(dept_1_2_1);
        children_0.add(dept_1_2_2);
        dept_1_2.setChildren(children_0);


        Role dept_1 = new Role();
        dept_1.setId(new Long(1));
        dept_1.setName("市场部");

        dept_1_1.setParent(dept_1);
        dept_1_2.setParent(dept_1);
        Set<Role> children_1 = new LinkedHashSet<Role>();
        children_1.add(dept_1_1);
        children_1.add(dept_1_2);
        dept_1.setChildren(children_1);

        Role dept_2_1 = new Role();
        dept_2_1.setId(new Long(21));
        dept_2_1.setName("开发一部");

        Role dept_2_2 = new Role();
        dept_2_2.setId((new Long(22)));
        dept_2_2.setName("开发二部");

        Role dept_2 = new Role();
        dept_2.setId(new Long(2));
        dept_2.setName("开发部");

        dept_2_1.setParent(dept_2);
        dept_2_2.setParent(dept_2);
        Set<Role> children_2 = new LinkedHashSet<Role>();
        children_2.add(dept_2_1);
        children_2.add(dept_2_2);
        dept_2.setChildren(children_2);

        List<Role> datas = new ArrayList<Role>();
        datas.add(dept_1);
        datas.add(dept_2);
        return datas;
    }

    @Test
    public void printRoles(){
        List<Role> datas = initDatas();
        //遍历所有的根节点，即一级部门
        //方法一：每一步只关注当前树的根节点和其子树，不关心其他的
       /* for (Role top  : datas){
            showChildrenTree(top);
        }*/
       //方法二
        showTreeList(datas);
    }

    /**
     * 每一步只关注当前树的根节点和其子树，不关心其他的
     * @param top
     */
    public void showChildrenTree(Role top) {
        //打印每个树的根节点的name
        System.out.println(top.getName());
        //打印改节点的下所有子树的节点信息
        for (Role children  : top.getChildren()){
            showChildrenTree(children);
        }
    }

    /**
     * 显示多颗树的所有节点的信息
     *
     * @param topList
     */
    private void showTreeList(Collection<Role> topList) {
        for (Role top : topList) {
            // 顶点
            System.out.println(top.getName());
            // 子树
            showTreeList(top.getChildren());
        }
    }


    @Test
    public void printRolesByTree() {
        List<Role> topList = initDatas();

        printRolesListByTree(topList, "*");
    }

    // 显示树
    private void printRolesListByTree(Collection<Role> topList, String prefix) {
        for (Role top : topList) {
            // 顶点
            System.out.println(prefix + top.getName());
            // 子树
            printRolesListByTree(top.getChildren(), "    " + prefix);
        }
    }
}
