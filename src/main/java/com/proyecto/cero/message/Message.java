package com.proyecto.cero.message;

/**
 * A message to display to the user.
 * Has a type indicating the kind of message.
 * @author Keith Donald
 */
public final class Message {
	
	private final MessageType type;
	
	private final String text;

	/**
	 * Creates a new Message of a certain type consisting of the text provided.
	 */
	public Message(MessageType type, String text) {
		this.type = type;
		this.text = text;
	}

	/**
	 * The type of message; such as info, warning, error, or success.
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * The info text.
	 */
	public String getText() {
		return text;
	}
	
	public String toString() {
		return type + ": " + text;
	}

}
