package com.sambit.CompetitvePractice.Java8.Conversion;

import com.sambit.Bean.PersonalDataBean;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 09/05/2023 - 12:51 PM
 */
public class ListToMap {
    public static void main(String[] args) {
        listToMapConversion();
        listToMapConversionDuplicateKey();
    }

    public static void listToMapConversion() {
        PersonalDataBean personalDataBean = new PersonalDataBean();
        personalDataBean.setPid(1);
        personalDataBean.setName("Sambit Kumar Pradhan");
        personalDataBean.setPanId("DFHPP5027M");
        personalDataBean.setAdharNo("220778011303");

        PersonalDataBean personalDataBean1 = new PersonalDataBean();
        personalDataBean1.setPid(2);
        personalDataBean1.setName("Hrusikesh Mohanty");
        personalDataBean1.setPanId("DFHPP5027N");
        personalDataBean1.setAdharNo("220778011304");

        List<PersonalDataBean> personalDataBeanList = List.of(personalDataBean, personalDataBean1);

        Map<String, String> deatilsMap = personalDataBeanList.stream()
                .collect(Collectors.toMap(map -> map.getName(), map -> map.getAdharNo()));
        System.out.println("Details Map For Personal Data Bean : " + deatilsMap);

        Map<Integer, String> detailsMap1 = personalDataBeanList.stream()
                .collect(Collectors.toMap(PersonalDataBean::getPid, PersonalDataBean::getName));
        System.out.println("Details Map For Personal Data Bean1 : " + detailsMap1);
    }

    public static void listToMapConversionDuplicateKey() {
        PersonalDataBean personalDataBean = new PersonalDataBean();
        personalDataBean.setPid(1);
        personalDataBean.setName("Sambit Kumar Pradhan");
        personalDataBean.setPanId("DFHPP5027M");
        personalDataBean.setAdharNo("220778011303");

        PersonalDataBean personalDataBean1 = new PersonalDataBean();
        personalDataBean1.setPid(2);
        personalDataBean1.setName("Hrusikesh Mohanty");
        personalDataBean1.setPanId("DFHPP5027N");
        personalDataBean1.setAdharNo("220778011304");

        PersonalDataBean personalDataBean2 = new PersonalDataBean();
        personalDataBean2.setPid(3);
        personalDataBean2.setName("Hrusikesh Mohanty");
        personalDataBean2.setPanId("DFHPP5027O");
        personalDataBean2.setAdharNo("220778011305");

        List<PersonalDataBean> personalDataBeanList = List.of(personalDataBean, personalDataBean1, personalDataBean2);

        Map<String, String> detailsMap2 = personalDataBeanList.stream()
                .collect(Collectors.toMap(map -> map.getName(), map -> map.getAdharNo(),
                        (oldValue, newValue) -> newValue));//newValue is for updating newValue
        System.out.println("Details Map For Personal Data Bean2 : " + detailsMap2);
    }
}
