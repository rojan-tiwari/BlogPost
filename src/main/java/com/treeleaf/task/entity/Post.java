package com.treeleaf.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

@Entity
@Table
public class Post {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	@NotNull
	@Column
	private String title;
	@Lob
	@Column
	@NotNull
	private String content;
	@Column
	@Lob
	private String image;
	
	
	public Post(String id, String title, String content, String image) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
	}
	
	
	public Post() {
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getimage() {
		return image;
	}


	public void setimage(String image) {
		this.image = image;
	}
	
}
	