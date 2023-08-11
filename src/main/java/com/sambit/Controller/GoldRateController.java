package com.sambit.Controller;

import com.sambit.Entity.MultiFileUpload;
import com.sambit.Entity.PriceDtl;
import com.sambit.Entity.ProductDtl;
import com.sambit.Repository.PriceDtlRepository;
import com.sambit.Repository.ProductDtlRepository;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Project : GoldJewelleryPriceCalculator
 * @Author : Sambit Kumar Pradhan
 * @Created On : 18/02/2023 - 10:26 AM
 */
@Controller
public class GoldRateController {

    @Autowired
    private PriceDtlRepository priceDtlRepository;

    @Autowired
    private ProductDtlRepository productDtlRepository;

    @GetMapping("/gold")
    public String index(Model model) {
        System.out.println("Inside Home");
        List<PriceDtl> priceDtlList = priceDtlRepository.findAll();
        model.addAttribute("priceDtlList", priceDtlList);
        return "gold";
    }

    @PostMapping(value = "/goldRateFileUpload")
    public String goldRateFileUpload(@RequestParam(value = "goldRate") Double goldRate,
                                      @RequestParam(value = "excelFileUpload") MultipartFile excelFileUpload,
                                     Model model) throws IOException {
        System.out.println("Inside Gold Rate File Upload");

        if (!excelFileUpload.isEmpty()) {
            String folderPath = "D:\\";
            byte[] bytes = excelFileUpload.getBytes();
            Path path = Paths.get(folderPath.trim() + "/" + excelFileUpload.getOriginalFilename().trim());
            Files.write(path, bytes);
            System.out.println("Full File Path: " + path);

            FileInputStream fileInputStream = new FileInputStream(path.toString());
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.println("Sheet Name : "+sheet.getSheetName());
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            System.out.println("Row Count : "+rowCount + ", Column Count : "+columnCount);

            for (int i = 1; i <= rowCount; i++) {
                ProductDtl productDtl = new ProductDtl();
                PriceDtl priceDtl = new PriceDtl();
                Double makingCharge = 0.0, gst = 0.0, net = 0.0, discountOnMakingCharge = 0.0;
                for (int j = 0; j < columnCount; j++) {
                    if (j == 0)
                        productDtl = productDtlRepository.getById(Integer.parseInt(Integer.toString((int)sheet.getRow(i).getCell(j).getNumericCellValue())));
                    if (j == 1)
                        makingCharge = sheet.getRow(i).getCell(j).getNumericCellValue() * productDtl.getWeight();
                    if (j == 2) {
                        net = makingCharge + (goldRate * productDtl.getWeight());
                        gst = net * sheet.getRow(i).getCell(j).getNumericCellValue() / 100;
                    }
                    if (j == 3)
                        discountOnMakingCharge = makingCharge * sheet.getRow(i).getCell(j).getNumericCellValue() / 100;

                    priceDtl.setProduct(productDtl);
                    priceDtl.setCurrentDate(new Date());
                    priceDtl.setCurrentGoldRatePerGram(goldRate);
                    priceDtl.setMakingChargeAfterDiscount(makingCharge - discountOnMakingCharge);
                    priceDtl.setGstAmount(gst);
                    priceDtl.setGrossAmount(net);
                    priceDtl.setNetPrice(net + gst);
                    priceDtlRepository.save(priceDtl);
                }
                System.out.println("Product Details : "+productDtl);
                System.out.println("Price Details : "+priceDtl);
                System.out.println("=====================================");
            }
        }
        List<PriceDtl> priceDtlList = priceDtlRepository.findAll();
        model.addAttribute("priceDtlList", priceDtlList);
        return "gold";
    }
}
