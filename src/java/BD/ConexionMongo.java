/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.ArrayList;
import clases.Sede;

/**
 *
 * @author Giordano
 */
public class ConexionMongo {
    MongoClient conexion;
    DB bd;
    public ConexionMongo(){
        this.conexion = new MongoClient(new MongoClientURI("mongodb+srv://jordan:cursogg@panamericano-cjqv8.mongodb.net/test?retryWrites=true&w=majority"));
        this.bd = this.conexion.getDB("Panamericano");
    }
    public void cerrarConexion(){
        conexion.close();
    }
    public void crearSede(String nombre, String direccion, int aforo){
        DBCollection sedesC = this.bd.getCollection("sedes");
        BasicDBObject sedeU = (BasicDBObject) sedesC.find().sort(new BasicDBObject("sedeId",-1)).limit(1).next();
        int idU = 1;
        if(sedeU!=null){
            if(sedeU.get("sedeId")!=null){
                idU = (int)sedeU.get("sedeId") +1;
            }
            
        }
        BasicDBObject documento = new BasicDBObject("nombre",nombre).append("sedeId",idU).append("direccion",direccion).append("aforo",aforo);
        sedesC.insert(documento); 
    }
    public ArrayList<Sede> obtenerSedes(){
        DBCollection sedesC = this.bd.getCollection("sedes");
        DBCursor sedes = sedesC.find();
        ArrayList<Sede> sedesA = new ArrayList<Sede>();
        sedes.forEach((sede)->{
            sedesA.add(new Sede((String)sede.get("nombre"),(String)sede.get("direccion"),(int)sede.get("aforo"),(int)sede.get("sedeId")));
        });
        return sedesA;
    }
    public Sede obtenerSede(int sedeId){
        DBCollection sedesC = this.bd.getCollection("sedes");
        BasicDBObject sede = (BasicDBObject) sedesC.findOne(new BasicDBObject("sedeId",sedeId));
        int idU = 1;
        if(sede!=null){
            return new Sede((String)sede.get("nombre"),(String)sede.get("direccion"),(int)sede.get("aforo"),(int)sede.get("sedeId"));
        }
        return null;
    }
    
    public void editarSede(String nombre, String direccion, int aforo, int sedeId){
        DBCollection sedesC = this.bd.getCollection("sedes");
        sedesC.update(new BasicDBObject().append("sedeId", sedeId),
                new BasicDBObject("$set",new BasicDBObject("nombre",nombre).append("direccion",direccion).append("aforo",aforo)));
    }
    
    public void eliminarSede(int sedeId){
        DBCollection sedesC = this.bd.getCollection("sedes");
        sedesC.remove(new BasicDBObject().append("sedeId", sedeId));
    }
}
