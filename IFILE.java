import java.io.FileNotFoundException;
import java.io.IOException;

interface IFILE{
    void enterFile() throws FileNotFoundException , IOException;
    void exportFile() throws IOException; 
}