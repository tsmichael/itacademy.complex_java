import java.util.Comparator;

public class SortOrders {

    public static Comparator<Product> ModelComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            String ModelName1 = p1.getModel().toUpperCase();
            String ModelName2 = p2.getModel().toUpperCase();

            return ModelName1.compareTo(ModelName2);
        }
    };

    public static Comparator<Product> BrandComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            String BrandName1 = p1.getBrand().toUpperCase();
            String BrandName2 = p2.getBrand().toUpperCase();

            return BrandName1.compareTo(BrandName2);
        }
    };
}
