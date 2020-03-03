import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

    public static void serializeToXML (ArrayList<Product> productList) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("serializeFile.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });

        encoder.writeObject(productList);
//        for (Product object : proba)
//            encoder.writeObject(object);

        encoder.close();
        fos.close();
    }

    //deserialization
    public static ArrayList<Product> deserializeFromXML() throws IOException {

        FileInputStream fis = new FileInputStream("serializeFile.xml");
        XMLDecoder decoder = new XMLDecoder(fis);

        ArrayList<Product>  decodedList = ((ArrayList<Product>) decoder.readObject());

        decoder.close();
        fis.close();
        return decodedList;
    }

}
