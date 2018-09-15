package Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageCrawler {
	private static final int MAX_DEPTH = 3;
	private HashSet<String> links;

	public PageCrawler() {
		links = new HashSet<>();
	}

	public void getPageLinks(String URL, int depth) {
		if ((!links.contains(URL) && (depth <= MAX_DEPTH))) {
			System.out.println(">> Depth: " + depth + " [" + URL + "]");
			try {
				links.add(URL);

				Document document = Jsoup.connect(URL).get();
				Elements linksOnPage = document.select("a[href]");

				depth++;
				for (Element page : linksOnPage) {
					getPageLinks(page.attr("abs:href"), depth);
				}
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {

		String urlPattern_a = "http(s)?://([\\w-]+.)+[\\w-]+(/[\\w- ./?%&=])?";

		Pattern url = Pattern.compile(urlPattern_a);
		Matcher mURL;
		String strURL = "";
		PageCrawler objCrawler = new PageCrawler();
		File fileEntry = new File(
				"D:\\Computing Project Workspace\\SearchEngine-master\\src\\htmls\\About W3C Standards.htm");

		try {

			Document doc = Jsoup.parse(fileEntry, "UTF-8");

			String html = doc.html();

			mURL = url.matcher(html);

			while (mURL.find()) {
				strURL = mURL.group(0);
				objCrawler.getPageLinks(strURL, 1);
			}
		}

		catch (Exception e) {
		}
	}
}