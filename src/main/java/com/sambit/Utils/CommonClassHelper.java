package com.sambit.Utils;

import com.sambit.Entity.BasicDetails;
import com.sambit.Entity.MemberDetails;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Project : BSKY Backend
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 23/06/2023 - 11:51 AM
 */
public class CommonClassHelper {

    public static List<Map<String, Object>> convertBasicDetailsModelListToMapList(List<BasicDetails> modelList) {
        return modelList.stream()
                .map(model -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                            map.put("healthSlNo", model.getHealthSlNo() != null ? model.getHealthSlNo() : "NA");
                            map.put("rationCardNumber", model.getRationCardNumber() != null ? model.getRationCardNumber() : "NA");
                            map.put("rationCardType", model.getRationCardType() != null ? model.getRationCardType() : "NA");
                            map.put("fullNameEnglish", model.getFullNameEnglish() != null ? model.getFullNameEnglish() : "NA");
                            map.put("fullNameOdiya", model.getFullNameOdiya() != null ? model.getFullNameOdiya() : "NA");
                            map.put("aadhaarNumber", model.getAadhaarNumber() != null ? model.getAadhaarNumber() : "NA");
                            map.put("gender", model.getGender() != null ? model.getGender() : "NA");
                            map.put("spouseFullName", model.getSpouseFullName() != null ? model.getSpouseFullName() : "NA");
                            map.put("fatherFullName", model.getFatherFullName() != null ? model.getFatherFullName() : "NA");
                            map.put("mobileNumber", model.getMobileNumber() != null ? model.getMobileNumber() : "NA");
                            map.put("district", model.getDistrict() != null ? model.getDistrict() : "NA");
                            map.put("districtId", model.getDistrictId() != null ? model.getDistrictId() : "NA");
                            map.put("blockUlb", model.getBlockUlb() != null ? model.getBlockUlb() : "NA");
                            map.put("blockIdUlbId", model.getBlockIdUlbId() != null ? model.getBlockIdUlbId() : "NA");
                            map.put("gpWard", model.getGpWard() != null ? model.getGpWard() : "NA");
                            map.put("gpIdWardId", model.getGpIdWardId() != null ? model.getGpIdWardId() : "NA");
                            map.put("localityVillage", model.getLocalityVillage() != null ? model.getLocalityVillage() : "NA");
                            map.put("localityidVillageId", model.getLocalityidVillageId() != null ? model.getLocalityidVillageId() : "NA");
                            map.put("fpsName", model.getFpsName() != null ? model.getFpsName() : "NA");
                            map.put("schemeType", model.getSchemeType() != null ? model.getSchemeType() : "NA");
                            map.put("status", model.getStatus() != null ? model.getStatus() : "NA");
                            map.put("additionDeletionStatus", model.getAdditionDeletionStatus() != null ? model.getAdditionDeletionStatus() : "NA");
                            map.put("exportDate", model.getExportDate() != null ? DateFormat.formatDateWithTime(model.getExportDate()) : "NA");
                            map.put("updateDate", model.getUpdateDate() != null ? DateFormat.formatDateWithTime(model.getUpdateDate()) : "NA");
                            map.put("createdOn", model.getCreatedOn() != null ? DateFormat.formatDate(model.getCreatedOn()) : "NA");
                            map.put("createdBy", model.getCreatedBy() != null ? model.getCreatedBy() : "NA");
                            map.put("dataStatus", model.getDataStatus() == 0 ? "Inserted" : "Updated");
                            map.put("updatedOn", model.getUpdatedOn() != null ? model.getUpdatedOn() : "NA");
                            map.put("updatedBy", model.getUpdatedBy() != null ? model.getUpdatedBy() : "NA");
                            map.put("statusFlag", model.getStatusFlag() != null ? model.getStatusFlag() : "NA");
                            map.put("oldData", model.getOldDataId());
                    return map;
                })
                .collect(Collectors.toList());
    }

    public static List<Map<String, Object>> convertMemberDetailsModelListToMapList(List<MemberDetails> modelList) {
            return modelList.stream()
                    .map(model -> {
                            Map<String, Object> map = new LinkedHashMap<>();
                            map.put("healthMemeberSlNo", model.getHealthMemeberSlNo() != null ? model.getHealthMemeberSlNo() : "NA");
                            map.put("rationcardNumber", model.getRationcardNumber() != null ? model.getRationcardNumber() : "NA");
                            map.put("memberId", model.getMemberId() != null ? model.getMemberId() : "NA");
                            map.put("fullNameEnglish", model.getFullNameEnglish() != null ? model.getFullNameEnglish() : "NA");
                            map.put("fullNameOdiya", model.getFullNameOdiya() != null ? model.getFullNameOdiya() : "NA");
                            map.put("aadharNumber", model.getAadharNumber() != null ? model.getAadharNumber() : "NA");
                            map.put("gender", model.getGender() != null ? model.getGender() : "NA");
                            map.put("dateOfBirth", model.getDateOfBirth() != null ? DateFormat.formatDate(model.getDateOfBirth()) : "NA");
                            map.put("age", model.getAge() != null ? model.getAge() : "NA");
                            map.put("relationWithFamilyHead", model.getRelationWithFamilyHead());
                            map.put("schemeType", model.getSchemeType() != null ? model.getSchemeType() : "NA");
                            map.put("mobileNumber", model.getMobileNumber() != null ? model.getMobileNumber() : "NA");
                            map.put("status", model.getStatus() != null ? model.getStatus() : "NA");
                            map.put("additionDeletionStatus", model.getAdditionDeletionStatus() != null ? model.getAdditionDeletionStatus() : "NA");
                            map.put("exportDate", model.getExportDate() != null ? model.getExportDate() : "NA");
                            map.put("updateDate", model.getUpdateDate() != null ? model.getUpdateDate() : "NA");
                            map.put("createdOn", model.getCreatedOn() != null ? model.getCreatedOn() : "NA");
                            map.put("createdBy", model.getCreatedBy() != null ? model.getCreatedBy() : "NA");
                            map.put("dataStatus", model.getDataStatus() == 0 ? "Inserted" : "Updated");
                            map.put("updatedOn", model.getUpdatedOn());
                            map.put("updatedBy", model.getUpdatedBy());
                            map.put("statusFlag", model.getStatusFlag());
                            map.put("oldData", model.getOldDataId());
                            return map;
                    })
                    .collect(Collectors.toList());
    }

    public static List<String> getModelKeyNames(Class<?> modelClass) {
        List<String> keyNames = new ArrayList<>();

        Field[] fields = modelClass.getDeclaredFields();
        for (Field field : fields) {
            keyNames.add(field.getName());
        }
        return keyNames;
    }

    public static Map<String, Object> ConvertModelToMap(BasicDetails basicDetails) {
        Map<String, Object> map = new LinkedHashMap<>();
        BeanUtils.copyProperties(basicDetails, map);
        return map;
    }

    public static Class<?> converMapToModelClass(String modelName) {
        Class<?> modelClass = null;
        try {
            modelClass = Class.forName("com.odisha.rationcard.model." + modelName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return modelClass;
    }
}
