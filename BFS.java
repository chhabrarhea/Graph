private class pair{
	String vname;
	String psf; //path so far:nodes traversed so far
}
public boolean bfs(String s,String d)
{
	HashMap<String,Boolean> pr=new HashMap<>();
	LinkedList<pair> q=new LinkedList<>();
	pair np=new pair();
	np.vname=s;
	np.psf=s;
	q.addLast(np);
	while(!q.isEmpty())
	{
		pair rp=q.removeFirst();
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
                         pair p=new pair();
			 p.vname=key;
			 p.psf=np.psf+key;
			 q.addLast(p);
       }
		}
	}
	return false;
	}
