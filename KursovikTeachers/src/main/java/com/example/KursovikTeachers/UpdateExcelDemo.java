package com.example.KursovikTeachers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class UpdateExcelDemo {

    public static void main(String[] args) throws IOException {

        System.out.println("Выберете учителя (1-русский язык, 2 - математика, 3 - информатика):");

        Scanner scanner = new Scanner(System.in);
        int TeacherNumber = scanner.nextInt();
        if (TeacherNumber <= 3) {
            System.out.println("Вы выбрали учителя под номером: " + TeacherNumber);
        } else {
            System.out.println("Ошибочка! В базе всего 3 учителя");
        }
        String SecondName = "Фамилия: ";
        String Name = "Имя: ";
        String ThirdName = "Отчество: ";
        String NameSubject = "Преподаваемый предмет: ";

        switch (TeacherNumber) {
            case 1:
                System.out.println(SecondName + "Альшина\n" + Name + "Эльвира\n" + ThirdName + "Анверовна\n" + NameSubject + "русский язык");
                File file = new File("D:\\intellij idea\\Projects\\Teacher russian language.xls");
                // Read XSL file
                FileInputStream inputStream = new FileInputStream(file);

                // Get the workbook instance for XLS file
                HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

                // Get first sheet from the workbook
                HSSFSheet sheet = workbook.getSheetAt(0);
                System.out.println("Введите значение для ячейки : ");

                float IncreaseNumber = scanner.nextFloat();
                HSSFCell cell = sheet.getRow(1).getCell(5);
                cell.setCellValue(cell.getNumericCellValue() + IncreaseNumber);

                inputStream.close();

                // Write File
                FileOutputStream out = new FileOutputStream(file);
                workbook.write(out);
                out.close();
                break;
            case 2:
                System.out.println(SecondName + "Капшина\n" + Name + "Татьяна\n" + ThirdName + "Юрьевна\n" + NameSubject + "математика");
                File file2 = new File("D:\\intellij idea\\Projects\\Teacher mathematics.xls");
                // Read XSL file
                FileInputStream inputStream2 = new FileInputStream(file2);

                // Get the workbook instance for XLS file
                HSSFWorkbook workbook2 = new HSSFWorkbook(inputStream2);

                // Get first sheet from the workbook
                HSSFSheet sheet2 = workbook2.getSheetAt(0);
                System.out.println("Введите значение для ячейки : ");

                float IncreaseNumber2 = scanner.nextFloat();
                HSSFCell cell2 = sheet2.getRow(1).getCell(5);
                cell2.setCellValue(cell2.getNumericCellValue() + IncreaseNumber2);

                inputStream2.close();

                // Write File
                FileOutputStream out2 = new FileOutputStream(file2);
                workbook2.write(out2);
                out2.close();
                break;

        }

    }
}