package com.example.KursovikTeachers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcelDemo {

    public static int main() throws IOException {

        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File("D:\\intellij idea\\Projects\\Teacher information.xls"));

        // Получить экземпляр рабочей книги для файла XLS
        //Рабочая тетрадь HSSFWorkbook = новая рабочая тетрадь
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);


        //Получить первый лист из рабочей книги
        HSSFSheet sheet = workbook.getSheetAt(0);

        // Получить итератор для всех строк текущего листа
        // некое правило обхода элементов коллекции/массива данных
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Получить итератор для всех ячеек текущей строки
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // Измените на getCellType() при использовании POI 4.x
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case _NONE:
                    case BLANK:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("\t");
                        break;
                    case FORMULA:
                        // Formula
                        System.out.print(cell.getCellFormula());
                        System.out.print("\t");

                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        // Print out value evaluated by formula
                        System.out.print(evaluator.evaluate(cell).getNumberValue());
                        break;
                    case NUMERIC:
                        System.out.printf("%-16s",cell.getNumericCellValue());
                        System.out.print(" | ");
                        break;
                    case STRING:
                        System.out.printf("%-16s",cell.getStringCellValue());
                        System.out.print(" | ");
                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("\t");
                        break;
                }
            }
            System.out.println("");
        }

        return 0;
    }
}