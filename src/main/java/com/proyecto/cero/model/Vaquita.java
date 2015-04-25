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
    ACTIVA, FINALIZADA, CANCELADA;
  }
  @Id @GeneratedValue
  @Column(name = "id", unique=true)
  private int id;
  
  @NotNull
  @Column(name = "nombre")
  private String nombre;
  
  @NotNull
  @Column(name = "creador")
  private String creador;
  
  @Column(name = "organizador")
  private String organizador; // (==NULL) ? Nombre del creador : organizador

  @NotNull
  @Column(name = "imagen")
  private String imagen; // Default: imgDefault.png
  
  @Column(name = "descripcion")
  private String descripcion;
  
  @Column(name = "cancelReason")
  private String cancelReason;

  @NotNull
  @Column(name = "fechaInicio")
  private Date fechaInicio;
  
  @Column(name = "fechaFin")
  private Date fechaFin;

  @NotNull
  @Column(name = "VaquitaPublica")
  private boolean VaquitaPublica; // Default: False;
  
  @NotNull
  @Column(name = "contributionField")
  private boolean contributionField; // Default: True // Se le saca el monto // final Sino se le saca a la contribucion
  
  @NotNull
  @Column(name = "mostrarNombreParticipantes")
  private boolean mostrarNombreParticipantes; // Default: False
  
  @NotNull
  @Column(name = "mostrarPlataParticipante")
  private boolean mostrarPlataParticipante; // Default: False
  
  @NotNull
  @Column(name = "mostrarPlataTotalRecaudada")
  private boolean mostrarPlataTotalRecaudada; // Default: False
  
  @NotNull
  @Column(name = "mensajeAbierto")
  private boolean mensajeAbierto; // Default: True
  
  @NotNull
  @Column(name = "invitacionAbierta")
  private boolean invitacionAbierta; // Default: True
  
  @NotNull
  @Column(name = "mostrarMuroMensajes")
  private boolean mostrarMuroMensajes; // Default: True
  
  @NotNull
  @Column(name = "emailNotifications")
  private boolean emailNotifications; // Default: False

  @Column(name = "contribucionDefinida")
  private int contribucionDefinida;
  
  @Column(name = "contribucionSugerida")
  private int contribucionSugerida;
  
  @Column(name = "objetivoDeDinero")
  private int objetivoDeDinero;

  /** TODO @NotNull
  @Column(name = "estado")
  private Status status; // Default: ACTIVA
*/

  public Vaquita(String nombre, String creador, String organizador, String imagen, String descripcion, String cancelReason, Date fechaInicio,
      Date fechaFin, boolean vaquitaPublica, boolean contributionField, boolean mostrarNombreParticipantes, boolean mostrarPlataParticipante,
      boolean mostrarPlataTotalRecaudada, boolean mensajeAbierto, boolean invitacionAbierta, boolean mostrarMuroMensajes, boolean emailNotifications,
      int contribucionDefinida, int contribucionSugerida, int objetivoDeDinero) {
    super();
    this.nombre = nombre;
    this.creador = creador;
    this.organizador = organizador;
    this.imagen = imagen;
    this.descripcion = descripcion;
    this.cancelReason = cancelReason;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.VaquitaPublica = vaquitaPublica;
    this.contributionField = contributionField;
    this.mostrarNombreParticipantes = mostrarNombreParticipantes;
    this.mostrarPlataParticipante = mostrarPlataParticipante;
    this.mostrarPlataTotalRecaudada = mostrarPlataTotalRecaudada;
    this.mensajeAbierto = mensajeAbierto;
    this.invitacionAbierta = invitacionAbierta;
    this.mostrarMuroMensajes = mostrarMuroMensajes;
    this.emailNotifications = emailNotifications;
    this.contribucionDefinida = contribucionDefinida;
    this.contribucionSugerida = contribucionSugerida;
    this.objetivoDeDinero = objetivoDeDinero;
  }

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

//  public Status getStatus() {
//    return status;
//  }
//
//  public void setStatus(Status status) {
//    this.status = status;
//  }

  public String getCancelReason() {
    return cancelReason;
  }

  public void setCancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
  }

  public boolean isVaquitaPublica() {
    return VaquitaPublica;
  }

  public void setVaquitaPublica(boolean vaquitaPublica) {
    VaquitaPublica = vaquitaPublica;
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

  public int getObjetivoDeDinero() {
    return objetivoDeDinero;
  }

  public void setObjetivoDeDinero(int objetivoDeDinero) {
    this.objetivoDeDinero = objetivoDeDinero;
  }

  @Override
  public String toString() {
    return "Vaquita [nombre=" + nombre + ", creador=" + creador + ", organizador=" + organizador + ", imagen=" + imagen + ", descripcion="
        + descripcion + ", cancelReason=" + cancelReason + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", VaquitaPublica="
        + VaquitaPublica + ", contributionField=" + contributionField + ", mostrarNombreParticipantes=" + mostrarNombreParticipantes
        + ", mostrarPlataParticipante=" + mostrarPlataParticipante + ", mostrarPlataTotalRecaudada=" + mostrarPlataTotalRecaudada
        + ", mensajeAbierto=" + mensajeAbierto + ", invitacionAbierta=" + invitacionAbierta + ", mostrarMuroMensajes=" + mostrarMuroMensajes
        + ", emailNotifications=" + emailNotifications + ", contribucionDefinida=" + contribucionDefinida + ", contribucionSugerida="
        + contribucionSugerida + ", objetivoDeDinero=" + objetivoDeDinero + ", status=" + "]";
  }

}
