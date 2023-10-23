-- liquibase formatted sql

-- changeset tyutyakov:create-rules-of-accommodation-table
create table if not exists APARTMENT.RULES_OF_ACCOMMODATION
(
    RULES_OF_ACCOMMODATION_ID           UUID        not null    unique  primary key,
    NUMBER_OF_GUESTS                    smallint    not null,
    CAN_SMOKE                           boolean     not null,
    POSSIBLE_WITH_ANIMALS               boolean     not null,
    POSSIBLE_WITH_CHILDREN              boolean     not null
)