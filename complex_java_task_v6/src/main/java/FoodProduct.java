import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class FoodProduct extends Product{
    private String FoodType;
    private int SuitabilityDuration;

    public FoodProduct() {}

    public FoodProduct(String brand, String model, String stringDate, String foodType ,int suitabilityProduct) {
        super(brand, model, stringDate);
        FoodType = foodType;
        SuitabilityDuration = suitabilityProduct;
    }

    // set - get props
    public void setFoodType(String foodType) {
        FoodType = foodType;
    }

    public String getFoodType() {
        return FoodType;
    }

    public void setSuitabilityDuration(int suitabilityDuration) {
        SuitabilityDuration = suitabilityDuration;
    }

    public int getSuitabilityDuration() {
        return SuitabilityDuration;
    }

    //get the DATE of EXPIRATION
    public LocalDate getExpiredDateValue() {

        Calendar c = Calendar.getInstance();
        c.clear();

        // add to Calendar values of ProductionDate  < year , month , day >
        c.set(Calendar.YEAR, getProductionDate().getYear() );
        c.set(Calendar.MONTH, getProductionDate().getMonth().getValue()-1 );
        c.set(Calendar.DAY_OF_MONTH, getProductionDate().getDayOfMonth());

        // adding SuitabilityDuration to ProductionDate for finding [DATE - OF - EXPIRED]
        c.add(c.DAY_OF_MONTH, SuitabilityDuration);

        // [ Calendar to LocalDate ]
        LocalDate expDate = LocalDate.of(c.get(c.YEAR),c.get(c.MONTH),c.get(c.DAY_OF_MONTH));

        return expDate;
    }

    //output to console information of EXPIRATION of FoodProduct
    public void getExpiredDate(){

        LocalDate expDate = getExpiredDateValue();
        System.out.println("Expiration date : " +expDate);
    }

    //find values for FoodProducts which already expired
    public int outExpiredProducts(){
        // got date of EXPIRATION
        LocalDate expDate = getExpiredDateValue();
        //calculation <!> expired product OR not
        Period checkOfExpired = Period.between(currentTime,expDate);
        //return value(int) how many days product expired or how many days left to expired
        return checkOfExpired.getDays();
    }

    @Override
    public void input() throws IOException {
        super.input();
        System.out.println("Input Type of FoodProduct");
        this.FoodType = keyboard.readLine();

        System.out.println("Input suitability for the FoodProduct");
        this.SuitabilityDuration = Integer.parseInt(keyboard.readLine());
    }

    @Override
    public void output() {
        super.output();
        System.out.println("FoodType : " + this.FoodType);
        System.out.println("SuitabilityDuration : " + this.SuitabilityDuration + " days");
    }

    @Override
    public String toString() {

        String info = "";
        info += "\nBelongs to [ FoodProduct ] ";
        info += "\nFood Type: " + FoodType;
        info += "\nProduct Brand : " + getBrand();
        info += "\nProduct Model :" + getModel();
        info += "\nDate of creation :" + getProductionDate();
        //info += "\nThis product is " + getAge() + " year(s)";
        info += "\nSuitabilityDuration: " + SuitabilityDuration + " days\n";
        //info += "\nExpiration date to: " + getExpiredDateValue();
        return info;

    }

}
