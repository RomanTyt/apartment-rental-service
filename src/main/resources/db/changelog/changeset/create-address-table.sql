-- liquibase formatted sql

-- changeset tyutyakov:create-address-table
create table if not exists APARTMENT.ADDRESS
(
    ADDRESS_ID              UUID            not null   primary key,
    OBLAST                  varchar(50)     not null,
    CITY                    varchar(50)     not null,
    STREET                  varchar(100)    not null,
    HOUSE_NUMBER            varchar(100)    not null,
    HASH_CODE               int             not null
)