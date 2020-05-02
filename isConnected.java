private class pair{
String vname;
String psf; //path so far
}
public boolean isConnected()
{
    int count=0;
	HashMap<String,Boolean> pr=new HashMap<>();
	LinkedList<pair> q=new LinkedList<>();
	ArrayList<String> vertices=new ArrayList<>(gr.keySet());
	for(String v:vertices)
	{
		if(pr.containsKey(v))
			continue;
		count++;
   	pair np=new pair();
  	np.vname=v;
    np.psf=v;
  	q.addLast(np);
	while(!q.isEmpty())
	{
		pair rp=q.removeFirst();
		if(pr.containsKey(rp.vname))
			continue;
		pr.put(rp.vname, true);
		vertex x=gr.get(rp.vname);
		ArrayList<String> keys=new ArrayList<>(x.nbr.keySet());
		for(String key:keys)
		{
			if(!pr.containsKey(key))
			{pair p=new pair();
			 p.vname=key;
			 p.psf=np.psf+key;
			 q.addLast(p);}
		}
	}}
	return (count==1);
}
