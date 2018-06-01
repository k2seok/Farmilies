DROP TABLE CONTRACT CASCADE CONSTRAINTS;
DROP TABLE WORK CASCADE CONSTRAINTS;
DROP TABLE LOCATIONS CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE PICTURES CASCADE CONSTRAINTS;
DROP TABLE USER_GROUPS CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: USER_GROUPS */
/**********************************/
CREATE TABLE USER_GROUPS(
		id                            		NUMBER(3)		 NOT NULL,
		name                          		VARCHAR2(50)		 NOT NULL,
		update_at                     		DATE		 DEFAULT sysdate		 NOT NULL,
		create_at                     		DATE		 DEFAULT sysdate		 NOT NULL
);

COMMENT ON TABLE USER_GROUPS is 'USER_GROUPS';
COMMENT ON COLUMN USER_GROUPS.id is 'id';
COMMENT ON COLUMN USER_GROUPS.name is 'name';
COMMENT ON COLUMN USER_GROUPS.update_at is 'update_at';
COMMENT ON COLUMN USER_GROUPS.create_at is 'create_at';


/**********************************/
/* Table Name: PICTURES */
/**********************************/
CREATE TABLE PICTURES(
		id                            		NUMBER(12)		 NOT NULL,
		picname                       		VARCHAR2(50)		 NULL ,
		pic_loc                       		VARCHAR2(500)		 NULL 
);

COMMENT ON TABLE PICTURES is 'PICTURES';
COMMENT ON COLUMN PICTURES.id is 'id';
COMMENT ON COLUMN PICTURES.picname is 'picname';
COMMENT ON COLUMN PICTURES.pic_loc is 'pic_loc';


/**********************************/
/* Table Name: USERS */
/**********************************/
CREATE TABLE USERS(
		id                            		VARCHAR2(50)		 NOT NULL,
		update_at                     		DATE		 DEFAULT sysdate		 NOT NULL,
		create_at                     		DATE		 DEFAULT sysdate		 NOT NULL,
		email                         		VARCHAR2(50)		 NULL ,
		password                      		VARCHAR2(50)		 NOT NULL,
		first_name                    		VARCHAR2(50)		 NOT NULL,
		last_name                     		VARCHAR2(50)		 NOT NULL,
		group_id                      		NUMBER(3)		 NOT NULL,
		picture_id                    		NUMBER(12)		 NULL 
);

COMMENT ON TABLE USERS is 'USERS';
COMMENT ON COLUMN USERS.id is 'id';
COMMENT ON COLUMN USERS.update_at is 'update_at';
COMMENT ON COLUMN USERS.create_at is 'create_at';
COMMENT ON COLUMN USERS.email is 'email';
COMMENT ON COLUMN USERS.password is 'password';
COMMENT ON COLUMN USERS.first_name is 'first_name';
COMMENT ON COLUMN USERS.last_name is 'last_name';
COMMENT ON COLUMN USERS.group_id is 'group_id';
COMMENT ON COLUMN USERS.picture_id is 'picture_id';


/**********************************/
/* Table Name: LOCATIONS */
/**********************************/
CREATE TABLE LOCATIONS(
		id                            		NUMBER(10)		 NOT NULL,
		address_name                  		VARCHAR2(500)		 NOT NULL,
		address_type                  		VARCHAR2(11)		 NOT NULL,
		x                             		DOUBLE PRECISION		 NOT NULL,
		y                             		DOUBLE PRECISION		 NOT NULL,
		region_address                		VARCHAR2(500)		 NOT NULL,
		road_address                  		VARCHAR2(500)		 NULL 
);

COMMENT ON TABLE LOCATIONS is 'LOCATIONS';
COMMENT ON COLUMN LOCATIONS.id is 'id';
COMMENT ON COLUMN LOCATIONS.address_name is 'address_name';
COMMENT ON COLUMN LOCATIONS.address_type is 'address_type';
COMMENT ON COLUMN LOCATIONS.x is 'x';
COMMENT ON COLUMN LOCATIONS.y is 'y';
COMMENT ON COLUMN LOCATIONS.region_address is 'region_address';
COMMENT ON COLUMN LOCATIONS.road_address is 'road_address';


/**********************************/
/* Table Name: WORK */
/**********************************/
CREATE TABLE WORK(
		id                            		NUMBER(10)		 NOT NULL,
		pic_id                        		NUMBER(12)		 NULL ,
		hirer_id                      		VARCHAR2(50)		 NOT NULL,
		title                         		VARCHAR2(50)		 NOT NULL,
		description                   		VARCHAR2(500)		 NOT NULL,
		location_id                   		NUMBER(10)		 NULL 
);

COMMENT ON TABLE WORK is 'WORK';
COMMENT ON COLUMN WORK.id is 'id';
COMMENT ON COLUMN WORK.pic_id is 'pic_id';
COMMENT ON COLUMN WORK.hirer_id is 'hirer_id';
COMMENT ON COLUMN WORK.title is 'title';
COMMENT ON COLUMN WORK.description is 'description';
COMMENT ON COLUMN WORK.location_id is 'location_id';


/**********************************/
/* Table Name: CONTRACT */
/**********************************/
CREATE TABLE CONTRACT(
		id                            		NUMBER(10)		 NOT NULL,
		rating                        		NUMBER(10,2)		 NULL ,
		comments                      		VARCHAR2(2000)		 NULL ,
		worker_id                     		VARCHAR2(50)		 NOT NULL,
		work_id                       		NUMBER(10)		 NOT NULL
);

COMMENT ON TABLE CONTRACT is 'CONTRACT';
COMMENT ON COLUMN CONTRACT.id is 'id';
COMMENT ON COLUMN CONTRACT.rating is 'rating';
COMMENT ON COLUMN CONTRACT.comments is 'comments';
COMMENT ON COLUMN CONTRACT.worker_id is 'worker_id';
COMMENT ON COLUMN CONTRACT.work_id is 'work_id';



ALTER TABLE USER_GROUPS ADD CONSTRAINT IDX_USER_GROUPS_PK PRIMARY KEY (id);

ALTER TABLE PICTURES ADD CONSTRAINT IDX_PICTURES_PK PRIMARY KEY (id);

ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_PK PRIMARY KEY (id);
ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_FK0 FOREIGN KEY (group_id) REFERENCES USER_GROUPS (id);
ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_FK1 FOREIGN KEY (picture_id) REFERENCES PICTURES (id);

ALTER TABLE LOCATIONS ADD CONSTRAINT IDX_LOCATIONS_PK PRIMARY KEY (id);

ALTER TABLE WORK ADD CONSTRAINT IDX_WORK_PK PRIMARY KEY (id);
ALTER TABLE WORK ADD CONSTRAINT IDX_WORK_FK0 FOREIGN KEY (hirer_id) REFERENCES USERS (id);
ALTER TABLE WORK ADD CONSTRAINT IDX_WORK_FK1 FOREIGN KEY (pic_id) REFERENCES PICTURES (id);
ALTER TABLE WORK ADD CONSTRAINT IDX_WORK_FK2 FOREIGN KEY (location_id) REFERENCES LOCATIONS (id);

ALTER TABLE CONTRACT ADD CONSTRAINT IDX_CONTRACT_PK PRIMARY KEY (id);
ALTER TABLE CONTRACT ADD CONSTRAINT IDX_CONTRACT_FK0 FOREIGN KEY (work_id) REFERENCES WORK (id);
ALTER TABLE CONTRACT ADD CONSTRAINT IDX_CONTRACT_FK1 FOREIGN KEY (worker_id) REFERENCES USERS (id);

