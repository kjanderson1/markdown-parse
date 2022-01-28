// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        String[] contentsArray = markdown.split("\n");
        for(String s: contentsArray) {
            String[] lineArray = s.split("");
            int startIndex = 0;
            if(lineArray[0].equals("[") && lineArray[lineArray.length - 1].equals(")")) {
                for(int i = lineArray.length - 1; i >= 0; i--) {
                    if(lineArray[i].equals("(")) {
                        startIndex = i + 1;
                        break;
                    }
                }
                toReturn.add(s.substring(startIndex, s.length() - 1));
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}