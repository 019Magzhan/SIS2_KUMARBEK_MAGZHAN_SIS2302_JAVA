import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainSt {
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Lenovo\\Downloads\\students.xlsx";
        List<Student> students = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }


                String name = row.getCell(0).getStringCellValue();
                double currentScholarship = row.getCell(1).getNumericCellValue();
                double newScholarship = row.getCell(2).getNumericCellValue();

                Student student = new Student(name, currentScholarship, newScholarship);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%-15s %-20s %-20s %-20s\n", "Name", "Current Scholarship", "New Scholarship", "Increase");

        for (Student student : students) {
            System.out.printf("%-15s %-20.2f %-20.2f %-20.2f\n",
                    student.getName(),
                    student.getCurrentScholarship(),
                    student.getNewScholarship(),
                    student.getScholarshipIncrease());
        }
    }
}



