public class graph {
	
//Using a HashMap gr with all vertices as keys and address of class object vertext as value
	
private class vertex{
	//Stores neighbour vertices as keys and edge cost as value
	HashMap<String,Integer> nbr=new HashMap<>();
    }

HashMap<String,vertex> gr;

//Constructor to initialize HashMap gr
graph()
{
	gr=new HashMap<>();
}

//Function to return number of vertices
public int numVertices()
{
	return gr.size();
}

//Function to add a vertex
public void addVertex(String name)
{
	vertex v=new vertex();
	gr.put(name, v);
}

//Function to add an edge
public void addEdge(String start,String end,int cost) {
	vertex v1=gr.get(start);
	vertex v2=gr.get(end);
	if(v1==null || v2==null)
		return;
	v1.nbr.put(end, cost);
    v2.nbr.put(start, cost);
}


//Function to delete an edge
public void deleteEdge(String start,String end) {
	vertex v1=gr.get(start);
	vertex v2=gr.get(end);
	if(v1==null || v2==null)
		return;
	v1.nbr.remove(end);
	v2.nbr.remove(start);
}

//Function to delete a vertex
public void deleteVertex(String vname)
{
	if(vname==null)
		return;
	vertex v=gr.get(vname);
	ArrayList<String> nbrs=new ArrayList<>(v.nbr.keySet());
	for(String n:nbrs)
	{
		 vertex v1=gr.get(n);
		 v1.nbr.remove(vname);
		 
	}
	gr.remove(vname);
}

//Function to return true if graph contains passed edge
public boolean containsEdge(String start,String end)
{
	if(start==null || end==null || gr.get(start).nbr.get(end)==null )
		return false;
	return true;
}

//Function to return number of edges
public int numberEdges() {
	int count=0;
	ArrayList<String> keys=new ArrayList<>(gr.keySet());
	for(String key:keys)
	{
		vertex v=gr.get(key);
		count=count+v.nbr.size();
	}
	return count/2;    //each edge is counted twice 
}


//Display
public void display()
{
	ArrayList<String> keys=new ArrayList<>(gr.keySet());
	for(String key:keys)
	{
		vertex v=gr.get(key);
		 System.out.println(key+ ":" +v.nbr) ;
	}
}

}
