package com.proyecto.cero.vaquita;

import java.sql.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.proyecto.cero.model.Vaquita.ContributionType;

public class VaquitaSecondStepForm {

	/* Participation */
	private String contributionField; // Default: True // Se le saca a el monto
	private String endDateCheck;
	@Future
	private Date endDate;
	@NotNull
	private ContributionType contributionType;
	
	private int contributionAmmount;
	
	/* Privacy */
	private String showParicipantName; // Default: False
	private String showParticipantContribution; // Default: False
	private String showTotalAmmount; // Default: False

	/* Additional Options */
	private String isPublic; // Default: False;
	private String openInvitation; // Default: false
	private String moneytargetCheck;
	private int moneyTarget; //Si esta desnmarcado es NULL
	private String openMessage; // Default: True
	private String showMessageWall; // Default: True
	private String notifyEmail; // Default: False
	public String getContributionField() {
		return contributionField;
	}
	public void setContributionField(String contributionField) {
		this.contributionField = contributionField;
	}
	public String getEndDateCheck() {
		return endDateCheck;
	}
	public void setEndDateCheck(String endDateCheck) {
		this.endDateCheck = endDateCheck;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public String getShowParicipantName() {
		return showParicipantName;
	}
	public void setShowParicipantName(String showParicipantName) {
		this.showParicipantName = showParicipantName;
	}
	public String getShowParticipantContribution() {
		return showParticipantContribution;
	}
	public void setShowParticipantContribution(String showParticipantContribution) {
		this.showParticipantContribution = showParticipantContribution;
	}
	public String getShowTotalAmmount() {
		return showTotalAmmount;
	}
	public void setShowTotalAmmount(String showTotalAmmount) {
		this.showTotalAmmount = showTotalAmmount;
	}
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	public String getOpenInvitation() {
		return openInvitation;
	}
	public void setOpenInvitation(String openInvitation) {
		this.openInvitation = openInvitation;
	}
	public String getMoneytargetCheck() {
		return moneytargetCheck;
	}
	public void setMoneytargetCheck(String moneytargetCheck) {
		this.moneytargetCheck = moneytargetCheck;
	}
	public int getMoneyTarget() {
		return moneyTarget;
	}
	public void setMoneyTarget(int moneyTarget) {
		this.moneyTarget = moneyTarget;
	}
	public String getOpenMessage() {
		return openMessage;
	}
	public void setOpenMessage(String openMessage) {
		this.openMessage = openMessage;
	}
	public String getShowMessageWall() {
		return showMessageWall;
	}
	public void setShowMessageWall(String showMessageWall) {
		this.showMessageWall = showMessageWall;
	}
	public String getNotifyEmail() {
		return notifyEmail;
	}
	public void setNotifyEmail(String notifyEmail) {
		this.notifyEmail = notifyEmail;
	}


}
