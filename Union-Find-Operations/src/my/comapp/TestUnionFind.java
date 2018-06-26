package my.comapp;

public class TestUnionFind {

	public static void main(String[] args) {

		
		int n = 10;
		//UF components = new UF(n); 

		//QuickUnionFind components = new QuickUnionFind(n);
		
		//WeightedUnionFind components = new WeightedUnionFind(n);
		
		UnionFindByRankAndPathCompression components = new UnionFindByRankAndPathCompression(n);
		
		components.union(3,4);
		components.union(5,6);
		components.union(0,1);
		components.union(1,5);
		components.union(5,4);
		components.union(2,7);
		components.union(2,8);
		components.union(2,9);
		components.union(5,2);
		components.union(2,1);
		
		
	}

}
