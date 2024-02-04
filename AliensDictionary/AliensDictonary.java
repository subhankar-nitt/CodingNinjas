package AliensDictionary;

import java.util.*;
public class AliensDictonary{
	static int [] visited ;
	static int [][]graph;
	static Stack<Integer> st;
	public static void main(String[] args) {
		int k =12;

		String [] dictionary = {"bf","biifablhhfekcjfhdklefkiihffedfjkklldcbfdldddbf","bikjidjifidghfklddjchiebjbibdjadlgji","bkblijbgjbkillhcblbjacadceahebbcafichcjedhbajlfkei","bldgbfhkfdbcihbdkfejkdgikeclih","cbielkdheejdicfjfeclbdliidkdcfifdgehlleikkdb","cccfckhbglgfi","cjjgibfkgegchldfaclliejhhcbjickadahbcdkialldfb","eclbbfcjdfecfdkiblddaceclddfkaabjgalgiggacjdegf","efdjhebdfebhhccahifhaififjbadhc","eghcflfgkllde","eidbdkcjicecjaiddfdcjkfj","ejifhhdiclkkejdhidkhbhjdihbdkckfkgiidhadjdje","elacahafeeghdgkic","fag","fbeidhlbfhcbjebaegidflileilejkijdfjdkiclabdfjeejeg","gebfadchbgcikgkfifaga","gialjghjjhhedflkkdjlhajdkhdakhadkkajgllgllbghk","helekchjgeb","iehdjcjefggkcafllgedfhjhhiahgc","ike","ikgjliklfblbagfafe","ilfeajblklchcebejiggjhfbdcla","jdlfbhdfjbdblgcceihcgiaachlhlhjhcglhcaf","jeahcekiahlkidflijakdj","jfhgbkchhgckahefbjcgaceibkiehallgiffddchacigefa","jhlfhckghgkgfb","kfcahfciklbakdgehkgfadggdcjcfaijkjlffjf","kiidkhfcclldfceahaabjfgdi","kjbchgcbbdghhk","lfkdjkkeebibdidhjfkldkhecllebheehjhcaileeggafii","lhd","lkkkldcfbfekbjdfalhiddaiegkf","lljjjgj" };
		// String [] dictionary = {"baa","abcd","abca","cab","cad"};
		int N = dictionary.length;
		
		graph= new int [k][k];
		st=new Stack<>();
		int base = 97;

		for(int i=0;i<N-1;i++){
			String str1= dictionary[i];
			String str2 = dictionary[i+1];

			int m = str1.length();
			int n = str2.length();

			int index1 =0,index2=0;

			while(index1<m && index2<n){
				if(str1.charAt(index1)!=str2.charAt(index2)){
					   int src = str1.charAt(index1)-base;
					   int dest = str2.charAt(index2)-base;
						graph[src][dest]=1;
						break;
				}
				index1++;
				index2++;
			}
			
		}
		visited=new int[k];
		// for(int [] arr: graph){
		// 	System.out.println(Arrays.toString(arr));
		// }
		for(int i=0;i<k;i++){
			if(visited[i]!=1){
				topologicalSort(i);
			}
		}
		String res ="";
		while(!st.isEmpty()){
			int top =st.pop()+97;
			char ascii = (char)top;
			res += Character.toString(ascii);
		}
		System.out.println(res);
	}
	public static void topologicalSort(int src){
		 if(visited[src]==1)
		 	return;
		visited[src]=1;
		int [] ele = graph[src];
		for(int i=0;i<ele.length;i++){
			if(ele[i]!=0 && visited[i]!=1){
				topologicalSort(i);
			}
		}
		st.push(src);
	}
}