package iuh.vn.edu.fit.backend.converters;

import iuh.vn.edu.fit.backend.enums.ProductStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(ProductStatus.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
