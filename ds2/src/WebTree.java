import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
	public ArrayList<String> titleList=new ArrayList<String>();
	public String title;
	public WebNode root;
	public double score;
	public WebTree(WebNode root) {
		this.root = root;
	}

	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException {
		setPostOrderScore(root, keywords);
	}

	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException {
		// 1. compute the score of children nodes
		// 2. setNode score of startNode
		startNode.setNodeScore(keywords);
		for (int i = 0; i < startNode.children.size(); i++) {
			startNode.children.get(i).setNodeScore(keywords);
			startNode.nodeScore += startNode.children.get(i).nodeScore;
			score = startNode.nodeScore;
		//	System.out.println(startNode.nodeScore);
		}
	}

	public void addChild(WebNode child) {
		// add the WebNode to its children list
		root.addChild(child);
	}
	
	public void eularPrintTree() {
		eularPrintTree(root);
	}

	private void eularPrintTree(WebNode startNode) {
		int nodeDepth = startNode.getDepth();

		if (nodeDepth > 1)
			System.out.print("\n" + repeat("\t", nodeDepth - 1));
		System.out.print("(");
		System.out.print(startNode.nodeScore);
	//	System.out.print("\n");
		for (WebNode child : startNode.children) {
			eularPrintTree(child);
		}
		System.out.print(")");
		if (startNode.isTheLastChild())
			System.out.print("\n" + repeat("\t", nodeDepth - 2));

	}

	private String repeat(String str, int repeat) {
		String retVal = "";
		for (int i = 0; i < repeat; i++) {
			retVal += str;
		}
		return retVal;
	}

	public double getScore() {
		return score;
	}

	public ArrayList<String> construct() throws IOException {
		WordCounter w = new WordCounter(root.webPage.url);
		String content = w.fetchContent();
		ArrayList<String> childUrls = new ArrayList<String>();
		/**while (content.indexOf("href=\"") != -1) {
			content = content.substring(content.indexOf("href=\"") + 6);
			childUrls.add(content.substring(0, content.indexOf(">")));
			content = content.substring(content.indexOf(">"));
		}*/
		/**while (content.indexOf("<title>") != -1) {
			content = content.substring(content.indexOf("<title>") + 7);
			titleList.add(content.substring(0, content.indexOf("<")));
			content = content.substring(content.indexOf(">"));
		}*/
	//	for(int j=0;j<10;j++) {
	//	for (String u : childUrls) {
		//	this.addChild(new WebNode(new WebPage(childUrls.get(j))));
			//this.addChild(new WebNode(new WebPage(u)));
			//WebNode we=new WebNode(new WebPage(u));
			//we.setPostOrderScore();
			//System.out.println(u);
			//System.out.println(childUrls.get(j));
		//}
		return childUrls;
	}
	public ArrayList<String> getT()throws IOException{
		return titleList;
	}
	public double getscore() {
		return score;
	}
}