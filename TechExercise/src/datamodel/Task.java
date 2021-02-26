package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "task")
public class Task {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "title")
   private String title;

   @Column(name = "dueDate")
   private Date dueDate;
   
   @Column(name = "notes")
   private String notes;
   
   @Column(name = "complete")
   private int complete;

   public Task() {
   }

   public Task(Integer id, String title, Date dueDate, String notes, int complete) {
      this.id = id;
      this.title = title;
      this.dueDate = dueDate;
      this.notes = notes;
      this.complete = complete;
   }

   public Task(String title, Date dueDate, String notes, int complete) {
	  this.title = title;
	  this.dueDate = dueDate;
	  this.notes = notes;
	  this.complete = complete;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Date getDueDate() {
      return dueDate;
   }

   public void setDueDate(Date dueDate) {
      this.dueDate = dueDate;
   }

   public String getNotes() {
      return notes;
   }

   public void setNotes(String notes) {
      this.notes = notes;
   }
   
   public boolean getComplete() {
	  if (complete == 1)
	  {
		  return true;
	  }
	  return false;
   }

   public void setComplete(int complete) {
	  this.complete = complete;
   }

   @Override
   public String toString() {
      return "Task: " + this.id + ", " + this.title + ", " + this.dueDate + ", " + this.notes + ", " + this.complete;
   }
}