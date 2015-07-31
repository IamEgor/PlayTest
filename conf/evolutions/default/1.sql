# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table DB_Row (
  DB_ROW_ID                 bigint not null,
  label                     varchar(255),
  types_enum                varchar(255),
  required                  boolean,
  is_active                 boolean,
  properties                varchar(255),
  constraint pk_DB_Row primary key (DB_ROW_ID))
;

create table Properties (
  PROPERTIES_ID             bigint not null,
  name                      varchar(255),
  value                     varchar(255),
  constraint pk_Properties primary key (PROPERTIES_ID))
;

create table Response_Data_Model (
  RESPONSE_DATA_ID          bigint not null,
  name                      varchar(255),
  value                     varchar(255),
  constraint pk_Response_Data_Model primary key (RESPONSE_DATA_ID))
;

create sequence DB_Row_seq;

create sequence Properties_seq;

create sequence Response_Data_Model_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists DB_Row;

drop table if exists Properties;

drop table if exists Response_Data_Model;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists DB_Row_seq;

drop sequence if exists Properties_seq;

drop sequence if exists Response_Data_Model_seq;

