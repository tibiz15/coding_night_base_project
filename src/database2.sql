create table SO
(
  soID          int auto_increment
    primary key,
  applicationID int           not null,
  name          varchar(100)  not null,
  description   varchar(4096) not null,
  aim           varchar(4096) not null,
  head          varchar(200)  not null,
  address       varchar(400)  not null,
  tel_num       varchar(100)  not null,
  email         varchar(100)  not null,
  facebook      varchar(200)  not null
);

create table Job
(
  jobID       int auto_increment
    primary key,
  soID        int           not null,
  title       varchar(100)  not null,
  description varchar(4096) not null,
  constraint linkToSo
  foreign key (soID) references SO (soID)
    on update cascade
    on delete cascade
);

create table User
(
  userID  int auto_increment
    primary key,
  role    varchar(200) not null,
  name    varchar(200) not null,
  email   varchar(100) not null,
  tel_num varchar(100) not null
);

create table SO_application
(
  applicationID int auto_increment,
  userID        int           not null,
  name          varchar(200)  not null,
  description   varchar(4096) not null,
  aim           varchar(4096) not null,
  approved      tinyint(1)    not null,
  status        varchar(400)  not null,
  rejected_text varchar(400)  null,
  dekanID       int           null,
  skID          int           null,
  constraint SO_application_applicationID_uindex
  unique (applicationID),
  constraint linkToUserAppl
  foreign key (userID) references User (userID)
    on update cascade
    on delete cascade
);

alter table SO_application
  add primary key (applicationID);

create table User_Job
(
  userID    int                                     not null,
  jobID     int                                     not null,
  startDate timestamp default CURRENT_TIMESTAMP     not null
  on update CURRENT_TIMESTAMP,
  endDate   timestamp default '0000-00-00 00:00:00' not null,
  feedback  varchar(4096)                           null,
  primary key (userID, jobID, startDate),
  constraint linkToJobFromUser
  foreign key (jobID) references Job (jobID)
    on update cascade
    on delete cascade,
  constraint linkToUser
  foreign key (userID) references User (userID)
    on update cascade
    on delete cascade
);

create table Vacancy
(
  vacancyID int auto_increment
    primary key,
  jobID     int                                 not null,
  active    tinyint(1)                          not null,
  deadline  timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  comment   varchar(4096)                       null,
  constraint linkToJob
  foreign key (jobID) references Job (jobID)
    on update cascade
    on delete cascade
);

create table flyway_schema_history
(
  installed_rank int                                 not null
    primary key,
  version        varchar(50)                         null,
  description    varchar(200)                        not null,
  type           varchar(20)                         not null,
  script         varchar(1000)                       not null,
  checksum       int                                 null,
  installed_by   varchar(100)                        not null,
  installed_on   timestamp default CURRENT_TIMESTAMP not null,
  execution_time int                                 not null,
  success        tinyint(1)                          not null
);

create index flyway_schema_history_s_idx
  on flyway_schema_history (success);