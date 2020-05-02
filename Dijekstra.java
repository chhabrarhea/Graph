private class DijkstraPair implements Comparable<DijkstraPair> {
	String vname;
	String psf;
	int cost;

	@Override
	public int compareTo(DijkstraPair o) {
		return o.cost - this.cost;
	}
}

public void Dijkstra(String src) {

	
	//map contains nodes which are yet to be processed
	HashMap<String, DijkstraPair> processed = new HashMap<>();

	//min heap to process node with lowest cost
	HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();

	ArrayList<String> keys=new ArrayList<>(gr.keySet());
	
	
	//initialization 
	for(String i:keys) {
		DijkstraPair np = new DijkstraPair();
		np.vname = i;
		if (i == src) {
			np.psf = i + "";
			np.cost = 0;
		}
		else {
			np.psf = "";
		np.cost = Integer.MAX_VALUE;
		}
		
        heap.add(np);
		processed.put(i, np);
	}

	 
	while (!heap.isEmpty()) {

		 
		DijkstraPair rp = heap.remove();
		processed.remove(rp.vname);

		 
		System.out.println(rp.vname + " via " + rp.psf + " @cost: " + rp.cost);
         vertex v=gr.get(rp.vname);
		ArrayList<String> nbrs=new ArrayList<>(v.nbr.keySet());
		 
		 for(String j:nbrs) {
			if (v.nbr.get(j)!=0) {

				 
				if (processed.containsKey(j)) {

					DijkstraPair nbrpair = processed.get(j);

					int oc = nbrpair.cost;
					int nc = rp.cost + v.nbr.get(j) ;

					// if new cost < old cost then update the pair
					if (nc < oc) {
						nbrpair.cost = nc;
						nbrpair.psf = rp.psf + j;

						heap.updatePriority(nbrpair);
					}

				}
			}
		}

	}

}
}
