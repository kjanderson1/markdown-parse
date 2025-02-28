import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }
    ArrayList<String> emptyArrayList = new ArrayList<>();
    List<String> emptyStringList = List.of("");

    @Test
    public void getLinksBreakFile() throws IOException{
        Path fileName = Path.of("break-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://()something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest1() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest2() throws IOException{
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest3() throws IOException{
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://[]something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest4() throws IOException{
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https()www.link.com", "https()www.link.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest5() throws IOException{
        Path fileName = Path.of("test-file5.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("(thisisalink.com)"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest6() throws IOException{
        Path fileName = Path.of("test-file6.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest7() throws IOException{
        Path fileName = Path.of("test-file7.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("something.com", "something.com", "something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest8() throws IOException{
        Path fileName = Path.of("test-file8.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://www.parenthesis().com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest9() throws IOException{ //this returns an ArrayList with the empty string
        Path fileName = Path.of("test-file9.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest10() throws IOException{ //markdown does not format this as a link
        Path fileName = Path.of("test-file10.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest11() throws IOException{ //markdown does not format this as a link
        Path fileName = Path.of("test-file11.md");
        String contents = Files.readString(fileName);
        //assertEquals(emptyArrayList, MarkdownParse.getLinks(contents)); //this one runs fine when it's compared against an empty StringArrayList
        assertEquals(emptyStringList, MarkdownParse.getLinks("[]()")); //this throws an error
    }

    @Test
    public void getLinksTest12() throws IOException{ //markdown does not format this as a link
        Path fileName = Path.of("test-file12.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a-link.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest1() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest2() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest3() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file3.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest4() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file4.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest5() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file5.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest6() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file6.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest7() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file7.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest8() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file8.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksLabReportTest1() throws IOException{
        Path fileName = Path.of("./lab-report-test-files/test-1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"),
            MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksLabReportTest2() throws IOException{
        Path fileName = Path.of("./lab-report-test-files/test-2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a.com", "a.com(())", "example.com"),
            MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksLabReportTest3() throws IOException{
        Path fileName = Path.of("./lab-report-test-files/test-3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/"),
            MarkdownParse.getLinks(contents));
    
    @Test
    public void getLinksSnippet1Test() throws IOException{
        Path fileName = Path.of("snippet-1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com"), MarkdownParse.getLinks(contents));
    }
    
    @Test
    public void getLinksSnippet2Test() throws IOException{
        Path fileName = Path.of("snippet-2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a.com","a.com(())","example.com"), MarkdownParse.getLinks(contents));
    }
    
    @Test
    public void getLinksSnippet3Test() throws IOException{
        Path fileName = Path.of("snippet-3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://ucsd-cse15l-wi22.github.io/"), MarkdownParse.getLinks(contents));
    }
}
