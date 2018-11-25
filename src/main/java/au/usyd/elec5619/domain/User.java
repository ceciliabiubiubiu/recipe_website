package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userID", nullable=false, unique=true)
	private int id;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	
	public User(){
		super();
	}
	
	public User(String userName, String password, String email) {
		super();
		this.userName=userName;
		this.password=password;
		this.email=email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return userName;
	}
	
	public void setName(String userName) {
		this.userName=userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String toString() {
		return "id"+id+"user name"+userName+"password"+password+"email"+email;
	}
}
