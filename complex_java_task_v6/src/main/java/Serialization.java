import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Serialization {

    public static void serializeToXML (ArrayList<Product> productList) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("src/main/resources/serializeFile.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });

        encoder.writeObject(productList);

        encoder.close();
        fos.close();
    }

    //deserialization
    public static ArrayList<Product> deserializeFromXML() throws IOException {

        FileInputStream fis = new FileInputStream("src/main/resources/serializeFile.xml");
        XMLDecoder decoder = new XMLDecoder(fis);

        ArrayList<Product>  decodedList = ((ArrayList<Product>) decoder.readObject());

        decoder.close();
        fis.close();
        return decodedList;
    }

}
