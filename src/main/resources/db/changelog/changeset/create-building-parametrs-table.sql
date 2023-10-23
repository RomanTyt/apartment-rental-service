-- liquibase formatted sql

-- changeset tyutyakov:create-building-parameters-table
create table if not exists APARTMENT.BUILDING_PARAMETERS
(
    BUILDING_ID                 UUID            not null    unique  primary key,
    HOUSE_TYPE                  varchar(50)     not null,
    YEAR_OF_CONSTRUCTION        smallint        not null,
    FLOORS_IN_THE_HOUSE         smallint        not null,
    PASSENGER_ELEVATOR_QUANTITY smallint        not null,
    FREIGHT_ELEVATOR_QUANTITY   smallint        not null,
    PARKING_SPACE               varchar(200)    not null,
    ADDRESS_ID                  UUID            unique      references ADDRESS(ADDRESS_ID)
)
