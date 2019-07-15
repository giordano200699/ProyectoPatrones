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
public class Publication {
    private int publicationId;
    private String content;
    private int personId;
    private int competitionId;
    private int parentId;

    public Publication(int publicationId, String content, int personId, int competitionId, int parentId) {
        this.publicationId = publicationId;
        this.content = content;
        this.personId = personId;
        this.competitionId = competitionId;
        this.parentId = parentId;
    }

    
    
    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    
    
}
