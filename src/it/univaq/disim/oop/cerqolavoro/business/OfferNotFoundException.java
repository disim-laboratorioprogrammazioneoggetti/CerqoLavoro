package it.univaq.disim.oop.cerqolavoro.business;

public class OfferNotFoundException extends BusinessException {

	public OfferNotFoundException() {
	}

	public OfferNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OfferNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OfferNotFoundException(String message) {
		super(message);
	}

	public OfferNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
