package com.example.demo.utils;

import com.example.demo.dto.CropInsuranceDTO;
import com.example.demo.dto.csv.Tutorial;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Id", "Title", "Description", "Published"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Tutorial> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Tutorial> tutorials = new ArrayList<Tutorial>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Tutorial tutorial = new Tutorial(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Title"),
                        csvRecord.get("Description"),
                        Boolean.parseBoolean(csvRecord.get("Published"))
                );

                tutorials.add(tutorial);
            }

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<CropInsuranceDTO> csvToCropInsurance(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CropInsuranceDTO> crops = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            Optional<String> stringOpt = Optional.empty();
            for (CSVRecord csvRecord : csvRecords) {
                // Long.parseLong(csvRecord.get("Id")),
                //Boolean.parseBoolean(csvRecord.get("Published")
                CropInsuranceDTO crop = new CropInsuranceDTO();
                crop.setSerialNumber(Integer.parseInt(csvRecord.get("SERIALNO")));
                crop.setMandalName(csvRecord.get("MANDALNAME"));
                crop.setVillageName(csvRecord.get("VILLAGENAME"));
                crop.setNameOfTheBeneficiary(csvRecord.get("NAMEOFTHEBENEFICIARY"));
                crop.setCrop(csvRecord.get("CROP"));
                stringOpt = Optional.ofNullable(csvRecord.get("EXTENTHA")).filter(f -> null != f && f.trim().length() > 0);
                if (stringOpt.isPresent()) {
                    double d = Double.parseDouble(stringOpt.get());
                    int i = (int) d;
                    crop.setExtentHa(i);
                }
                stringOpt = Optional.ofNullable(csvRecord.get("CLAIMAMOUNTRS")).filter(f -> null != f && f.trim().length() > 0);
                if (stringOpt.isPresent()) {
                    double d = Double.parseDouble(stringOpt.get());
                    int i = (int) d;
                    crop.setClaimAmountRs(i);
                }
                crop.setCategoryLoaneeNonLoanee(csvRecord.get("CATEGORYLOANEENONLOANEE"));
                crop.setBankName(csvRecord.get("BANKNAME"));
                crop.setBranchName(csvRecord.get("BRANCHNAME"));
                crop.setAccountNumber(csvRecord.get("ACCOUNTNUMBER"));

                crops.add(crop);
            }

            return crops;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<Tutorial> tutorials) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Tutorial tutorial : tutorials) {
                List<String> data = Arrays.asList(
                        String.valueOf(tutorial.getId()),
                        tutorial.getTitle(),
                        tutorial.getDescription(),
                        String.valueOf(tutorial.isPublished())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
