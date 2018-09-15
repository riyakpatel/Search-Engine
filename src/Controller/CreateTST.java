package Controller;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateTST {
	public static Trie trieObj = new Trie();

	public static void createTrie() {

		File folderAF = new File("D:\\Computing Project Workspace\\SearchEngine-master\\src\\textfile\\");
		File[] listOfFilesAF = folderAF.listFiles();

		int cnt = 0;
		String token;
		StringTokenizer strToken = null;

		for (int k = 0; k < listOfFilesAF.length; k++) {
			if (listOfFilesAF[k].isFile()) {

				In in = new In("D:\\Computing Project Workspace\\SearchEngine-master\\src\\textfile\\"
						+ listOfFilesAF[k].getName());
				String textFiles = in.readAll();
				Scanner sc = new Scanner(textFiles);
				String x = sc.nextLine().replaceAll("[^a-zA-Z0-9]+", " ");

				strToken = new StringTokenizer(x, " ");

				while (strToken.hasMoreTokens()) {

					token = strToken.nextToken();
					trieObj.insert(token.toLowerCase());
				}
			}
		}
	}
}
