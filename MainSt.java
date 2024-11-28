import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class MainSt {
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Lenovo\\Downloads\\students.xlsx";
        String outputFilePath = "C:\\Users\\Lenovo\\Downloads\\updated_students.xlsx";
        List<Student> students = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                int id = (int) row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String group = row.getCell(2).getStringCellValue();
                double scholarship = row.getCell(3).getNumericCellValue();
                double gpa = row.getCell(4).getNumericCellValue();
                String faculty = row.getCell(5).getStringCellValue();

                double newScholarship = calculateNewScholarship(scholarship, gpa, faculty);

                Student student = new Student(id, name, group, scholarship, gpa, faculty, newScholarship);
                students.add(student);}} catch (IOException e) {
            e.printStackTrace();}
        System.out.printf("%-5s %-20s %-20s %-20s %-20s\n", "ID", "Name", "Current Scholarship", "New Scholarship", "Increase");
        for (Student student : students) {
            double increase = student.getNewScholarship() - student.getScholarship();
            System.out.printf("%-5d %-20s %-20.2f %-20.2f %-20.2f\n", student.getId(),
                    student.getName(),
                    student.getScholarship(),
                    student.getNewScholarship(),
                    increase);}
        writeUpdatedData(outputFilePath, students);}
    private static double calculateNewScholarship(double scholarship, double gpa, String faculty) {
        double newScholarship = scholarship;
        switch (faculty.toLowerCase()) {
            case "engineering":
                if (gpa >= 2.4) {
                    newScholarship = scholarship * 1.10;}
                break;
            case "economics":
                if (gpa >= 2.4) {
                    newScholarship = scholarship * 1.15;}
                break;
            case "philosophy":
                if (gpa >= 2.2) {
                    newScholarship = scholarship * 1.05;}
                break;
            case "marketing":
                if (gpa >= 2.5) {
                    newScholarship = scholarship * 1.08;}
                break;
            default:
                System.out.println("Faculty: " + faculty + " is not recognized or GPA is below the required threshold.");}
        return newScholarship;}
    private static void writeUpdatedData(String filePath, List<Student> students) {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(filePath)) {
            Sheet sheet = workbook.createSheet("Updated Students");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Group");
            header.createCell(3).setCellValue("Scholarship");
            header.createCell(4).setCellValue("GPA");
            header.createCell(5).setCellValue("Faculty");
            header.createCell(6).setCellValue("New Scholarship");
            int rowNum = 1;
            for (Student student : students) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getName());
                row.createCell(2).setCellValue(student.getGroup());
                row.createCell(3).setCellValue(student.getScholarship());
                row.createCell(4).setCellValue(student.getGpa());
                row.createCell(5).setCellValue(student.getFaculty());
                row.createCell(6).setCellValue(student.getNewScholarship());}
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




