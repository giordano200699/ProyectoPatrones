/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import clases.Competition;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.ArrayList;
import clases.Sede;
import clases.Person;
import java.util.Hashtable;

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
    
    public void createUser(String nombre, String apellidos, int edad,String direccion, String tipo, String correo, String contrasenia){
        DBCollection personsC = this.bd.getCollection("personas");
        DBCollection usersC = this.bd.getCollection("usuarios");
        DBCursor personCU = personsC.find().sort(new BasicDBObject("personaId",-1)).limit(1);
        //BasicDBObject personU = (BasicDBObject) personsC.find().sort(new BasicDBObject("personaId",-1)).limit(1);
        int idU = 1;
        if(personCU.hasNext()){
            BasicDBObject personU = (BasicDBObject) personCU.next();
            if(personU.get("personaId")!=null){
                System.out.println(personU.get("personaId"));
                idU = (int)personU.get("personaId") +1;
            }
            
        }
        BasicDBObject documento = new BasicDBObject("nombre",nombre).append("personaId",idU).append("apellidos",apellidos).append("edad",edad).append("direccion",direccion).append("tipoUsuario",tipo);
        personsC.insert(documento); 
        
        BasicDBObject documento2 = new BasicDBObject("correo",correo).append("contrasenia",contrasenia).append("personaId",idU);
        usersC.insert(documento2); 
        
    }
    
    public ArrayList<Person> getPersons(){
        DBCollection personsC = this.bd.getCollection("personas");
        DBCursor persons = personsC.find();
        ArrayList<Person> personsA = new ArrayList<>();
        persons.forEach((person)->{
            personsA.add(new Person((int)person.get("personaId"),(String)person.get("nombre"),(String)person.get("apellidos"),(int)person.get("edad"),(String)person.get("direccion"),(String)person.get("tipoUsuario")));
        });
        return personsA;
    }
    
    public Person getPerson(int personId){
        DBCollection personsC = this.bd.getCollection("personas");
        BasicDBObject person = (BasicDBObject) personsC.findOne(new BasicDBObject("personaId",personId));
        int idU = 1;
        if(person!=null){
            return new Person((int)person.get("personaId"),(String)person.get("nombre"),(String)person.get("apellidos"),(int)person.get("edad"),(String)person.get("direccion"),(String)person.get("tipoUsuario"));
        }
        return null;
    }
    
    public void editPerson(String nombre, String apellidos, int edad,String direccion, String tipo, int personId){
        DBCollection personsC = this.bd.getCollection("personas");
        personsC.update(new BasicDBObject().append("personaId", personId),
                new BasicDBObject("$set",new BasicDBObject("nombre",nombre).append("apellidos",apellidos).append("edad",edad).append("direccion",direccion).append("tipoUsuario",tipo)));
    }
    
    public void deletePerson(int personId){
        DBCollection personsC = this.bd.getCollection("personas");
        DBCollection usersC = this.bd.getCollection("usuarios");
        personsC.remove(new BasicDBObject().append("personaId", personId));
        usersC.remove(new BasicDBObject().append("personaId", personId));
    }
    
    public Person findForUser(String correo, String contrasenia){
        DBCollection personsC = this.bd.getCollection("personas");
        DBCollection usersC = this.bd.getCollection("usuarios");
        
        BasicDBObject user = (BasicDBObject) usersC.findOne(new BasicDBObject("correo",correo).append("contrasenia", contrasenia));
        if(user!=null){
            BasicDBObject person = (BasicDBObject) personsC.findOne(new BasicDBObject("personaId",(int)user.get("personaId")));
            if(person!=null){
                return new Person((int)person.get("personaId"),(String)person.get("nombre"),(String)person.get("apellidos"),(int)person.get("edad"),(String)person.get("direccion"),(String)person.get("tipoUsuario"));
            }
        }
        
        return null;
    }
    
    public void createCompetition(String title, String category, int headquarterId){
        DBCollection competitionsC = this.bd.getCollection("competencias");
        
        DBCursor competitionCU = competitionsC.find().sort(new BasicDBObject("competenciaId",-1)).limit(1);
        int idU = 1;
        if(competitionCU.hasNext()){
            BasicDBObject competitionU = (BasicDBObject) competitionCU.next();
            if(competitionU.get("competenciaId")!=null){
                idU = (int)competitionU.get("competenciaId") +1;
            }
        }
        
        BasicDBObject documento = new BasicDBObject("competenciaId",idU).append("titulo",title).append("categoria",category).append("sedeId",headquarterId);
        competitionsC.insert(documento); 
    }
    
    public ArrayList<Competition> getCompetitions(){
        DBCollection competitionsC = this.bd.getCollection("competencias");
        DBCursor competitions = competitionsC.find();
        ArrayList<Competition> competitionsA = new ArrayList<>();
        competitions.forEach((competition)->{
            competitionsA.add(new Competition((int)competition.get("competenciaId"),(String)competition.get("titulo"),(String)competition.get("categoria"),(int)competition.get("sedeId")));
        });
        return competitionsA;
    }
    
    public Hashtable<Integer, String> getHeadquartersDiccionary(){
        DBCollection headquartersC = this.bd.getCollection("sedes");
        DBCursor headquarters = headquartersC.find();
        Hashtable<Integer, String> headquartersH = new Hashtable<Integer, String>();
        headquarters.forEach((headquarter)->{
            headquartersH.put((int)headquarter.get("sedeId"), (String)headquarter.get("nombre"));
        });
        return headquartersH;
    }
    
    public Competition getCompetition(int competitionId){
        DBCollection competitionsC = this.bd.getCollection("competencias");
        BasicDBObject competition = (BasicDBObject) competitionsC.findOne(new BasicDBObject("competenciaId",competitionId));
        int idU = 1;
        if(competition!=null){
            return new Competition((int)competition.get("competenciaId"),(String)competition.get("titulo"),(String)competition.get("categoria"),(int)competition.get("sedeId"));
        }
        return null;
    }
    
    public void editCompetition(String title, String category, int headquarterId, int competitionId){
        DBCollection competitionsC = this.bd.getCollection("competencias");
        competitionsC.update(new BasicDBObject().append("competenciaId", competitionId),
                new BasicDBObject("$set",new BasicDBObject("titulo",title).append("categoria",category).append("sedeId",headquarterId)));
    }
    
    public void deleteCompetition(int competitionId){
        DBCollection competitionsC = this.bd.getCollection("competencias");
        competitionsC.remove(new BasicDBObject().append("competenciaId", competitionId));
    }
}
