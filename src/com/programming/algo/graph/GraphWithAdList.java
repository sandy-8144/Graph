package com.programming.algo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GraphWithAdList {
	
	private Map<Vertex,ArrayList<Vertex>> adList;
	private List<Vertex> vertexList;
	private boolean isDirected;
	

/*private static class Edge {
		
		private final Vertex startVertex;
		private final Vertex endVertex;
		private final int weight;
		
		Edge(Vertex startVertex, Vertex endVertex, int weight){
			
			this.startVertex=startVertex;
			this.endVertex=endVertex;
			this.weight=weight;
			
		}
		
		
	}*/
	
	public GraphWithAdList(boolean isDirected) {
		this.adList = new HashMap<Vertex,ArrayList<Vertex>>();
		this.vertexList = new ArrayList<Vertex>();
		this.isDirected=isDirected;
		
	}
	private static class Vertex {
		
		private String name;
		private boolean isVisited;
		private int index;
		
		Vertex(String name,int index){
			
			this.name=name;
			this.isVisited=false;
			this.index=index;
			
		}
     
		@Override
		public int hashCode() {
			
			return name.hashCode();
		}	
		
		@Override
		public String toString() {
			
			return name;
		}
		
	}
	
	public void addVertex(String name,int index) {
		vertexList.add(new Vertex(name,index));		
		
	}
	
	public void addEdge(int start , int end) {
		
		Vertex s = vertexList.get(start);
		Vertex e = vertexList.get(end);
		
		if(adList.get(s) ==null)
		{
		    ArrayList<Vertex> list = new ArrayList<Vertex>();
		    list.add(e);
		    adList.put(s, list);
		    
		}else {
			
			adList.get(s).add(e);
		}
		
		if(!isDirected) {
			
			if(adList.get(e) ==null)
			{
			    ArrayList<Vertex> list = new ArrayList<Vertex>();
			    list.add(s);
			    adList.put(e, list);
			    
			}else {
				
				adList.get(e).add(s);
			}
						
		}
		
		
	}
	
	public List<Vertex> getNeighbour(Vertex v){	
		
		return adList.get(v);
	}
	
	private void BFS(GraphWithAdList g) {
		
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		Vertex start = vertexList.get(0);
		//start.isVisited=true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Vertex v1 = queue.poll();
			if(!v1.isVisited) {
			   System.out.println(v1.name);
			   v1.isVisited=true;
			}
			for(Vertex v2: getNeighbour(v1))
			{
				if(!v2.isVisited) {
					
					queue.add(v2);
					
				}
			}
		}
		
		
		
	}
	
	
	public void BFS() {
		
		BFS(this);
	}
	
	
	
private void DFS(GraphWithAdList g) {
		
		LinkedList<Vertex> stack = new LinkedList<Vertex>();
		Vertex start = vertexList.get(0);
		//start.isVisited=true;
		stack.push(start);
		
		while(!stack.isEmpty()) {
			
			Vertex v1 = stack.pop();
			if(!v1.isVisited) {
			   System.out.println(v1.name);
			   v1.isVisited=true;
			}
			
			for(Vertex v2: getNeighbour(v1))
			{
				if(!v2.isVisited) {
					
				stack.push(v2);
					
				}
			}
		}
		
		
		
	}
	
	
	public void DFS() {
		
		DFS(this);
	}
	
	
	public Map<Vertex,ArrayList<Vertex>> getAdList()
	{
		return adList;
	}
	
	
	private static class QueueNode{
		
		Vertex v;
		int distanceFromSource;
		
		QueueNode(Vertex v, int distanceFromSource){
			
			this.v=v;
			this.distanceFromSource=distanceFromSource;
		}
		
		
		
	}
	
	
	private static class QueueComparater implements Comparator<QueueNode>{

		@Override
		public int compare(QueueNode o1, QueueNode o2) {
			// TODO Auto-generated method stub
			return o1.distanceFromSource-o2.distanceFromSource;
		}
		
		
		
	}
	/*
	 * Dijkstra shorted path algorithm. method takes inputs as source. and print shortest distance of each node from source.
	 * it uses Heap ( priority queue is java implemenation).
	 * distance[] , which keeps track of each nodes shorted path from source.
	 * it uses BFS. predessor arry is used to keep track 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void findShortestPathDijkstra(int vId) {
		
		int [] distance = new int [vertexList.size()];
		int [] predessor = new int[vertexList.size()];
		
		for(int i=0;i<vertexList.size();i++)
		{
			
			distance[i]=Integer.MAX_VALUE;
			predessor[i] = -1;
		}
		
		PriorityQueue<QueueNode> queue = new PriorityQueue<QueueNode>(new QueueComparater());
		queue.add(new QueueNode(vertexList.get(vId),0));
		
		while(!queue.isEmpty()) {
			QueueNode node = queue.remove();
			distance[node.v.index]=node.distanceFromSource;
			node.v.isVisited=true;
			
			for(Vertex v : getNeighbour(node.v)) {
				
				if(!v.isVisited) {
					
					/*
					 * distance[node.v.index]+E(node.v, v) < distance[v.index]
					 * 
					 * int olddistance = distance[v.index];
					 * int newDistance = distance[node.v.index]+E(node.v, v);
					 * distance[v.index]=newDistance;
					 * 
					 * queue.add/update(queueNode(v,newDistance)
					 * 
					 * 
					 * 
					 */
					
				
					
				}
				
				/*
				 * parent[v.index]=node.v.index;
				 * 
				 * queue.add/update(queueNode(v,newDistance)
				 */
			}
			
			
			
		}
		
		
		
		
	}
	
	public static void main (String []args) {
		
		GraphWithAdList graph = new GraphWithAdList(false);
		graph.addVertex("Delhi",0);
		graph.addVertex("Jaipur",1);
		graph.addVertex("Punjab",2);
		graph.addVertex("MP",3);
		graph.addVertex("Bangalore",4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(1, 3);
		
		System.out.println("Get Adj List:"+graph.getAdList());
		System.out.println();
		graph.BFS();
		System.out.println();
		
		GraphWithAdList graph1 = new GraphWithAdList(false);
		graph1.addVertex("Delhi",0);
		graph1.addVertex("Jaipur",1);
		graph1.addVertex("Punjab",2);
		graph1.addVertex("MP",3);
		graph1.addVertex("Bangalore",4);
		
		graph1.addEdge(0, 1);
		graph1.addEdge(0, 2);
		graph1.addEdge(0, 3);
		graph1.addEdge(0, 4);
		graph1.addEdge(1, 4);
		graph1.addEdge(2, 4);
		graph1.addEdge(1, 3);
		
		graph1.DFS();
	}
	
}
	

