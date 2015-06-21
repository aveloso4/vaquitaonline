package com.proyecto.cero.vaquita;

import java.sql.Date;

import javax.persistence.Column;

import com.proyecto.cero.model.Vaquita.Status;

public class VaquitaSecondStepForm {

	private String cancelReason;
  private Date startDate;
  private Date endDate;
  private boolean isPublic; // Default: False;
  private boolean contributionField; // Default: True // Se le saca a el monto final //Sino se le saca a la contribucion
  private boolean showParicipantName; // Default: False
  private boolean showParticipantContribution; // Default: False
  private boolean showTotalAmmount; // Default: False
  private boolean openMessage; // Default: True
  private boolean openInvitation; // Default: True
  private boolean showMessageWall; // Default: True
  private boolean notifyEmail; // Default: False
  private int fixContribution;
  private int suggestedContribution;
  private boolean openContribution; // Fix and Suggested == null -> Open Contribution = true
  private int objetivoDeDinero;
  private Status status; // Default: ACTIVA

  

}
