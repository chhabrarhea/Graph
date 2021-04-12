private class Pair{
	String vname;
	String psf; //path so far:nodes traversed so far
}
public boolean bfs(String s,String d)
{
	HashMap<String,Boolean> pr=new HashMap<>(); //processed nodes
	LinkedList<pair> q=new LinkedList<>();
	Pair np=new Pair();
	np.vname=s;
	np.psf=s;
	q.addLast(np);
	while(!q.isEmpty())
	{
		Pair rp=q.removeFirst();
		if(pr.containsKey(rp.vname))
			continue;
		pr.put(rp.vname, true);
		if(this.containsEdge(rp.vname,d))
			return true;
		vertex v=gr.get(rp.vname);
		ArrayList<String> keys=new ArrayList<>(v.nbr.keySet());
		for(String key:keys)
		{
			if(!pr.containsKey(key))
			{
                         Pair p=new Pair();
			 p.vname=key;
			 p.psf=np.psf+key;
			 q.addLast(p);
       }
		}
	}
	return false;
	}
