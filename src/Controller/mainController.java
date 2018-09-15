package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;

import logic.countmatch;

/**
 * Servlet implementation class mainController
 */
@WebServlet("/mainController")
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag = request.getParameter("flag");

		if (flag.equals("tname")) {
			doSearch(request, response);
		}
	}

	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sname = request.getParameter("sname");
		String radio = request.getParameter("command");

		String[] countarray = sname.split(" ");
		for (int i = 0; i < countarray.length; i++) {

			if (radio.equals("0")) {

				Map<String, Integer> hashMap = new HashMap<String, Integer>();
				countmatch c1 = new countmatch();
				String name = countarray[0].toString();
				c1.countsearch(name);

				break;
			} else if (radio.equals("1")) {
				countmatch c1 = new countmatch();
				String name = countarray[0].toString();
				c1.pluralSearch(name);
				break;
			}

			else if (radio.equals("2")) {
				HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
				// String[] matchingword;
				countmatch c1 = new countmatch();
				String name = countarray[0].toString();

				File folder = new File("D:\\Computing Project Workspace\\SearchEngine-master\\src\\textfile\\");
				File[] listOfFiles = folder.listFiles();

				for (int k = 0; k < listOfFiles.length; k++) {
					if (listOfFiles[k].isFile()) {

						In in = new In("D:\\Computing Project Workspace\\SearchEngine-master\\src\\textfile\\"
								+ listOfFiles[k].getName());
						String textFiles = in.readAll();

						Scanner sc = new Scanner(textFiles);
						String x = sc.nextLine().replaceAll("[^a-zA-Z0-9]+", " ");

						StringTokenizer strToken = new StringTokenizer(x, " ");
						int cnt = 0;

						String token;

						while (strToken.hasMoreTokens()) {
							token = strToken.nextToken();
							String a = token.replaceAll("\"", " ");

							if (a != " ") {
								int check = c1.minDistance(name, token);
								hashMap.put(token, check);
							}
						}
					}
				}

				Map<Integer, String> map = sortByValues(hashMap);
				Set set2 = map.entrySet();
				Iterator iterator2 = set2.iterator();
				String[] words = new String[5];
				int kp = 0;

				System.out.println("Suggested words of the searched word\n");
				System.out.println("****************************************\n");
				while (iterator2.hasNext() && kp < 5) {
					Map.Entry me2 = (Map.Entry) iterator2.next();
					if (kp < 5) {
						System.out.println(me2.getKey());
						kp++;
					} else {
					}
				}
				break;
			}
		}
	}

	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println();
		return sortedHashMap;
	}

}
