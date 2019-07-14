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
public class Competition {
    private int competitionId;
    private String title;
    private String category;
    private int headquarterId;

    public Competition(int competitionId,String title,String category, int headquarterId){
        this.competitionId = competitionId;
        this.title = title;
        this.category = category;
        this.headquarterId = headquarterId;
    }
    
    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getHeadquarterId() {
        return headquarterId;
    }

    public void setHeadquarterId(int headquarterId) {
        this.headquarterId = headquarterId;
    }
    
    
    
}
