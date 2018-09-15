package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class fileread {

	public int main(String fname){
		int count=0;
		try{
			HashMap<Character,String> hashMap= new HashMap<>();
			String[] s2= new String[5000000];
			File file = new File("E://krunalall2.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String s1;
			while ((s1 = bufferedReader.readLine()) != null) {
				s2=s1.split(" ");
				/*for(int i=0;i<s2.length;i++){
					String s3= Character.toString(s2[i].charAt(0));
					System.out.println(s3);

					System.out.println(s2[i].toString());
					hashMap.put(s2[i].charAt(0),s2[i]);
				}*/
				for(int i=0;i<s2.length;i++){
					if(s2[i].equals(fname)){
						//System.out.println(s2[i]);
						count++;
					}
					
				}
				/*for(int i=0;i<hashMap.size();i++){
					System.out.println(hashMap.get(fname));
				}*/
				
			}
			System.out.println(count);
			
			bufferedReader.close();

			// while(bufferedReader.read(cbuf,0, len)){
			// }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
}
