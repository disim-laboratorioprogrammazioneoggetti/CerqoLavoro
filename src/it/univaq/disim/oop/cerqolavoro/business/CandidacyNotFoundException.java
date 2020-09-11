package it.univaq.disim.oop.cerqolavoro.business;

public class CandidacyNotFoundException extends BusinessException {

	public CandidacyNotFoundException() {
	}

	public CandidacyNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CandidacyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CandidacyNotFoundException(String message) {
		super(message);
	}

	public CandidacyNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
