package com.proyecto.cero.model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Vaquita")
public class Vaquita {

	public Vaquita() {
		// Vacio
	}

	public enum Status {
		DRAFT, ACTIVE, ENDED, CANCELED;
	}
	public enum ContributionType {
		FIXED, SUGGESTED, OPEN
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	private int id;

	@NotNull
	@Column(name = "title")
	private String title;

	@Column(name = "creator")
	private String creator;

	@Column(name = "organizedFor")
	private String organizedFor;

	@Column(name = "image")
	private String image; // Default: imgDefault.png

	@Column(name = "description")
	private String description;

	@Column(name = "cancelReason")
	private String cancelReason;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "isPublic")
	private boolean isPublic; // Default: False;

	@Column(name = "contributionField")
	private boolean contributionField; // Default: True // Se le saca a el monto
																			// final //Sino se le saca a la
																			// contribucion

	@Column(name = "showParicipantName")
	private boolean showParicipantName; // Default: False

	@Column(name = "showParticipantContribution")
	private boolean showParticipantContribution; // Default: False

	@Column(name = "showTotalAmmount")
	private boolean showTotalAmmount; // Default: False

	@Column(name = "openMessage")
	private boolean openMessage; // Default: True

	@Column(name = "openInvitation")
	private boolean openInvitation; // Default: True

	@Column(name = "showMessageWall")
	private boolean showMessageWall; // Default: True

	@Column(name = "notifyEmail")
	private boolean notifyEmail; // Default: False

	@Column(name = "contributionType")
	private ContributionType contributionType;
	
	@Column (name = "contributionAmmount")
	private int contributionAmmount;
	
	@Column(name = "objetivoDeDinero")
	private int objetivoDeDinero;

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private Status status; // Default: ACTIVA

	public Vaquita(String title, String desc, String img, String creator) {
		this.title = title;
		this.description = desc;
		this.image = img;
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getOrganizedFor() {
		return organizedFor;
	}

	public void setOrganizedFor(String organizedFor) {
		this.organizedFor = organizedFor;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public boolean isContributionField() {
		return contributionField;
	}

	public void setContributionField(boolean contributionField) {
		this.contributionField = contributionField;
	}

	public boolean isShowParicipantName() {
		return showParicipantName;
	}

	public void setShowParicipantName(boolean showParicipantName) {
		this.showParicipantName = showParicipantName;
	}

	public boolean isShowParticipantContribution() {
		return showParticipantContribution;
	}

	public void setShowParticipantContribution(boolean showParticipantContribution) {
		this.showParticipantContribution = showParticipantContribution;
	}

	public boolean isShowTotalAmmount() {
		return showTotalAmmount;
	}

	public void setShowTotalAmmount(boolean showTotalAmmount) {
		this.showTotalAmmount = showTotalAmmount;
	}

	public boolean isOpenMessage() {
		return openMessage;
	}

	public void setOpenMessage(boolean openMessage) {
		this.openMessage = openMessage;
	}

	public boolean isOpenInvitation() {
		return openInvitation;
	}

	public void setOpenInvitation(boolean openInvitation) {
		this.openInvitation = openInvitation;
	}

	public boolean isShowMessageWall() {
		return showMessageWall;
	}

	public void setShowMessageWall(boolean showMessageWall) {
		this.showMessageWall = showMessageWall;
	}

	public boolean isNotifyEmail() {
		return notifyEmail;
	}

	public void setNotifyEmail(boolean notifyEmail) {
		this.notifyEmail = notifyEmail;
	}
 
	public int getObjetivoDeDinero() {
		return objetivoDeDinero;
	}

	public void setObjetivoDeDinero(int objetivoDeDinero) {
		this.objetivoDeDinero = objetivoDeDinero;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public ContributionType getContributionType() {
		return contributionType;
	}

	public void setContributionType(ContributionType contributionType) {
		this.contributionType = contributionType;
	}

	public int getContributionAmmount() {
		return contributionAmmount;
	}

	public void setContributionAmmount(int contributionAmmount) {
		this.contributionAmmount = contributionAmmount;
	}


	@Override
	public String toString() {
		return "Vaquita [Title=" + title + " Decription: " + description + " Organized For: " + organizedFor + " Image: " + image;
	}

}
