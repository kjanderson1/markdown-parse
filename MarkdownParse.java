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
                for(int i = lineArray.length - 1; i > 0; i--) {
                    if(lineArray[i].equals("(") && lineArray[i-1].equals("]")) {
                        startIndex = i + 1;
                    }
                }
                toReturn.add(s.substring(startIndex, s.length() - 1));
            }
        }
        return toReturn;
    }
    public static boolean isOfLinkForm(String s){
        int firstBracket = s.indexOf("[");
        int secondBracket = s.indexOf("]");
        boolean containerGood = false;
        String linkContainer = "";
        //this obtains the whole container like [Link]
        if (firstBracket >= 0 && secondBracket >= 0)
            linkContainer = s.substring(firstBracket,secondBracket+1);
        //link container would be valid if it's length is greater than 2 (it's not just "[]")
        if(linkContainer.length() > 2)
            containerGood = true;

        return containerGood && s.contains("(") && s.contains(")") && !s.startsWith("!");
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}