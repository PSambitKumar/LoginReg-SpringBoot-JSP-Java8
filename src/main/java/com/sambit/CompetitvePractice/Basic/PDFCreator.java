package com.sambit.CompetitvePractice.Basic;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 18-Apr-2024 : 11:40 AM
 */

public class PDFCreator {
    public static void createPDF(String filePath, Map<String, String> data) throws DocumentException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Add heading
            Font headingFont = FontFactory.getFont("Segoe UI", 16, Font.BOLD);
            Paragraph heading = new Paragraph("Patient Override Details", headingFont);
            heading.setAlignment(Element.ALIGN_CENTER);
            document.add(heading);

            // Add document generated on label
            Font labelFont = FontFactory.getFont("Segoe UI", 10, Font.NORMAL);
            Paragraph label = new Paragraph("Document Generated On: " + getCurrentDate(), labelFont);
            label.setAlignment(Element.ALIGN_CENTER);
            label.setSpacingAfter(20); // Add some space after label
            document.add(label);

            // Create a 4-column table
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100); // Make table fill entire width of page

            // Create fonts
            Font keyFont = FontFactory.getFont("Segoe UI", 12, Font.BOLD);
            Font valueFont = FontFactory.getFont("Segoe UI", 10, Font.NORMAL);

            // Add content to the PDF
            for (Map.Entry<String, String> entry : data.entrySet()) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(entry.getKey(), keyFont));
                PdfPCell cell2 = new PdfPCell(new Paragraph(entry.getValue(), valueFont));

                // Set cell properties
                cell1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
                cell1.setPadding(2); // Set padding inside the cell
                cell2.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
                cell2.setPadding(2); // Set padding inside the cell

                // Add cells to table
                table.addCell(cell1);
                table.addCell(cell2);
            }

            // Add the table to the document
            document.add(table);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        // Example data
        Map<String, String> data = Map.of(
                "Name", "SAMBIT PRADHAN",
                "Gender", "MALE",
                "Age", "34",
                "Aadhaar No", "XXXX XXXX 1303",
                "URN", "33333333",
                "Scheme Category", "BSKY-NABIN",
                "No Of Days", "5",
                "Purpose of Override Code", "Unblocking",
                "Description", "DESCRIPTION."
        );

        try {
            // Specify the location to save the PDF
            String filePath = "D:/example.pdf";
            createPDF(filePath, data);
            System.out.println("PDF created successfully at: " + filePath);
        } catch (DocumentException e) {
            System.out.println("Error creating PDF: " + e.getMessage());
        }
    }
}