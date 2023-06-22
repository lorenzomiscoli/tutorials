package com.lorenzomiscoli.jpa_attribute_converter.converters;

import com.lorenzomiscoli.jpa_attribute_converter.model.enums.CountryCode;

import jakarta.persistence.AttributeConverter;

public class CountryCodeAttributeConverter implements AttributeConverter<CountryCode, String> {

	@Override
	public String convertToDatabaseColumn(CountryCode attribute) {
		return attribute.getValue();
	}

	@Override
	public CountryCode convertToEntityAttribute(String dbData) {
		return CountryCode.valueOf(dbData);
	}

}
