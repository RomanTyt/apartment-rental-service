-- liquibase formatted sql

-- changeset tyutyakov:create-apartment-table
create table if not exists APARTMENT.APARTMENT
(
    APARTMENT_ID                    UUID            not null    unique    primary key,
    NUMBER_OF_ROOMS                 smallint        not null,
    TOTAL_AREA                      float           not null,
    KITCHEN_AREA                    float           not null,
    FLOOR                           smallint        not null,
    BATHROOM                        varchar(36),
    FURNITURE                       varchar(300),
    APPLIANCES                      varchar(300),
    APARTMENT_DESCRIPTION           varchar(2000),
    ADDRESS_ID                      UUID            unique    references ADDRESS(ADDRESS_ID),
    RULES_OF_ACCOMMODATION_ID       UUID            unique    references RULES_OF_ACCOMMODATION(RULES_OF_ACCOMMODATION_ID)
)
