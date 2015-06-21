package com.proyecto.cero.vaquita;

import org.hibernate.validator.constraints.NotEmpty;

public class VaquitaFirstStepForm {
	
	@NotEmpty
	private String title;
	private String description;
	private String image; // Default: imgDefault.png
	private String organizedFor;

	public VaquitaFirstStepForm() {
		// TODO Auto-generated constructor stub
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setName(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getOrganizedFor() {
		return organizedFor;
	}
	public void setOrganizedFor(String organizedFor) {
		this.organizedFor = organizedFor;
	}

}
