package org.techniu.isbackend.exception;

public enum ExceptionType {

    ENTITY_NOT_FOUND("not.found"),
    DUPLICATE_ENTITY("duplicate"),
    ADDED("added"),
    UPDATED("updated"),
    APPLICATION_ALREADY_HAS_A_CONTRACT("application.already.has.a.contract"),
    PUBLIC_PROPERTY_ALREADY_HAS_A_METER("public.property.already.has.meter"),
    DOMESTIC_PROPERTY_ALREADY_HAS_A_METER("domestic.property.already.has.meter"),
    INDCOM_PROPERTY_ALREADY_HAS_A_METER("industrial.commercial.property.already.has.meter"),
    APPLICATION_Type_AND_WATER_CONTRACT_CATEGORY_ARE_DIFFERENT("application.type.and.water.contract.category.are.different"),
    CONFIGURATION_DATABASE_TABLE_NAME_NOT_BLANK("configuration.table.name.can't.be.blank"),
    METER_DIAMETER_CAN_T_BE_NULL("meter.diameter.can't.be.null"),
    CODE_SHOULD_NOT_CONTAIN_SPACES("code.should.not.contain.spaces"),
    DELETED("deleted"),
    ASSIGNED_LEVEL_STAFF("staff.assigned.to.level"),
    SECTOR_RELATED_TO_CLIENT("this sector its already related to a client !");

    // public static final ExceptionType SECTOR_RELATED_TO_CLIENT = null;
    String value;

    ExceptionType(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
