package com.programming.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* 
 * Time complexcity for below two most freq operations
 * a) search all adjustened  node from a given node. worst case need to scan complete edgeList. O(|E|)
   b) find if two nodes are connected or not. worst case need to scan complete edgeList. O(|E|)
 * 
 * 
 * 
 * 
 * 
 */
public class GraphWithEdgeList {

	private static class Edge {
		
		private final Vertex startVertex;
		private final Vertex endVertex;
		private final int weight;
		
		Edge(Vertex startVertex, Vertex endVertex, int weight){
			
			this.startVertex=startVertex;
			this.endVertex=endVertex;
			this.weight=weight;
			
		}
		
		
	}
	
	private static class Vertex {
		
		private final String name;
		private final String desc;
		
		Vertex(String name , String desc){
			
			this.name=name;
			this.desc=desc;
		}
		
		
		
	}
	
	public static void main(String [] args) {
		
		List<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(new Vertex("Delhi","capital"));
		vertices.add(new Vertex("Jaipur","pink city"));
		vertices.add(new Vertex("MP","Madhya pradesh"));
		vertices.add(new Vertex("Bangalore","Garden City"));
		
		
		
		List<Edge> edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(vertices.get(0),vertices.get(1),100));
		edgeList.add(new Edge(vertices.get(0),vertices.get(2),200));
		edgeList.add(new Edge(vertices.get(0),vertices.get(3),500));
		edgeList.add(new Edge(vertices.get(1),vertices.get(3),400));
		
	}
	
	
}
