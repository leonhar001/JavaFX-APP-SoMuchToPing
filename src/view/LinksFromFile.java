package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinksFromFile {

	static private boolean isReaded = false;
	static private List<String> links = new ArrayList<>();
	static private String path = "src/linkList.txt";

	public LinksFromFile() {
	}

	public List<String> getLinksList() {
		if(!isReaded)
			readFile();
		List<String> toSend = links;
		return toSend;
	}

	public void readFile() {
        BufferedReader br = null;
        try {
            File file = new File(path); // java.io.File
            FileReader fr = new FileReader(file); // java.io.FileReader
            br = new BufferedReader(fr); // java.io.BufferedReader
            String line;
            while ((line = br.readLine()) != null) {
            	links.add(line);
            }
          }
          catch(IOException e) { e.printStackTrace();}
          finally
          {
              try { if (br != null) br.close(); }
              catch(IOException e) { e.printStackTrace(); }
          }
        isReaded = true;
	}

}
