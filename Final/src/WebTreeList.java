import java.util.ArrayList;

public class WebTreeList {
	
	ArrayList<WebTree> john = new ArrayList<WebTree>();
	public WebTreeList(){
		this.john = new ArrayList<WebTree>();
    }
	private void quicksort(double leftbound,double rightbound)
	{
		 if(leftbound>=rightbound) {
			   return;
			  }
			  double pivot = john.get((int) rightbound).root.webPage.score;
			  double swapIndex = leftbound;
			  //compare with pivot
			  for(double x=leftbound; x<rightbound; x++) {
			   if(john.get((int) x).root.webPage.score<=pivot) {
			    swap(x, swapIndex);
			    swapIndex=swapIndex+1;
			   }
			  }
			  swap(swapIndex,rightbound);
			  quicksort(swapIndex+1,rightbound);
			  quicksort(leftbound,swapIndex-1);
	}
	private void swap(double i, double j){
		WebTree temp = john.get((int) i);
		john.set((int) i, john.get((int) j));
		john.set((int) j, temp);
	}
	public void sortie(){
		quicksort(0, john.size()-1);
	}
	public void add(WebTree wbt) {
		// TODO Auto-generated method stub
		john.add(wbt);
	}
	public WebTree get(int i) 
	{
		return john.get(i);
	}
}
