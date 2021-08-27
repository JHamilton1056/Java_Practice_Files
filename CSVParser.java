public class parsingTempCSV {
    
    public CSVRecord hottestHourInFile(CSVParser parser) {
        
        CSVRecord largestSoFar = null;
        
        for (CSVRecord currentRow : parser) {
         largestSoFar = largestOfTwoTemps(currentRow,largestSoFar);
        }
        return largestSoFar;
    }
    
    public CSVRecord hottestInManyDays() {
        
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
  
        for(File f : dr.selectedFiles()) {
        FileResource fr = new FileResource(f);  
        CSVRecord current = hottestHourInFile(fr.getCSVParser());
            if(largestSoFar == null) {
                largestSoFar = current;
            }
            else {
                largestSoFar = largestOfTwoTemps(current, largestSoFar);
            }
        }
        return largestSoFar;
    }
    
    public String fileWithColdestTemperature () {
        
        String coldestFile = "";
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        for(File f : dr.selectedFiles()) {
         FileResource fr = new FileResource(f);
         
         CSVRecord current = coldestHourInFile(fr.getCSVParser());
            if(coldestSoFar == null) {
             coldestFile = f.toString();
            }
            else {
             coldestSoFar = smallestOfTwoTemps(current, coldestSoFar);
             coldestFile = coldestSoFar.toString();
            }
        }
        return coldestFile;
    }
    
    public CSVRecord coldestHourInFile (CSVParser parser) {
            
        CSVRecord tempColdest = null;
        
        for (CSVRecord currentRow : parser ) {
            tempColdest = smallestOfTwoTemps(currentRow, tempColdest);
        }
        return tempColdest;
    } 
    
    public CSVRecord lowestHumidityInFile (CSVParser parser) {
        
        CSVRecord lowestHumidity = null;
        
        for(CSVRecord currentRow : parser) {
            lowestHumidity = lowestOfTwoHumidities(currentRow, lowestHumidity);
        }
       
        return lowestHumidity;
    }
    
    public CSVRecord smallestOfTwoTemps (CSVRecord currentRow, CSVRecord coldestSoFar) {
        if (coldestSoFar == null) {
            coldestSoFar = currentRow;
        }
        else {
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
        if(currentTemp < coldestTemp) {
            coldestSoFar = currentRow;
        }
        }
        return coldestSoFar;
    }
    
    public CSVRecord lowestOfTwoHumidities (CSVRecord currentRow, CSVRecord lowestHumidity) {
        if (lowestHumidity == null) {
            lowestHumidity = currentRow;
        }
        else {
        double currentHumid = Double.parseDouble(currentRow.get("Humidity"));
        double lowHumidity = Double.parseDouble(lowestHumidity.get("Humidity"));
        if(currentHumid < lowHumidity) {
            lowestHumidity = currentRow;
        }
        }
        return lowestHumidity;
    }
    
    public CSVRecord largestOfTwoTemps (CSVRecord currentRow, CSVRecord largestSoFar) {
        
        if (largestSoFar == null) {
            largestSoFar = currentRow;
        }
        else {
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
        if (currentTemp > largestTemp) {
            largestSoFar = currentRow;
        }
        }
    
        return largestSoFar;
    }
    
    public void hotTest () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord largest = hottestHourInFile(parser);
        System.out.println("Date : " + largest.get("DateUTC"));
        System.out.println("Hottest Temp: " + largest.get("TemperatureF"));
        System.out.println("Time of Occurrence: " + largest.get("TimeEST"));
    }
    
    public void testColdestHourInFile () {
        FileResource fr =  new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldest = coldestHourInFile(parser);
        System.out.println("Date : " + coldest.get("DateUTC"));
        System.out.println("Coldest Temp: " + coldest.get("TemperatureF"));
        System.out.println("Time of Occurrence: " + coldest.get("TimeEST"));
    }
    
    public void testHumidFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord humid = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was " + humid.get("Humidity") + " at " + 
                                                    humid.get("DateUTC"));
    }
    
    public void testFileWithColdest () {
        String coldFilePath = fileWithColdestTemperature();
        FileResource fr = new FileResource(coldFilePath);
        CSVParser parser = fr.getCSVParser();
        
        CSVRecord coldest = coldestHourInFile(parser);
        System.out.println("Coldest temp was in file : " + coldFilePath);
        System.out.println("Date : " + coldest.get("DateUTC"));
        for (CSVRecord currentRow : parser ) {
        System.out.println(coldest.get("TemperatureF"));
        }
    }
    
    public void testManyDays () {
        CSVRecord largest = hottestInManyDays();
        System.out.println(largest.get("TemperatureF"));
    }
}