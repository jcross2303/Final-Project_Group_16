import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;



public class GoogleQuery 

{

	public String searchKeyword;

	public String url;

	public String content;
	
	public String[] V_outlines =new String[15];
	public String[] U_outlines =new String[15];
	
	public HashMap<String, String> o = new HashMap<String, String>();
	public HashMap<String, String> u = new HashMap<String, String>();

	public GoogleQuery(String searchKeyword) throws UnsupportedEncodingException

	{

		this.searchKeyword = new String(searchKeyword.getBytes("UTF-8"),"UTF-8");
		//this.searchKeyword=searchKeyword.setEncoding("UTF-8");
		this.url = "http://www.google.com/search?q="+searchKeyword+"&ie=UTF-8&num=12";

	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	
	/*public ArrayList search() throws IOException
	{
		if(content==null)

		{

			content= fetchContent();

		}
		
	    String[] a = content.split("iUh30");
		String[] b = content.split("LC201b");
		
		return null;
		
	}*/
	
	public HashMap<String, String> query() throws IOException

	{

		if(content==null)

		{

			content= fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		System.out.println(doc.text());
		Elements lis = doc.select("div");
		lis = lis.select(".ZINbbc");
		System.out.println(lis.size());
		//---------------
		ArrayList<String> url = new ArrayList<String>();
		ArrayList<WebTree> wbts = new ArrayList<WebTree>();
		//String citeUrl3;
		//----------------
		int j=0;
		for(Element li : lis)
		{
			//i=0;
		//	for(int i=0; i<1000; i++) {
			try 
			{
			//	int i=0;
				String title2 = li.select(".BNeawe").get(0).text();
				System.out.println(title2);
				//System.out.println("step1");
				String outline = li.select(".BNeawe").get(3).text();
			//	if(outline.contains("評分"))
				//{
					//outline = li.select(".BNeawe").get(4).text();
				//}
				System.out.println(outline+"ˋ456789");
				
				o.put(title2, outline);
				
				System.out.println("step2");
				String citeUrl = li.select("a").get(0).attr("href");
				if(citeUrl.contains("/search")) 
					continue;	
				if((citeUrl.charAt(0)+"").equals("/")) {
					citeUrl = "http://www.google.com.tw" + citeUrl;
				    //url.add(citeUrl);
					u.put(title2, citeUrl);
				}
				    url.add(citeUrl);
					WebNode n = new WebNode(new WebPage(url.get(j)));
					WebTree w = new WebTree(n);
					//w.construct();
					wbts.add(w);
					//wbts.get(i).title=title2;
					wbts.get(j).titleList.add(title2);
				//	wbts.get(j).titleList.add(outline);
				//	System.out.println(wbts.get(j).titleList.get(0)+"tile在這裡喔");
			//	System.out.println(citeUrl+"\n");
				System.out.println(citeUrl);
				//url.add(citeUrl);
				
//				for(int i = 0 ; i < block.size(); i++)
//					System.out.println(block.get(i).text());
				
//				System.out.println(block.get(1).text());
//				System.out.println(block.get(2).text());
				
//				String title = block.get(1).text();
//				String citeUrl = block.get(2).text();
				
//				System.out.println(title+" "+citeUrl);

				//retVal.put(title2, citeUrl);

				//i++;
				j++;

			} catch (IndexOutOfBoundsException e) {

				e.printStackTrace();

			}
			//}
			//i++;

			

		}
		
		//----------新增------------------
		
		
		//建議搜尋球鞋
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		keywords.add(new Keyword("Jordan", 10));
		keywords.add(new Keyword("潮鞋", 1000));
		keywords.add(new Keyword("Puma", 50));
		keywords.add(new Keyword("Nike", 50));
		keywords.add(new Keyword("Underarmour", 5));
		keywords.add(new Keyword("vans", 5));
		keywords.add(new Keyword("Balenciaga", 5));
		keywords.add(new Keyword("聯名", 100));
		keywords.add(new Keyword("限定", 100));
		keywords.add(new Keyword("配色", 100));
		keywords.add(new Keyword("Collab", 5));
		keywords.add(new Keyword("球鞋", 5));
		keywords.add(new Keyword("男", 1000));
		keywords.add(new Keyword("女", -5000));
		keywords.add(new Keyword("喬丹", 1000));
		keywords.add(new Keyword("co-brand", 1000));
		keywords.add(new Keyword("converse", 1000));
		keywords.add(new Keyword("AJ", 1000));
		keywords.add(new Keyword("白鞋", 1000));
		keywords.add(new Keyword("adidas", 1000));
		keywords.add(new Keyword("愛迪達", 1000));
		keywords.add(new Keyword("sneaker", 1000));
		keywords.add(new Keyword("shoes", 1000));
		keywords.add(new Keyword("鞋", 100000));
		keywords.add(new Keyword("球鞋", 100000));
		keywords.add(new Keyword("stan smith", 1000));
		keywords.add(new Keyword("y-3", 1000));
		keywords.add(new Keyword("off-white", 1000));
		keywords.add(new Keyword("recommand", 10000));
		keywords.add(new Keyword("nmd", 1000));
		keywords.add(new Keyword("推薦", 100));
		keywords.add(new Keyword("ultra boost", 1000));
		keywords.add(new Keyword("alexander-mcqueen", 1000));
		
		
		
		//ArrayList<String> url = new ArrayList<String>();
		//ArrayList<WebTree> wbts = new ArrayList<WebTree>();
		//System.out.println("hey");
		//url.add("https://www.nike.com/tw/zh_tw/c/jordan");
		//url.add("http://soslab.nccu.edu.tw/Courses.html");
		//url.add("https://www.underarmour.tw/");
		//url.add("https://hk.puma.com/");
		//url.add("http://www.vanstaiwan.com/items.php?for=men&type=shoes");
		System.out.println("yeet");
		/**for (String i : url) {
			WebNode n = new WebNode(new WebPage(i));
			WebTree w = new WebTree(n);
			wbts.add(w);
			w.construct();
			WebNode t = new WebNode(new WebPage("https://www.nike.com/tw/zh_tw/c/jordan"));
			w.addChild(t);
		/**for(int j=0;j<2;j++) {//為甚麼是小於2?
				String k=w.construct().get(j);
				w.construct();
				System.out.println(k);
				String k=w.construct();
				WebNode f = new WebNode(new WebPage(k));
				w.addChild(f);
			}
			
		}*/
		WebTreeList nw=new WebTreeList();
		for (WebTree wbt : wbts) 
		{
			wbt.setPostOrderScore(keywords);
			//wbt.eularPrintTree();
			//System.out.println(wbt.root.webPage.url);
			//System.out.println(wbt.root.webPage.score);
			nw.add(wbt);
		}		
		nw.sortie();
		//System.out.println(nw);
		WebTreeList ya=new WebTreeList();
	//for(int i=0;i<wbts.size();i++) 
		for(int i=wbts.size()-1;i>0;i--) 
		{
			try {
				ya.add(nw.get(i));
				//String title=nw.get(i).titleList.get(0);
				//String title=i+"";
		//		String citeUrl2=nw.get(i).root.webPage.url;
			//	System.out.println(nw.get(i).root.webPage.url);
				//System.out.println(nw.get(i).root.webPage.score);
				//System.out.println(nw.get(i));
				//retVal.put(title, citeUrl2);
			}catch(IndexOutOfBoundsException e){
			//	e.printStackTrace();
			}
			//System.out.println(nw.get(i).root.webPage.url);
		}
		//return retVal;
		for(int p=0;p<wbts.size();p++) 
		{
			try {
				//ya.add(nw.get(i));
				String title=ya.get(p).titleList.get(0);
				//String title=i+"";
				String citeUrl2=ya.get(p).root.webPage.url;
				System.out.println(ya.get(p).root.webPage.url);
				System.out.println(ya.get(p).root.webPage.score);
				//System.out.println(nw.get(i));
				retVal.put(title, citeUrl2);
				
			}catch(IndexOutOfBoundsException e){
				e.printStackTrace();
			}
			//System.out.println(nw.get(i).root.webPage.url);
		}
		
		System.out.println("step3");
		System.out.println("step4");
		int num = 0;
		for(Entry<String, String> entry : retVal.entrySet()) 
		{
		    String key = entry.getKey();
		    String outL = this.o.get(key);
		    String outU = this.u.get(key);
		    V_outlines[num] = outL;
		    U_outlines[num] = outU;
		    num++;
		}
		System.out.println("step5");
		System.out.println(V_outlines);
		System.out.println(U_outlines);
		
		return retVal;

	}

	

	

}