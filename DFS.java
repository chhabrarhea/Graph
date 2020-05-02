private class pair{
	String vname;
	String psf; //path so far:nodes traversed so far
}
public boolean dfs(String s,String d)
{
	HashMap<String,Boolean> pr=new HashMap<>();
	LinkedList<pair> st=new LinkedList<>();
	pair np=new pair();
	np.vname=s;
	np.psf=s;
	st.addFirst(np);
	while(!st.isEmpty())
	{
		pair rp=st.removeFirst();
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
			 st.addFirst(p);
       }
		}
	}
	return false;
	}
