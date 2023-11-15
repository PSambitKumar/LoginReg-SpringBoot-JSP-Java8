package com.sambit.Utils;

import com.sambit.Bean.VitalParameterModelListWrapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 14-Nov-2023 : 6:05 PM
 */

public class XmlParser {
    public static void main(String[] args) {

//        For Genrating List From XML Code
        String xmlData = "<?xml version=\"1.0\" encoding=\"utf-16\"?>\n" +
                "<ArrayOfVitalParameterModel\n" +
                "    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <VitalParameterModel>\n" +
                "        <VITALSIGNID>2</VITALSIGNID>\n" +
                "        <VITALVALUE>123</VITALVALUE>\n" +
                "    </VitalParameterModel>\n" +
                "    <VitalParameterModel>\n" +
                "        <VITALSIGNID>4</VITALSIGNID>\n" +
                "        <VITALVALUE>132</VITALVALUE>\n" +
                "    </VitalParameterModel>\n" +
                "</ArrayOfVitalParameterModel>";

        List<Map<String, Object>> list = parseXml(xmlData);

        // Now 'list' contains the extracted data from XML
        for (Map<String, Object> map : list) {
            System.out.println("id: " + map.get("id") + ", value: " + map.get("value"));
        }

//        For Generate XML Code From List
        List<Map<String, Object>> list1 = new ArrayList<>();

        // Populate the list with sample data
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", 2);
        map1.put("value", 123);
        list1.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 4);
        map2.put("value", 132);
        list1.add(map2);

        // Generate XML from the list
        String xmlData1 = generateXml(list1);

        // Print the generated XML
        System.out.println(xmlData);
    }

    private static List<Map<String, Object>> parseXml(String xmlData) {
        List<Map<String, Object>> list = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            NodeList nodeList = document.getElementsByTagName("VitalParameterModel");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    Map<String, Object> map = new HashMap<>();
                    map.put("id", Integer.parseInt(element.getElementsByTagName("VITALSIGNID").item(0).getTextContent()));
                    map.put("value", Integer.parseInt(element.getElementsByTagName("VITALVALUE").item(0).getTextContent()));

                    list.add(map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private static String generateXml(List<Map<String, Object>> list) {
        try {
            // Create a JAXB context for the VitalParameterModel class
            JAXBContext context = JAXBContext.newInstance(VitalParameterModelListWrapper.class);

            // Create a marshaller
            Marshaller marshaller = context.createMarshaller();

            // Create a wrapper object for the list
            VitalParameterModelListWrapper wrapper = new VitalParameterModelListWrapper();
            wrapper.setList(list);

            // Marshal the wrapper object to XML
            StringWriter writer = new StringWriter();
            marshaller.marshal(wrapper, writer);

            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateXml1(List<Map<String, Object>> list) {
        StringBuilder xmlStringBuilder = new StringBuilder();

        xmlStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-16\"?>\n");
        xmlStringBuilder.append("<ArrayOfVitalParameterModel\n");
        xmlStringBuilder.append("    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n");
        xmlStringBuilder.append("    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n");

        for (Map<String, Object> map : list) {
            xmlStringBuilder.append("    <VitalParameterModel>\n");
            xmlStringBuilder.append("        <VITALSIGNID>").append(map.get("id")).append("</VITALSIGNID>\n");
            xmlStringBuilder.append("        <VITALVALUE>").append(map.get("value")).append("</VITALVALUE>\n");
            xmlStringBuilder.append("    </VitalParameterModel>\n");
        }

        xmlStringBuilder.append("</ArrayOfVitalParameterModel>");

        return xmlStringBuilder.toString();
    }
}

