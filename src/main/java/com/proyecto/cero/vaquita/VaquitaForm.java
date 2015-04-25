package com.proyecto.cero.vaquita;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

public class VaquitaForm {
	
	public VaquitaForm() {
		//Contructor Vacio
	}

  @NotEmpty
  private String nombre;
  
  @NotEmpty
  private String creador;
  
  private String organizador; // (==NULL) ? Nombre del creador : organizador

  @NotEmpty
  private String imagen; // Default: imgDefault.png
  
  private String descripcion;
  
  private String cancelReason;

  @NotEmpty
  private Date fechaInicio;
  
  private Date fechaFin;

  @NotEmpty
  private boolean VaquitaPublica; // Default: False;
  
  @NotEmpty
  private boolean contributionField; // Default: True // Se le saca el monto // final Sino se le saca a la contribucion
  
  @NotEmpty
  private boolean mostrarNombreParticipantes; // Default: False
  
  @NotEmpty
  private boolean mostrarPlataParticipante; // Default: False
  
  @NotEmpty
  private boolean mostrarPlataTotalRecaudada; // Default: False
  
  @NotEmpty
  private boolean mensajeAbierto; // Default: True
  
  @NotEmpty
  private boolean invitacionAbierta; // Default: True
  
  @NotEmpty
  private boolean mostrarMuroMensajes; // Default: True
  
  @NotEmpty
  private boolean emailNotifications; // Default: False

  private int contribucionDefinida;
  
  private int contribucionSugerida;
  
  private int objetivoDeDinero;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCreador() {
    return creador;
  }

  public void setCreador(String creador) {
    this.creador = creador;
  }

  public String getOrganizador() {
    return organizador;
  }

  public void setOrganizador(String organizador) {
    this.organizador = organizador;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getCancelReason() {
    return cancelReason;
  }

  public void setCancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
  }

  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }

  public boolean isVaquitaPublica() {
    return VaquitaPublica;
  }

  public void setVaquitaPublica(boolean vaquitaPublica) {
    VaquitaPublica = vaquitaPublica;
  }

  public boolean isContributionField() {
    return contributionField;
  }

  public void setContributionField(boolean contributionField) {
    this.contributionField = contributionField;
  }

  public boolean isMostrarNombreParticipantes() {
    return mostrarNombreParticipantes;
  }

  public void setMostrarNombreParticipantes(boolean mostrarNombreParticipantes) {
    this.mostrarNombreParticipantes = mostrarNombreParticipantes;
  }

  public boolean isMostrarPlataParticipante() {
    return mostrarPlataParticipante;
  }

  public void setMostrarPlataParticipante(boolean mostrarPlataParticipante) {
    this.mostrarPlataParticipante = mostrarPlataParticipante;
  }

  public boolean isMostrarPlataTotalRecaudada() {
    return mostrarPlataTotalRecaudada;
  }

  public void setMostrarPlataTotalRecaudada(boolean mostrarPlataTotalRecaudada) {
    this.mostrarPlataTotalRecaudada = mostrarPlataTotalRecaudada;
  }

  public boolean isMensajeAbierto() {
    return mensajeAbierto;
  }

  public void setMensajeAbierto(boolean mensajeAbierto) {
    this.mensajeAbierto = mensajeAbierto;
  }

  public boolean isInvitacionAbierta() {
    return invitacionAbierta;
  }

  public void setInvitacionAbierta(boolean invitacionAbierta) {
    this.invitacionAbierta = invitacionAbierta;
  }

  public boolean isMostrarMuroMensajes() {
    return mostrarMuroMensajes;
  }

  public void setMostrarMuroMensajes(boolean mostrarMuroMensajes) {
    this.mostrarMuroMensajes = mostrarMuroMensajes;
  }

  public boolean isEmailNotifications() {
    return emailNotifications;
  }

  public void setEmailNotifications(boolean emailNotifications) {
    this.emailNotifications = emailNotifications;
  }

  public int getContribucionDefinida() {
    return contribucionDefinida;
  }

  public void setContribucionDefinida(int contribucionDefinida) {
    this.contribucionDefinida = contribucionDefinida;
  }

  public int getContribucionSugerida() {
    return contribucionSugerida;
  }

  public void setContribucionSugerida(int contribucionSugerida) {
    this.contribucionSugerida = contribucionSugerida;
  }

  public int getObjetivoDeDinero() {
    return objetivoDeDinero;
  }

  public void setObjetivoDeDinero(int objetivoDeDinero) {
    this.objetivoDeDinero = objetivoDeDinero;
  }
	
  
  
}
