package ar.edu.unlam.scaw.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServicioPasswordSegura")
@Transactional
public class ServicioPasswordSeguraImpl implements ServicioPasswordSegura {

	@Override
	public Boolean isACommonPassword(String password) throws IOException {
		String line;
        BufferedReader in;

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource("common-and-spanish.txt");
        File file = null;
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
           file = new File(resource.getFile());
        }
        in = new BufferedReader(new FileReader(file));

        line = in.readLine();

        while(line != null)
        {
        	if (password.equals(line.trim()))
        		return true;
            line = in.readLine();
        }
        in.close();
        return false;
	}

	

}
