package com.lorenzomiscoli.hibernate_composite_primary_key.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "translation")
public class Translation {

	@EmbeddedId
	private TranslationId translationId;

	public TranslationId getTranslationId() {
		return translationId;
	}

	public void setTranslationId(TranslationId translationId) {
		this.translationId = translationId;
	}

}
