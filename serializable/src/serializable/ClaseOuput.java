
package serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author carlo
 */
public class ClaseOuput extends ObjectOutputStream {

    public ClaseOuput(FileOutputStream f) throws IOException {
        super(f);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException{}
}
