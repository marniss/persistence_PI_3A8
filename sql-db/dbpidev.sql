/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     07/02/2018 16:22:07                          */
/*==============================================================*/


drop table if exists Animal;

drop table if exists Centre_de_Soin;

drop table if exists Centre_de_dressage;

drop table if exists Councours;

drop table if exists Membre;

drop table if exists SOS_disparition;

drop table if exists f_dressage;

drop table if exists f_soin;

drop table if exists loisir;

drop table if exists participation;

drop table if exists visite;

/*==============================================================*/
/* Table: Animal                                                */
/*==============================================================*/
create table Animal
(
   id_animal            int not null,
   id_f_soin            int,
   id_f_dressage        int,
   id_membre            int not null,
   nom_animal           varchar(0),
   type                 char(10),
   primary key (id_animal),
   key AK_Identifier_1 (id_animal),
   key AK_Identifier_2 (id_animal),
   key AK_Identifier_3 (id_animal)
);

/*==============================================================*/
/* Table: Centre_de_Soin                                        */
/*==============================================================*/
create table Centre_de_Soin
(
   id_centre            int not null,
   primary key (id_centre)
);

/*==============================================================*/
/* Table: Centre_de_dressage                                    */
/*==============================================================*/
create table Centre_de_dressage
(
   id_centre_de_dreeage int not null,
   primary key (id_centre_de_dreeage),
   key AK_Identifier_1 (id_centre_de_dreeage)
);

/*==============================================================*/
/* Table: Councours                                             */
/*==============================================================*/
create table Councours
(
   id_concours          int not null,
   primary key (id_concours),
   key AK_Identifier_1 (id_concours)
);

/*==============================================================*/
/* Table: Membre                                                */
/*==============================================================*/
create table Membre
(
   id_membre            int not null,
   primary key (id_membre),
   key AK_Identifier_1 (id_membre),
   key AK_Identifier_2 (id_membre)
);

/*==============================================================*/
/* Table: SOS_disparition                                       */
/*==============================================================*/
create table SOS_disparition
(
   id_sos_dis           int not null,
   primary key (id_sos_dis),
   key AK_Identifier_1 (id_sos_dis)
);

/*==============================================================*/
/* Table: f_dressage                                            */
/*==============================================================*/
create table f_dressage
(
   id_f_dressage        int not null,
   primary key (id_f_dressage),
   key AK_Identifier_1 (id_f_dressage)
);

/*==============================================================*/
/* Table: f_soin                                                */
/*==============================================================*/
create table f_soin
(
   id_f_soin            int not null,
   primary key (id_f_soin),
   key AK_Identifier_1 (id_f_soin)
);

/*==============================================================*/
/* Table: loisir                                                */
/*==============================================================*/
create table loisir
(
   id_animal            int not null,
   id_centre_de_dreeage int not null,
   primary key (id_animal, id_centre_de_dreeage)
);

/*==============================================================*/
/* Table: participation                                         */
/*==============================================================*/
create table participation
(
   id_concours          int not null,
   id_animal            int not null,
   primary key (id_concours, id_animal)
);

/*==============================================================*/
/* Table: visite                                                */
/*==============================================================*/
create table visite
(
   id_animal            int not null,
   id_centre            int not null,
   primary key (id_animal, id_centre)
);

alter table Animal add constraint FK_Association_1 foreign key (id_f_soin)
      references f_soin (id_f_soin) on delete restrict on update restrict;

alter table Animal add constraint FK_Association_3 foreign key (id_f_dressage)
      references f_dressage (id_f_dressage) on delete restrict on update restrict;

alter table Animal add constraint FK_Association_6 foreign key (id_membre)
      references Membre (id_membre) on delete restrict on update restrict;

alter table loisir add constraint FK_Association_4 foreign key (id_animal)
      references Animal (id_animal) on delete restrict on update restrict;

alter table loisir add constraint FK_Association_4 foreign key (id_centre_de_dreeage)
      references Centre_de_dressage (id_centre_de_dreeage) on delete restrict on update restrict;

alter table participation add constraint FK_Association_2 foreign key (id_animal)
      references Animal (id_animal) on delete restrict on update restrict;

alter table participation add constraint FK_Association_2 foreign key (id_concours)
      references Councours (id_concours) on delete restrict on update restrict;

alter table visite add constraint FK_Association_5 foreign key (id_animal)
      references Animal (id_animal) on delete restrict on update restrict;

alter table visite add constraint FK_Association_5 foreign key (id_centre)
      references Centre_de_Soin (id_centre) on delete restrict on update restrict;

