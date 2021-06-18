package jc.sugar.JiaHui.entity;

import java.util.List;

/**
 * 2021/5/26 10:50
 * Code by 谢良基
 */
public class SugarJFunction {

    private Integer id;

    private String name;

    private List<String> argumentDescriptions;


    public SugarJFunction(String name, List<String> argumentDescriptions){
        this.id = System.identityHashCode(this);
        this.name = name;
        this.argumentDescriptions = argumentDescriptions;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArgumentDescriptions() {
        return argumentDescriptions;
    }

    public void setArgumentDescriptions(List<String> argumentDescriptions) {
        this.argumentDescriptions = argumentDescriptions;
    }
}
