package com.proyecto.cero.vaquita;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.proyecto.cero.model.Vaquita.ContributionType;
import com.proyecto.cero.model.Vaquita.Status;

public class VaquitaSecondStepForm {

	/* Participation */
	private boolean contributionField; // Default: True // Se le saca a el monto
	private boolean endDateCheck;
	@Future
	private Date endDate;
	@NotNull
	private ContributionType contributionType;
	
	private int contributionAmmount;
	
	/* Privacy */
	private boolean showParicipantName; // Default: False
	private boolean showParticipantContribution; // Default: False
	private boolean showTotalAmmount; // Default: False

	/* Additional Options */
	private boolean isPublic; // Default: False;
	private boolean openInvitation; // Default: false
	private boolean moneytargetCheck;
	private int moneyTarget; //Si esta desnmarcado es NULL
	private boolean openMessage; // Default: True
	private boolean showMessageWall; // Default: True
	private boolean notifyEmail; // Default: False
	public boolean isContributionField() {
		return contributionField;
	}
	public void setContributionField(boolean contributionField) {
		this.contributionField = contributionField;
	}
	public boolean isEndDateCheck() {
		return endDateCheck;
	}
	public void setEndDateCheck(boolean endDateCheck) {
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
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public boolean isOpenInvitation() {
		return openInvitation;
	}
	public void setOpenInvitation(boolean openInvitation) {
		this.openInvitation = openInvitation;
	}
	public int getMoneyTarget() {
		return moneyTarget;
	}
	public void setMoneyTarget(int moneyTarget) {
		this.moneyTarget = moneyTarget;
	}
	public boolean isMoneytargetCheck() {
		return moneytargetCheck;
	}
	public void setMoneytargetCheck(boolean moneytargetCheck) {
		this.moneytargetCheck = moneytargetCheck;
	}
	public boolean isOpenMessage() {
		return openMessage;
	}
	public void setOpenMessage(boolean openMessage) {
		this.openMessage = openMessage;
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

	
}
