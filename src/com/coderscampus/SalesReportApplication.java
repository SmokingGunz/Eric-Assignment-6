package com.coderscampus;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesReportApplication {

	public static void main(String[] args) throws IOException {

		FileService fileService = new FileService();
		
		List<Sales> modelSReport = fileService.getData("modelS.csv");
		List<Sales> model3Report = fileService.getData("model3.csv");
		List<Sales> modelXReport = fileService.getData("modelX.csv");
		
		printReport(modelSReport, "Model S");
		printReport(model3Report, "Model 3");
		printReport(modelXReport, "Model X");
		
	}
	
	private static void printReport (List<Sales> salesReport, String make) {
		
		System.out.println(make + " Yearly Sales Report");
		System.out.println("----------------------------------------------------------------");
		
		Map<Integer, List<Sales>> salesByYear = salesReport.stream()
														   .collect(Collectors.groupingBy(y -> y.getDate().getYear()));
		
		String totalSalesByYear = salesByYear.entrySet().stream()
				.map(e -> e.getKey() + " -> " + e.getValue().stream()
				.collect(Collectors.summingInt(Sales::getSales)))
                .collect(Collectors.joining("\n"));
		
        System.out.println(totalSalesByYear);
        
        System.out.println("");
		
        Optional<Sales> maxSales = salesReport.stream()
        									  .max((Sales o1, Sales o2) -> o1.getSales() - o2.getSales());
        
        Optional<Sales> minSales = salesReport.stream()
											  .min((Sales o1, Sales o2) -> o1.getSales() - o2.getSales());
        
        System.out.println("The best month for " + make + " was: " + maxSales.orElse(new Sales("Jan-00", "0")).getDate().format(DateTimeFormatter.ofPattern("MMMM-yyyy")));
		System.out.println("The worst month for " + make + " was: " + minSales.orElse(new Sales("Jan-00", "0")).getDate().format(DateTimeFormatter.ofPattern("MMMM-yyyy")));
		System.out.println("");
		
	}

}
