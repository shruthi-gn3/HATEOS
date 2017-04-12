/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateosappeals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shruthign3
 */
@XmlRootElement(name="Appeals", namespace=Representation.APPEALS_NAMESPACE)
public class AppealRepresentation{
   private int AppealId;
    private int StudentId;
    private String GradeItem;
    private int Score;
    private String Comments;
    private String feedback;
    private String Status;
    private List<Link> links =  new ArrayList<Link>();
    
    public AppealRepresentation(){
      
    }
    
     public AppealRepresentation(int appealid, int studentid, String gradeitem, int score, String comments, String feedback, String status){
     this.AppealId = appealid;
     this.StudentId = studentid;
     this.GradeItem = gradeitem;
     this.Score = score;
    this.Comments = comments;
    this.feedback = feedback;
    this.Status = status;
     }
    
    
    @XmlElement(name="GradeItem")
    public void setGradeItem(String gradeitem) {
        this.GradeItem = gradeitem;
    }
    public String getGradeItem() {
        return GradeItem;
    }
    
  @XmlElement(name="Commnents")
    public void setComments(String comments) {
        this.Comments = comments;
    }
    public String getComments() {
        return Comments;
    }
    
    @XmlElement(name="Feedback")
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public String getFeedback() {
        return feedback;
    }
    
    @XmlElement(name="Status")
    public void setStatus(String status) {
        this.Status = status;
    }
    public String getStatus() {
        return Status;
    }
    
 @XmlElement(name="Score")
    public void setScore(int score) {
        this.Score = score;
    }
    public int getScore() {
        return Score;
    }
    
  @XmlElement(name="AppealId")
    public void setAppealId(int appealid) {
        this.AppealId = appealid;
    }
    
    public int getAppealId() {
        return AppealId;
    }
    
 @XmlElement(name="StudentId")
    public void setStudentId(int studentid) {
        this.StudentId = studentid;
    }
    
    public int getStudentId() {
        return StudentId;
    }
    
     @XmlElement(name = "Links")
   public List<Link> getLinks() {
      return links;
   }

   public void setLinks(Link link) {
      this.links.add(link);
   }
    
}
