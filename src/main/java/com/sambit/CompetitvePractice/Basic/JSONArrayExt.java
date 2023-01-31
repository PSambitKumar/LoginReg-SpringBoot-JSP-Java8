package com.sambit.CompetitvePractice.Basic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.Convert;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 31/01/2023 - 4:41 PM
 */
public class JSONArrayExt {

    public static void main(String[] args) throws JSONException {
        String data = "[[\"[{\\\"ctrlId\\\": \\\"ctrl_01302023030415\\\", \\\"ctrlName\\\": \\\"ctrl_01302023030415\\\", \\\"ctrlSlNo\\\": \\\"1\\\", \\\"ctrlClass\\\": \\\"\\\", \\\"ctrlLabel\\\": \\\"Name\\\", \\\"ctrlTypeId\\\": 2, \\\"ctrlbtnType\\\": \\\"0\\\", \\\"ctrlFileType\\\": \\\"0\\\", \\\"ctrlhelptext\\\": \\\"\\\", \\\"ctrlLabelData\\\": \\\"\\\", \\\"ctrlMandatory\\\": true, \\\"ctrlMaxLength\\\": \\\"\\\", \\\"ctrlMinLength\\\": \\\"\\\", \\\"ctrlTableName\\\": \\\"\\\", \\\"ctrlforSearch\\\": true, \\\"addmoreDetails\\\": [], \\\"addmorerowdata\\\": [], \\\"ctrlforViePage\\\": true, \\\"ctrlForApproval\\\": false, \\\"ctrlHeadingType\\\": \\\"0\\\", \\\"ctrlLabelinOdia\\\": \\\"\\\", \\\"ctrlPlaceholder\\\": \\\"\\\", \\\"tablecolDetails\\\": [{\\\"ctrlTblColName\\\": \\\"VCH_NAME\\\", \\\"ctrlTblColType\\\": \\\"VARCHAR\\\", \\\"ctrlTblColLength\\\": \\\"30\\\", \\\"ctrlTblColDeafult\\\": \\\"Null\\\", \\\"ctrlTblColParentTbl\\\": \\\"\\\", \\\"ctrlTblColConstraints\\\": \\\"\\\", \\\"ctrlTblColParentTblClmName\\\": \\\"\\\"}], \\\"ctrlFileSizeType\\\": \\\"0\\\", \\\"ctrlAttributeType\\\": \\\"text\\\", \\\"ctrlFileMaxLength\\\": \\\"\\\", \\\"dependctrlDetails\\\": [{\\\"ctrlChkDepend\\\": false, \\\"ctrlSelDependValue\\\": [\\\"0\\\"], \\\"ctrlSelDependParent\\\": \\\"0\\\"}], \\\"validationDetails\\\": \\\"2\\\", \\\"calculationDetails\\\": [{\\\"ctrlCalcOptions\\\": [], \\\"ctrlChkCalculation\\\": false}], \\\"ctrlOthervalidation\\\": \\\"\\\", \\\"cascadingCtrlDetails\\\": [{\\\"ctrlCCDAlias\\\": \\\"\\\", \\\"ctrlCCDTableName\\\": \\\"\\\", \\\"ctrlCCDConditions\\\": \\\"\\\", \\\"ctrlStaticOptions\\\": [], \\\"ctrlCCbindDatatype\\\": \\\"\\\", \\\"ctrlCCbinddecldClm\\\": \\\"\\\", \\\"ctrlCCbinddepentfld\\\": \\\"0\\\", \\\"ctrlCCDTextColumnName\\\": \\\"\\\", \\\"ctrlCCbinddepentOther\\\": \\\"no\\\", \\\"ctrlCCDValueColumnName\\\": \\\"\\\"}], \\\"ctrlOtherButtonClass\\\": \\\"0\\\", \\\"radioAddmoreviewtype\\\": \\\"0\\\"}, {\\\"ctrlId\\\": \\\"ctrl_01302023030528\\\", \\\"ctrlName\\\": \\\"ctrl_01302023030528\\\", \\\"ctrlSlNo\\\": \\\"2\\\", \\\"ctrlClass\\\": \\\"\\\", \\\"ctrlLabel\\\": \\\"Registration Form\\\", \\\"ctrlTypeId\\\": 10, \\\"ctrlbtnType\\\": \\\"0\\\", \\\"ctrlFileType\\\": \\\"0\\\", \\\"ctrlhelptext\\\": \\\"\\\", \\\"ctrlLabelData\\\": \\\"\\\", \\\"ctrlMandatory\\\": false, \\\"ctrlMaxLength\\\": \\\"\\\", \\\"ctrlMinLength\\\": \\\"\\\", \\\"ctrlTableName\\\": \\\"DEMO_REG_ADD\\\", \\\"ctrlforSearch\\\": false, \\\"addmoreDetails\\\": [{\\\"ctrlId\\\": \\\"ctrl_01302023030601\\\", \\\"ctrlName\\\": \\\"ctrl_01302023030601\\\", \\\"ctrlSlNo\\\": \\\"1\\\", \\\"ctrlClass\\\": \\\"\\\", \\\"ctrlLabel\\\": \\\"Applicant Name\\\", \\\"ctrlTypeId\\\": \\\"2\\\", \\\"ctrlFileType\\\": \\\"0\\\", \\\"ctrlhelptext\\\": \\\"\\\", \\\"ctrlLabelData\\\": \\\"\\\", \\\"ctrlMandatory\\\": true, \\\"ctrlMaxLength\\\": \\\"\\\", \\\"ctrlMinLength\\\": \\\"\\\", \\\"ctrlTableName\\\": \\\"\\\", \\\"ctrlForApproval\\\": false, \\\"ctrlLabelinOdia\\\": \\\"\\\", \\\"ctrlPlaceholder\\\": \\\"\\\", \\\"ctrlFileSizeType\\\": \\\"0\\\", \\\"ctrlAttributeType\\\": \\\"0\\\", \\\"ctrlFileMaxLength\\\": \\\"\\\", \\\"validationDetails\\\": \\\"0\\\", \\\"ctrlOthervalidation\\\": \\\"\\\", \\\"addmoretablecolDetails\\\": [{\\\"ctrlTblColName\\\": \\\"VCH_NAME\\\", \\\"ctrlTblColType\\\": \\\"VARCHAR\\\", \\\"ctrlTblColLength\\\": \\\"30\\\", \\\"ctrlTblColDeafult\\\": \\\"Null\\\", \\\"ctrlTblColParentTbl\\\": \\\"\\\", \\\"ctrlTblColConstraints\\\": \\\"\\\", \\\"ctrlTblColParentTblClmName\\\": \\\"\\\"}], \\\"addmorecalculationDetails\\\": [{\\\"ctrlChkCalculation\\\": false, \\\"addmorectrlCalcOptions\\\": []}], \\\"addmorecascadingCtrlDetails\\\": [{\\\"ctrlCCDAlias\\\": \\\"\\\", \\\"ctrlCCDTableName\\\": \\\"\\\", \\\"ctrlCCDConditions\\\": \\\"\\\", \\\"ctrlCCbindDatatype\\\": \\\"\\\", \\\"ctrlCCbinddecldClm\\\": \\\"\\\", \\\"AMctrlCCbinddepentfld\\\": \\\"0\\\", \\\"ctrlCCDTextColumnName\\\": \\\"\\\", \\\"ctrlCCDValueColumnName\\\": \\\"\\\", \\\"AMctrlCCbinddepentOther\\\": \\\"no\\\", \\\"addmorectrlStaticOptions\\\": []}]}, {\\\"ctrlId\\\": \\\"ctrl_01302023030653\\\", \\\"ctrlName\\\": \\\"ctrl_01302023030653\\\", \\\"ctrlSlNo\\\": \\\"2\\\", \\\"ctrlClass\\\": \\\"\\\", \\\"ctrlLabel\\\": \\\"Education\\\", \\\"ctrlTypeId\\\": \\\"3\\\", \\\"ctrlFileType\\\": \\\"0\\\", \\\"ctrlhelptext\\\": \\\"\\\", \\\"ctrlLabelData\\\": \\\"\\\", \\\"ctrlMandatory\\\": true, \\\"ctrlMaxLength\\\": \\\"\\\", \\\"ctrlMinLength\\\": \\\"\\\", \\\"ctrlTableName\\\": \\\"\\\", \\\"ctrlForApproval\\\": false, \\\"ctrlLabelinOdia\\\": \\\"\\\", \\\"ctrlPlaceholder\\\": \\\"\\\", \\\"ctrlFileSizeType\\\": \\\"0\\\", \\\"ctrlAttributeType\\\": \\\"0\\\", \\\"ctrlFileMaxLength\\\": \\\"\\\", \\\"validationDetails\\\": \\\"0\\\", \\\"ctrlOthervalidation\\\": \\\"\\\", \\\"addmoretablecolDetails\\\": [{\\\"ctrlTblColName\\\": \\\"VCH_EDUCATION\\\", \\\"ctrlTblColType\\\": \\\"VARCHAR\\\", \\\"ctrlTblColLength\\\": \\\"30\\\", \\\"ctrlTblColDeafult\\\": \\\"Null\\\", \\\"ctrlTblColParentTbl\\\": \\\"\\\", \\\"ctrlTblColConstraints\\\": \\\"\\\", \\\"ctrlTblColParentTblClmName\\\": \\\"\\\"}], \\\"addmorecalculationDetails\\\": [{\\\"ctrlChkCalculation\\\": false, \\\"addmorectrlCalcOptions\\\": []}], \\\"addmorecascadingCtrlDetails\\\": [{\\\"ctrlCCDAlias\\\": \\\"\\\", \\\"ctrlCCDTableName\\\": \\\"\\\", \\\"ctrlCCDConditions\\\": \\\"\\\", \\\"ctrlCCbindDatatype\\\": \\\"static\\\", \\\"ctrlCCbinddecldClm\\\": \\\"\\\", \\\"AMctrlCCbinddepentfld\\\": \\\"0\\\", \\\"ctrlCCDTextColumnName\\\": \\\"\\\", \\\"ctrlCCDValueColumnName\\\": \\\"\\\", \\\"AMctrlCCbinddepentOther\\\": \\\"no\\\", \\\"addmorectrlStaticOptions\\\": [{\\\"ctrlCCStaticName\\\": \\\"10th\\\", \\\"ctrlCCStaticValue\\\": \\\"1\\\", \\\"ctrlCCStaticFieldValue\\\": \\\"0\\\"}, {\\\"ctrlCCStaticName\\\": \\\"+2\\\", \\\"ctrlCCStaticValue\\\": \\\"2\\\", \\\"ctrlCCStaticFieldValue\\\": \\\"0\\\"}, {\\\"ctrlCCStaticName\\\": \\\"BSC\\\", \\\"ctrlCCStaticValue\\\": \\\"3\\\", \\\"ctrlCCStaticFieldValue\\\": \\\"0\\\"}]}]}], \\\"addmorerowdata\\\": [{\\\"ctrlRowdataName\\\": \\\"level1\\\", \\\"ctrlRowdataSlNo\\\": \\\"1\\\"}, {\\\"ctrlRowdataName\\\": \\\"level2\\\", \\\"ctrlRowdataSlNo\\\": \\\"2\\\"}], \\\"ctrlforViePage\\\": false, \\\"ctrlForApproval\\\": false, \\\"ctrlHeadingType\\\": \\\"0\\\", \\\"ctrlLabelinOdia\\\": \\\"\\\", \\\"ctrlPlaceholder\\\": \\\"\\\", \\\"tablecolDetails\\\": [{\\\"ctrlTblColName\\\": \\\"\\\", \\\"ctrlTblColType\\\": \\\"0\\\", \\\"ctrlTblColLength\\\": \\\"\\\", \\\"ctrlTblColDeafult\\\": \\\"\\\", \\\"ctrlTblColParentTbl\\\": \\\"\\\", \\\"ctrlTblColConstraints\\\": \\\"\\\", \\\"ctrlTblColParentTblClmName\\\": \\\"\\\"}], \\\"ctrlFileSizeType\\\": \\\"0\\\", \\\"ctrlAttributeType\\\": \\\"0\\\", \\\"ctrlFileMaxLength\\\": \\\"\\\", \\\"dependctrlDetails\\\": [{\\\"ctrlChkDepend\\\": false, \\\"ctrlSelDependValue\\\": [\\\"0\\\"], \\\"ctrlSelDependParent\\\": \\\"0\\\"}], \\\"validationDetails\\\": \\\"0\\\", \\\"calculationDetails\\\": [{\\\"ctrlCalcOptions\\\": [], \\\"ctrlChkCalculation\\\": false}], \\\"ctrlOthervalidation\\\": \\\"\\\", \\\"cascadingCtrlDetails\\\": [{\\\"ctrlCCDAlias\\\": \\\"\\\", \\\"ctrlCCDTableName\\\": \\\"\\\", \\\"ctrlCCDConditions\\\": \\\"\\\", \\\"ctrlStaticOptions\\\": [], \\\"ctrlCCbindDatatype\\\": \\\"\\\", \\\"ctrlCCbinddecldClm\\\": \\\"\\\", \\\"ctrlCCbinddepentfld\\\": \\\"0\\\", \\\"ctrlCCDTextColumnName\\\": \\\"\\\", \\\"ctrlCCbinddepentOther\\\": \\\"no\\\", \\\"ctrlCCDValueColumnName\\\": \\\"\\\"}], \\\"ctrlOtherButtonClass\\\": \\\"0\\\", \\\"radioAddmoreviewtype\\\": \\\"table\\\"}, {\\\"ctrlId\\\": \\\"ctrl_01302023045122\\\", \\\"ctrlName\\\": \\\"ctrl_01302023045122\\\", \\\"ctrlSlNo\\\": \\\"3\\\", \\\"ctrlClass\\\": \\\"\\\", \\\"ctrlLabel\\\": \\\"State\\\", \\\"ctrlTypeId\\\": 3, \\\"ctrlbtnType\\\": \\\"0\\\", \\\"ctrlFileType\\\": \\\"0\\\", \\\"ctrlhelptext\\\": \\\"\\\", \\\"ctrlLabelData\\\": \\\"\\\", \\\"ctrlMandatory\\\": true, \\\"ctrlMaxLength\\\": \\\"\\\", \\\"ctrlMinLength\\\": \\\"\\\", \\\"ctrlTableName\\\": \\\"\\\", \\\"ctrlforSearch\\\": true, \\\"addmoreDetails\\\": [], \\\"addmorerowdata\\\": [], \\\"ctrlforViePage\\\": true, \\\"ctrlForApproval\\\": false, \\\"ctrlHeadingType\\\": \\\"0\\\", \\\"ctrlLabelinOdia\\\": \\\"\\\", \\\"ctrlPlaceholder\\\": \\\"\\\", \\\"tablecolDetails\\\": [{\\\"ctrlTblColName\\\": \\\"VCH_STATE\\\", \\\"ctrlTblColType\\\": \\\"VARCHAR\\\", \\\"ctrlTblColLength\\\": \\\"30\\\", \\\"ctrlTblColDeafult\\\": \\\"Null\\\", \\\"ctrlTblColParentTbl\\\": 0, \\\"ctrlTblColConstraints\\\": \\\"\\\", \\\"ctrlTblColParentTblClmName\\\": 0}], \\\"ctrlFileSizeType\\\": \\\"0\\\", \\\"ctrlAttributeType\\\": \\\"0\\\", \\\"ctrlFileMaxLength\\\": \\\"\\\", \\\"dependctrlDetails\\\": [{\\\"ctrlChkDepend\\\": false, \\\"ctrlSelDependValue\\\": [\\\"0\\\"], \\\"ctrlSelDependParent\\\": 0}], \\\"validationDetails\\\": \\\"0\\\", \\\"calculationDetails\\\": [{\\\"ctrlCalcOptions\\\": [], \\\"ctrlChkCalculation\\\": false}], \\\"ctrlOthervalidation\\\": \\\"\\\", \\\"cascadingCtrlDetails\\\": [{\\\"ctrlCCDAlias\\\": \\\"\\\", \\\"ctrlCCDTableName\\\": \\\"\\\", \\\"ctrlCCDConditions\\\": \\\"\\\", \\\"ctrlStaticOptions\\\": [{\\\"ctrlCCStaticName\\\": \\\"Odisha\\\", \\\"ctrlCCStaticValue\\\": \\\"1\\\", \\\"ctrlCCStaticFieldValue\\\": \\\"0\\\"}, {\\\"ctrlCCStaticName\\\": \\\"Bihar\\\", \\\"ctrlCCStaticValue\\\": \\\"2\\\", \\\"ctrlCCStaticFieldValue\\\": \\\"0\\\"}], \\\"ctrlCCbindDatatype\\\": \\\"static\\\", \\\"ctrlCCbinddecldClm\\\": \\\"\\\", \\\"ctrlCCbinddepentfld\\\": \\\"0\\\", \\\"ctrlCCDTextColumnName\\\": \\\"\\\", \\\"ctrlCCbinddepentOther\\\": \\\"no\\\", \\\"ctrlCCDValueColumnName\\\": \\\"\\\"}], \\\"ctrlOtherButtonClass\\\": \\\"0\\\", \\\"radioAddmoreviewtype\\\": \\\"0\\\"}]\",\"DEMO_RESUB_TABLE\"]]";

        JSONArray jsonArray = new JSONArray(data);
        System.out.println("JSON Array: " + jsonArray);

        JSONArray jsonArray1 = jsonArray.getJSONArray(0);
        String name = jsonArray1.getString(1);

        String info = jsonArray1.getString(0);
        System.out.println("Info: " + info);

        JSONArray jsonArray2 = new JSONArray(info);
        System.out.println("Information : " + jsonArray2);

//        System.out.println("JSON Array 2: " + jsonArray2);
//        for (int i = 0; i < jsonArray2.length(); i++) {
//            JSONObject jsonObject = jsonArray2.getJSONObject(i);
//            System.out.println("JSON Object: " + jsonObject);
//            System.out.println("CTRL Id : " + jsonObject.getString("addmoreDetails"));
//        }
    }
}
