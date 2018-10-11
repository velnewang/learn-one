package ck2.bean.military;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Branch {

    public int id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String type;
    public Troop[] troops;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer leader;

}
