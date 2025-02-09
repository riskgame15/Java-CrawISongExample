
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/top100/top-100-nhac-tre.m3liaiy6vVsF.html");
            // open the stream and put it into BufferedReader of Scanner
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            // InputStreamReader converts binary infor from url.openStream to characters
            scanner.useDelimiter("\\Z");    // scanner only stop at very end of file (not at \n or space)
            String content = scanner.next();
            scanner.close();

            // remove all new line
            content = content.replaceAll("\\n+", "");
            // regex
            Pattern p = Pattern.compile("name_song\" title=\"(.*?)\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(2));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

    }
}
