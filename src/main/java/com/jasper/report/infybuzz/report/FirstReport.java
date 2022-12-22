package com.jasper.report.infybuzz.report;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FirstReport {

	public static void main(String[] args) {
		
		try {
			String filePath = "C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.15.2.RELEASE"
					               + "\\Jasper-Report\\src\\main\\resources\\FirstReport.jrxml";
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("studentName", "John");
			
			Student student1 = new Student(1L, "Zaid", "Siddiqui", "Street", "Mumbai");
			
			Student student2 = new Student(1L, "Brock", "Lesnar", "F5 Street", "Delhi");
			
			List<Student> list = new ArrayList<Student>();
			list.add(student1);
			list.add(student2);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
			
			JasperReport report = JasperCompileManager.compileReport(filePath);
			
			JRBaseTextField textField = (JRBaseTextField) report.getTitle().getElementByKey("name");
			
			textField.setForecolor(Color.RED);
			
			JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
			
			JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\DELL\\Desktop\\First Report");
			
			System.out.println("Report Created...");
			
		} catch(Exception e) {
			System.out.println("Exception while creating report");
		}
	}
}
