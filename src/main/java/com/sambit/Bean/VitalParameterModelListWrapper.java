package com.sambit.Bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 14-Nov-2023 : 6:09 PM
 */

@XmlRootElement(name = "ArrayOfVitalParameterModel")
public class VitalParameterModelListWrapper {
    private List<Map<String, Object>> list;

    @XmlElement(name = "VitalParameterModel")
    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}
