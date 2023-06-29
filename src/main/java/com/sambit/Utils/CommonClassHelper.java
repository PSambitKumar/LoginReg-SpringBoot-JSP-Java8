package com.sambit.Utils;

import com.sambit.Entity.BasicDetails;
import com.sambit.Entity.MemberDetails;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
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

    public static String generateExcelFile(List<Map<String, Object>> dataList, List<String> columns, String sheetName, String fileName) {
        String path;
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(sheetName);

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Font newFont = workbook.createFont();
            newFont.setBold(true);
            newFont.setColor(IndexedColors.WHITE.getIndex());
            newFont.setFontHeightInPoints((short) 15);
            newFont.setItalic(true);

            headerCellStyle.setFont(newFont);
            Row headerRow = sheet.createRow(0);

            Cell headingCell = headerRow.createCell(0);
            headingCell.setCellValue(fileName);
            CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, columns.size() - 1);//Merging Rows / Columns
            sheet.addMergedRegion(mergedRegion);
            headingCell.setCellStyle(headerCellStyle);

            Row generatedRow = sheet.createRow(1);
            Cell generatedCell = generatedRow.createCell(0);
            generatedCell.setCellValue("Generated On:");
            generatedCell.setCellStyle(headerCellStyle);
            generatedRow.createCell(1).setCellValue(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()));

            Row generatedRow1 = sheet.createRow(2);
            Cell generatedCell1 = generatedRow1.createCell(0);
            generatedCell1.setCellValue("Generated By:");
            generatedCell1.setCellStyle(headerCellStyle);
            generatedRow1.createCell(1).setCellValue("System");

            Row dataHeaderRow = sheet.createRow(4);
            for (int i = 0; i < columns.size(); i++) {
                Cell cell = dataHeaderRow.createCell(i);
                cell.setCellValue(columns.get(i));
                cell.setCellStyle(headerCellStyle);
            }

            int rowNum = 5;
            int count = 0;

            for (Map<String, Object> objectMap : dataList) {
                Row dataRow = sheet.createRow(rowNum++);
                count = count + 1;
                String s = String.valueOf(count);
                dataRow.createCell(0).setCellValue(s.trim());
                for (int i = 1; i < columns.size(); i++) {
                    String column = columns.get(i);
                    if (objectMap.containsKey(column) && objectMap.get(column) != null)
                        dataRow.createCell(i).setCellValue(objectMap.get(column).toString());
                    else
                        dataRow.createCell(i).setCellValue("-NA-");
                }
            }

            for (int i = 0; i < columns.size() + 1; i++) {
                sheet.autoSizeColumn(i);
            }

            try {
                String home = System.getProperty("user.home");
                path = home + "/Desktop/" + fileName + ".xlsx";
                File file = new File(path);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                workbook.write(fileOutputStream);
                fileOutputStream.close();
                workbook.close();
            } catch (IOException e) {
                throw new IOException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}
