package com.example.KursovikTeachers;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class Column extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

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
                FileInputStream inputStream = new FileInputStream("D:\\intellij idea\\Projects\\Teacher russian language.xls");
                // Get the workbook instance for XLS file
                HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

                // Get first sheet from the workbook
                HSSFSheet sheet = workbook.getSheetAt(0);
                //rowindex -  номер строки
                //cellnum - номер ячейки
                HSSFCell cell1 = sheet.getRow(1).getCell(2);
                HSSFCell cell2 = sheet.getRow(1).getCell(3);
                HSSFCell cell3 = sheet.getRow(1).getCell(4);

                inputStream.close();
                CategoryAxis xAxis = new CategoryAxis();

                NumberAxis yAxis = new NumberAxis();
                yAxis.setLabel("Проценты");

                // Create a BarChart
                BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

                // Series 1 - Data of 2014
                XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
                dataSeries1.setName(SecondName + "Альшина\n" + Name + "Эльвира\n" + ThirdName + "Анверовна\n" + NameSubject + "русский язык");

                dataSeries1.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2018", cell1.getNumericCellValue()));
                dataSeries1.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2019", cell2.getNumericCellValue() ));
                dataSeries1.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2020", cell3.getNumericCellValue() ));


                // Add Series to BarChart.
                barChart.getData().add(dataSeries1);

                barChart.setTitle("Результативность работы учителя");

                VBox vbox = new VBox(barChart);

                primaryStage.setTitle("JavaFX BarChart (o7planning.org)");
                Scene scene = new Scene(vbox, 400, 200);

                primaryStage.setScene(scene);
                primaryStage.setHeight(300);
                primaryStage.setWidth(400);

                primaryStage.show();break;
            case 2:
                System.out.println(SecondName + "Капшина\n" + Name + "Татьяна\n" + ThirdName + "Юрьевна\n" + NameSubject + "математика");
                FileInputStream inputStream2 = new FileInputStream("D:\\intellij idea\\Projects\\Teacher mathematics.xls");

                // Get the workbook instance for XLS file
                HSSFWorkbook workbook2 = new HSSFWorkbook(inputStream2);

                // Get first sheet from the workbook
                HSSFSheet sheet2 = workbook2.getSheetAt(0);
                //rowindex -  номер строки
                //cellnum - номер ячейки
                HSSFCell cell12 = sheet2.getRow(1).getCell(2);
                HSSFCell cell22 = sheet2.getRow(1).getCell(3);
                HSSFCell cell32 = sheet2.getRow(1).getCell(4);

                inputStream2.close();
                CategoryAxis xAxis2 = new CategoryAxis();

                NumberAxis yAxis2 = new NumberAxis();
                yAxis2.setLabel("Проценты");

                // Create a BarChart
                BarChart<String, Number> barChart2 = new BarChart<String, Number>(xAxis2, yAxis2);

                // Series 1 - Data of 2014
                XYChart.Series<String, Number> dataSeries12 = new XYChart.Series<String, Number>();
                dataSeries12.setName(SecondName + "Капшина\n" + Name + "Татьяна\n" + ThirdName + "Юрьевна\n" + NameSubject + "математика");

                dataSeries12.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2018", cell12.getNumericCellValue()));
                dataSeries12.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2019", cell22.getNumericCellValue() ));
                dataSeries12.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2020", cell32.getNumericCellValue() ));


                // Add Series to BarChart.
                barChart2.getData().add(dataSeries12);

                barChart2.setTitle("Результативность работы учителя");

                VBox vbox2 = new VBox(barChart2);

                primaryStage.setTitle("JavaFX BarChart (o7planning.org)");
                Scene scene2 = new Scene(vbox2, 400, 200);

                primaryStage.setScene(scene2);
                primaryStage.setHeight(300);
                primaryStage.setWidth(400);

                primaryStage.show();
                break;
            case 3:
                System.out.println(SecondName + "Барсукова\n" + Name + "Анастасия\n" + ThirdName + "Александровна\n" + NameSubject + "информатика");
                FileInputStream inputStream3 = new FileInputStream("D:\\intellij idea\\Projects\\Teacher information.xls");

                // Get the workbook instance for XLS file
                HSSFWorkbook workbook3 = new HSSFWorkbook(inputStream3);

                // Get first sheet from the workbook
                HSSFSheet sheet3 = workbook3.getSheetAt(0);
                //rowindex -  номер строки
                //cellnum - номер ячейки
                HSSFCell cell13 = sheet3.getRow(1).getCell(2);
                HSSFCell cell23 = sheet3.getRow(1).getCell(3);
                HSSFCell cell33 = sheet3.getRow(1).getCell(4);

                inputStream3.close();
                CategoryAxis xAxis3 = new CategoryAxis();

                NumberAxis yAxis3 = new NumberAxis();
                yAxis3.setLabel("Проценты");

                // Create a BarChart
                BarChart<String, Number> barChart3 = new BarChart<String, Number>(xAxis3, yAxis3);

                // Series 1 - Data of 2014
                XYChart.Series<String, Number> dataSeries13 = new XYChart.Series<String, Number>();
                dataSeries13.setName(SecondName + "Барсукова\n" + Name + "Анастасия\n" + ThirdName + "Александровна\n" + NameSubject + "информатика");

                dataSeries13.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2018", cell13.getNumericCellValue()));
                dataSeries13.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2019", cell23.getNumericCellValue() ));
                dataSeries13.getData().add(new XYChart.Data<String, Number>("ЕГЭ 2020", cell33.getNumericCellValue() ));


                // Add Series to BarChart.
                barChart3.getData().add(dataSeries13);

                barChart3.setTitle("Результативность работы учителя");

                VBox vbox3 = new VBox(barChart3);

                primaryStage.setTitle("JavaFX BarChart (o7planning.org)");
                Scene scene3 = new Scene(vbox3, 400, 200);

                primaryStage.setScene(scene3);
                primaryStage.setHeight(300);
                primaryStage.setWidth(400);

                primaryStage.show();
                break;
            default:
                System.out.println("В базе всего 3 учителя");
        }


    }

    public static int main() {
        String args = new String();
        Application.launch(args);
        return 0;
    }

}
