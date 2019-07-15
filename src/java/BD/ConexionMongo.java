/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import clases.Competition;
import clases.Competitor;
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
import clases.Publication;
import java.util.Date;
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
        DBCollection competitorsC = this.bd.getCollection("participantes");
        personsC.remove(new BasicDBObject().append("personaId", personId));
        usersC.remove(new BasicDBObject().append("personaId", personId));
        competitorsC.remove(new BasicDBObject().append("personaId", personId));
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
    
    public void createCompetitor(String nombre, String apellidos, int edad,String direccion, String tipo, String correo, String contrasenia, int competitionId){
        DBCollection personsC = this.bd.getCollection("personas");
        DBCollection usersC = this.bd.getCollection("usuarios");
        DBCollection competitorsC = this.bd.getCollection("participantes");
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
        DBCursor competitorsCU = competitorsC.find().sort(new BasicDBObject("participanteId",-1)).limit(1);
        int idCompetitorU = 1;
        if(competitorsCU.hasNext()){
            BasicDBObject competitorU = (BasicDBObject) competitorsCU.next();
            if(competitorU.get("participanteId")!=null){
                idCompetitorU = (int)competitorU.get("participanteId") +1;
            }
            
        }
        
        
        BasicDBObject documento = new BasicDBObject("nombre",nombre).append("personaId",idU).append("apellidos",apellidos).append("edad",edad).append("direccion",direccion).append("tipoUsuario",tipo);
        personsC.insert(documento); 
        
        BasicDBObject documento2 = new BasicDBObject("correo",correo).append("contrasenia",contrasenia).append("personaId",idU);
        usersC.insert(documento2);
        
        BasicDBObject documento3 = new BasicDBObject("participanteId",idCompetitorU).append("competenciaId",competitionId).append("personaId",idU);
        competitorsC.insert(documento3);
        
    }
    public Competitor getCompetitor(int personId){
        DBCollection competitorsC = this.bd.getCollection("participantes");
        BasicDBObject competitor = (BasicDBObject) competitorsC.findOne(new BasicDBObject("personaId",personId));
        if(competitor!=null){
            return new Competitor((int)competitor.get("participanteId"),personId,(int)competitor.get("competenciaId"));
        }
        return null;
    }
    
    public void editCompetitor(String nombre, String apellidos, int edad,String direccion, String tipo, int personId, int competitionId, String typeStart){
        DBCollection personsC = this.bd.getCollection("personas");
        DBCollection competitorsC = this.bd.getCollection("participantes");
        personsC.update(new BasicDBObject().append("personaId", personId),
                new BasicDBObject("$set",new BasicDBObject("nombre",nombre).append("apellidos",apellidos).append("edad",edad).append("direccion",direccion).append("tipoUsuario",tipo)));
        if(typeStart.equals("participante")){
            if(tipo.equals("participante")){
                //Participante a participante
                competitorsC.update(new BasicDBObject().append("personaId", personId),
                    new BasicDBObject("$set",new BasicDBObject("competenciaId",competitionId)));
            }else{
                //Participante a no participante
                competitorsC.remove(new BasicDBObject().append("personaId", personId));
            }
        }else{
            //No participante a participante
            DBCursor competitorsCU = competitorsC.find().sort(new BasicDBObject("participanteId",-1)).limit(1);
            int idCompetitorU = 1;
            if(competitorsCU.hasNext()){
                BasicDBObject competitorU = (BasicDBObject) competitorsCU.next();
                if(competitorU.get("participanteId")!=null){
                    idCompetitorU = (int)competitorU.get("participanteId") +1;
                }

            }
            BasicDBObject documento3 = new BasicDBObject("participanteId",idCompetitorU).append("competenciaId",competitionId).append("personaId",personId);
            competitorsC.insert(documento3);

        }
        
    }
    
    public void createPublication(String txtPublication, int personId, int competitionId, int parentId){
        DBCollection publicationsC = this.bd.getCollection("publicaciones");
        
        DBCursor publicationCU = publicationsC.find().sort(new BasicDBObject("publicacionId",-1)).limit(1);
        int idU = 1;
        if(publicationCU.hasNext()){
            BasicDBObject publicationU = (BasicDBObject) publicationCU.next();
            if(publicationU.get("publicacionId")!=null){
                idU = (int)publicationU.get("publicacionId") +1;
            }
        }
        
        BasicDBObject documento = new BasicDBObject("publicacionId",idU).append("contenido",txtPublication).append("fecha",new Date()).append("personaId",personId).append("competenciaId",competitionId).append("padreId",parentId);
        publicationsC.insert(documento); 
    }
    
    public ArrayList<Publication> getPublications(int competitionId){
        DBCollection publicationsC = this.bd.getCollection("publicaciones");
        DBCursor publications = publicationsC.find(new BasicDBObject("competenciaId",competitionId).append("padreId",0)).sort(new BasicDBObject("publicacionId",-1));
        ArrayList<Publication> publicationsA = new ArrayList<>();
        publications.forEach((publication)->{
            publicationsA.add(new Publication((int)publication.get("publicacionId"),(String)publication.get("contenido"),(int)publication.get("personaId"),(int)publication.get("competenciaId"),(int)publication.get("padreId")));
        });
        return publicationsA;
    }
    
    public Hashtable<Integer, String> getPersonsDiccionary(){
        DBCollection personsC = this.bd.getCollection("personas");
        DBCursor persons = personsC.find();
        Hashtable<Integer, String> personsH = new Hashtable<Integer, String>();
        persons.forEach((person)->{
            personsH.put((int)person.get("personaId"), (String)person.get("apellidos")+", "+(String)person.get("nombre"));
        });
        return personsH;
    }
    
    public ArrayList<Publication> getPublicationsChildren(int competitionId){
        DBCollection publicationsC = this.bd.getCollection("publicaciones");
        DBCursor publications = publicationsC.find(new BasicDBObject("padreId",competitionId));
        ArrayList<Publication> publicationsA = new ArrayList<>();
        publications.forEach((publication)->{
            publicationsA.add(new Publication((int)publication.get("publicacionId"),(String)publication.get("contenido"),(int)publication.get("personaId"),(int)publication.get("competenciaId"),(int)publication.get("padreId")));
        });
        return publicationsA;
    }
    public ArrayList<Competitor> getCompetitorsForCompetition(int competitionId){
        DBCollection competitorsC = this.bd.getCollection("participantes");
                
        DBCursor competitors = competitorsC.find(new BasicDBObject("competenciaId",competitionId));
        ArrayList<Competitor> competitorsA = new ArrayList<>();
        competitors.forEach((competitor)->{
            competitorsA.add(new Competitor((int)competitor.get("participanteId"),(int)competitor.get("personaId"),(int)competitor.get("competenciaId")));
        });
        return competitorsA;
    }
    
    public void editLikeOrDislikePublication(int personId, int publicationId, int value){
        DBCollection pReactionsC = this.bd.getCollection("p_reacciones");
        DBCursor pReactionCU = pReactionsC.find(new BasicDBObject("publicacionId",publicationId).append("personaId", personId)).limit(1);
        int idPReactionU = 0;
        if(pReactionCU.hasNext()){
            BasicDBObject pReactionU = (BasicDBObject) pReactionCU.next();
            if(pReactionU.get("publicacionId")!=null){
                idPReactionU = (int)pReactionU.get("publicacionId");
            }
        }
        if(idPReactionU==0){
            //no existe la reaccion
            pReactionCU = pReactionsC.find().sort(new BasicDBObject("reaccionId",-1)).limit(1);
            idPReactionU = 1;
            if(pReactionCU.hasNext()){
                BasicDBObject pReactionU = (BasicDBObject) pReactionCU.next();
                if(pReactionU.get("reaccionId")!=null){
                    idPReactionU = (int)pReactionU.get("reaccionId") +1;
                }

            }
            BasicDBObject documento1 = new BasicDBObject("reaccionId",idPReactionU).append("personaId",personId).append("publicacionId",publicationId).append("valor",value);
            pReactionsC.insert(documento1);
        }else{
            //si existe la reaccion
            pReactionsC.update(new BasicDBObject("reaccionId",idPReactionU),
                    new BasicDBObject("$set",new BasicDBObject("valor",value)));
        }        
    }
    
    public Hashtable<Integer, Integer> getReactionsPublicationOfMe(int personId){
        DBCollection pReactionsC = this.bd.getCollection("p_reacciones");
        DBCursor pReactions = pReactionsC.find(new BasicDBObject("personaId",personId));
        Hashtable<Integer, Integer> pReactionsH = new Hashtable<Integer, Integer>();
        pReactions.forEach((pReaction)->{
            pReactionsH.put((int)pReaction.get("publicacionId"), (int)pReaction.get("valor"));
        });
        return pReactionsH;
    }
    
    public void editLikeOrDislikeCompetitor(int personId, int competitorId, int value){
        DBCollection cReactionsC = this.bd.getCollection("c_reacciones");
        DBCursor cReactionCU = cReactionsC.find(new BasicDBObject("participanteId",competitorId).append("personaId", personId)).limit(1);
        int idCReactionU = 0;
        if(cReactionCU.hasNext()){
            BasicDBObject cReactionU = (BasicDBObject) cReactionCU.next();
            if(cReactionU.get("participanteId")!=null){
                idCReactionU = (int)cReactionU.get("participanteId");
            }
        }
        if(idCReactionU==0){
            //no existe la reaccion
            cReactionCU = cReactionsC.find().sort(new BasicDBObject("reaccionId",-1)).limit(1);
            idCReactionU = 1;
            if(cReactionCU.hasNext()){
                BasicDBObject cReactionU = (BasicDBObject) cReactionCU.next();
                if(cReactionU.get("reaccionId")!=null){
                    idCReactionU = (int)cReactionU.get("reaccionId") +1;
                }

            }
            BasicDBObject documento1 = new BasicDBObject("reaccionId",idCReactionU).append("personaId",personId).append("participanteId",competitorId).append("valor",value);
            cReactionsC.insert(documento1);
        }else{
            //si existe la reaccion
            cReactionsC.update(new BasicDBObject("reaccionId",idCReactionU),
                    new BasicDBObject("$set",new BasicDBObject("valor",value)));
        }        
    }
    
    public Hashtable<Integer, Integer> getReactionsCompetitorOfMe(int personId){
        DBCollection cReactionsC = this.bd.getCollection("c_reacciones");
        DBCursor cReactions = cReactionsC.find(new BasicDBObject("personaId",personId));
        Hashtable<Integer, Integer> cReactionsH = new Hashtable<Integer, Integer>();
        cReactions.forEach((cReaction)->{
            cReactionsH.put((int)cReaction.get("participanteId"), (int)cReaction.get("valor"));
        });
        return cReactionsH;
    }
}
