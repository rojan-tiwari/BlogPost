package com.treeleaf.task.dto;


public class PostDto {
	private Long id;
	private String content;
	private String title;
	private String image;
	
	
	public PostDto(Long id, String content, String title, String image) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.image = image;
	}
	
	public PostDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getimage() {
		return image;
	}

	public void setimage(String image) {
		this.image = image;
	}
	
	

}
