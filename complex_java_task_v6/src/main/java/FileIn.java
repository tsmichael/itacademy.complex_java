import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileIn {

    public static void inputToFile(ArrayList<Product> productList) throws IOException {
        String FileName = "src/main/resources/savedListObjects.txt";

        FileWriter nFile = new FileWriter(FileName);

        for(Product object : productList){
            String fileContent = object.getBrand() + ","+ object.getModel() + "," + object.getProductionDate();

            if(object instanceof FoodProduct){
                fileContent+=  "," +((FoodProduct) object).getFoodType() + "," +((FoodProduct) object).getSuitabilityDuration();
            }

            fileContent+= "\n";
            nFile.write(fileContent);
        }
        nFile.close();}
}
