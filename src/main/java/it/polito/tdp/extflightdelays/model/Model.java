package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport,DefaultWeightedEdge> Grafo;
	
	private ExtFlightDelaysDAO dao;
	
	private Map<Integer,Airport> idMap;
	
	public Model() {
		
		idMap = new HashMap<>();
		
		dao = new ExtFlightDelaysDAO();
		
	}
	
	public void creaGrafo(int minDistanzaMedia) {
		
		Grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		dao.loadAllAirports(idMap);
		Graphs.addAllVertices(this.Grafo, idMap.values());
		
		for(Collegamento c : dao.loadCollegamenti(minDistanzaMedia))
			Graphs.addEdge(this.Grafo, idMap.get(c.a1id), idMap.get(c.getA2id()), c.getMediaDistanza());
		
		//System.out.println("GRAFO CREATO!");
		//System.out.println("#VERTICI: "+this.Grafo.vertexSet().size());
		//System.out.println("#ARCHI: "+this.Grafo.edgeSet().size());
		
	}
	
	public int getNumeroVertici() {
		return this.Grafo.vertexSet().size();
	}
	
	public int getNumeroArchi() {
		return this.Grafo.edgeSet().size();
	}
	
	public String getArchi() {
		
		String result = "";
		
		for(DefaultWeightedEdge e : this.Grafo.edgeSet())
			result += this.Grafo.getEdgeSource(e).getAirportName()+"-"+this.Grafo.getEdgeTarget(e).getAirportName()+"-"+this.Grafo.getEdgeWeight(e)+" miles\n";
		
		return result;
		
	}
	
}
