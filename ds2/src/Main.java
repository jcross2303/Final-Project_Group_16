import java.util.ArrayList;
import java.util.Collections;

public class Main 
{	

	public static void main(String[] args) throws Exception 
	{
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		keywords.add(new Keyword("Jordan", 5));
		keywords.add(new Keyword("Puma", 5));
		keywords.add(new Keyword("Nike", 5));
		keywords.add(new Keyword("Underarmour", 5));
		keywords.add(new Keyword("vans", 5));
		keywords.add(new Keyword("Balenciaga", 5));
		keywords.add(new Keyword("聯名", 10));
		keywords.add(new Keyword("配色", 10));
		keywords.add(new Keyword("限定", 10));
		keywords.add(new Keyword("Collab", 5));
		keywords.add(new Keyword("球鞋", 5));
		ArrayList<String> url = new ArrayList<String>();
		ArrayList<WebTree> wbts = new ArrayList<WebTree>();
		System.out.println("hey");
		url.add("https://www.nike.com/tw/zh_tw/c/jordan");
		url.add("http://soslab.nccu.edu.tw/Courses.html");
		url.add("https://www.underarmour.tw/");
		url.add("https://hk.puma.com/");
		url.add("http://www.vanstaiwan.com/items.php?for=men&type=shoes");
		System.out.println("yeet");
		for (String i : url) {
			WebNode n = new WebNode(new WebPage(i));
			WebTree w = new WebTree(n);
			wbts.add(w);
		//	w.construct();
			//WebNode t = new WebNode(new WebPage("https://www.nike.com/tw/zh_tw/c/jordan"));
			//w.addChild(t);
		/**for(int j=0;j<2;j++) {
				String k=w.construct().get(j);
				//System.out.println(k);
				//String k=w.construct();
			//	WebNode f = new WebNode(new WebPage(k));
				//w.addChild(f);
			}*/
			
		}
		WebTreeList nw=new WebTreeList();
		for (WebTree wbt : wbts) 
		{
			wbt.setPostOrderScore(keywords);
			//wbt.eularPrintTree();
			System.out.println(wbt.root.webPage.url);
			System.out.println(wbt.root.webPage.score);
			nw.add(wbt);
		}		
		nw.sortie();
		for(int i=0;i<wbts.size();i++) 
		{
			System.out.println(nw.get(i).root.webPage.url);
		}
	}
}	
		