/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Giordano
 */
public class Competitor {
    private int competitorId;
    private int personId;
    private int competitionId;
    
    public Competitor(int competitorId, int personId, int competitionId){
        this.competitorId = competitorId;
        this.personId = personId;
        this.competitionId = competitionId;
    }

    public int getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(int competitorId) {
        this.competitorId = competitorId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }
    
    
}
