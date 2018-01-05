/*
Navicat PGSQL Data Transfer

Source Server         : localhost
Source Server Version : 90412
Source Host           : localhost:5432
Source Database       : homework
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90412
File Encoding         : 65001

Date: 2018-01-05 14:10:18
*/


-- ----------------------------
-- Sequence structure for book_id_seq
-- ----------------------------
DROP SEQUENCE "public"."book_id_seq";
CREATE SEQUENCE "public"."book_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for publisher_id_seq
-- ----------------------------
DROP SEQUENCE "public"."publisher_id_seq";
CREATE SEQUENCE "public"."publisher_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS "public"."book";
CREATE TABLE "public"."book" (
"id" int4 DEFAULT nextval('book_id_seq'::regclass) NOT NULL,
"page" varchar(100) COLLATE "default",
"publicdate" varchar(50) COLLATE "default",
"author" varchar(50) COLLATE "default",
"title" varchar(50) COLLATE "default",
"coverimage" varchar(200) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO "public"."book" VALUES ('1', '15', '17/02/1972', 'GG', 'Isabella Weber II', 'http://lorempixel.com/100/100/nightlife/');
INSERT INTO "public"."book" VALUES ('2', '15', '17/02/1972', 'GG', 'River Beahan', 'http://lorempixel.com/100/100/people/');
INSERT INTO "public"."book" VALUES ('3', '15', '17/02/1972', 'GG', 'Bernadette Koelpin', 'http://lorempixel.com/100/100/city/');
INSERT INTO "public"."book" VALUES ('4', '15', '17/02/1972', 'GG', 'Donnie Aufderhar MD', 'http://lorempixel.com/100/100/nightlife/');
INSERT INTO "public"."book" VALUES ('5', '15', '17/02/1972', 'GG', 'Mr. Sarina Abernathy', 'http://lorempixel.com/100/100/cats/');
INSERT INTO "public"."book" VALUES ('6', '15', '17/02/1972', 'GG', 'Carli Collier', 'http://lorempixel.com/100/100/city/');
INSERT INTO "public"."book" VALUES ('7', '15', '17/02/1972', 'GG', 'Eduardo Homenick', 'http://lorempixel.com/100/100/cats/');
INSERT INTO "public"."book" VALUES ('8', '15', '17/02/1972', 'GG', 'Rachael Kris', 'http://lorempixel.com/100/100/animals/');
INSERT INTO "public"."book" VALUES ('9', '15', '17/02/1972', 'GG', 'Mr. Cleo Rogahn', 'http://lorempixel.com/100/100/technics/');
INSERT INTO "public"."book" VALUES ('10', '15', '17/02/1972', 'GG', 'Sam Konopelski', 'http://lorempixel.com/100/100/cats/');
INSERT INTO "public"."book" VALUES ('11', '15', '17/02/1972', 'GG', 'Lillie Bartoletti', 'http://lorempixel.com/100/100/fashion/');
INSERT INTO "public"."book" VALUES ('12', '15', '17/02/1972', 'GG', 'Frances Kub', 'http://lorempixel.com/100/100/animals/');
INSERT INTO "public"."book" VALUES ('13', '15', '17/02/1972', 'GG', 'Hollis Glover', 'http://lorempixel.com/100/100/city/');
INSERT INTO "public"."book" VALUES ('14', '15', '17/02/1972', 'GG', 'Cheyenne Emmerich', 'http://lorempixel.com/100/100/nightlife/');
INSERT INTO "public"."book" VALUES ('15', '15', '17/02/1972', 'GG', 'Maymie Ledner III', 'http://lorempixel.com/100/100/business/');
INSERT INTO "public"."book" VALUES ('16', '15', '17/02/1972', 'GG', 'Kimberly Barton', 'http://lorempixel.com/100/100/city/');
INSERT INTO "public"."book" VALUES ('17', '15', '17/02/1972', 'GG', 'Bernard Morissette', 'http://lorempixel.com/100/100/animals/');
INSERT INTO "public"."book" VALUES ('18', '15', '17/02/1972', 'GG', 'Nathan Dibbert MD', 'http://lorempixel.com/100/100/technics/');
INSERT INTO "public"."book" VALUES ('19', '15', '17/02/1972', 'GG', 'Ms. Simone Johnson', 'http://lorempixel.com/100/100/cats/');
INSERT INTO "public"."book" VALUES ('20', '15', '17/02/1972', 'GG', 'Haylee Kemmer', 'http://lorempixel.com/100/100/animals/');

-- ----------------------------
-- Table structure for bookpublic
-- ----------------------------
DROP TABLE IF EXISTS "public"."bookpublic";
CREATE TABLE "public"."bookpublic" (
"book_id" int4,
"publisher_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of bookpublic
-- ----------------------------
INSERT INTO "public"."bookpublic" VALUES ('1', '1');
INSERT INTO "public"."bookpublic" VALUES ('1', '2');
INSERT INTO "public"."bookpublic" VALUES ('2', '1');
INSERT INTO "public"."bookpublic" VALUES ('2', '3');
INSERT INTO "public"."bookpublic" VALUES ('3', '1');
INSERT INTO "public"."bookpublic" VALUES ('3', '3');
INSERT INTO "public"."bookpublic" VALUES ('4', '1');
INSERT INTO "public"."bookpublic" VALUES ('5', '3');
INSERT INTO "public"."bookpublic" VALUES ('6', '1');
INSERT INTO "public"."bookpublic" VALUES ('7', '3');
INSERT INTO "public"."bookpublic" VALUES ('8', '1');
INSERT INTO "public"."bookpublic" VALUES ('9', '3');
INSERT INTO "public"."bookpublic" VALUES ('10', '1');
INSERT INTO "public"."bookpublic" VALUES ('10', '3');
INSERT INTO "public"."bookpublic" VALUES ('11', '1');
INSERT INTO "public"."bookpublic" VALUES ('12', '1');
INSERT INTO "public"."bookpublic" VALUES ('12', '3');
INSERT INTO "public"."bookpublic" VALUES ('13', '1');
INSERT INTO "public"."bookpublic" VALUES ('14', '1');
INSERT INTO "public"."bookpublic" VALUES ('14', '3');
INSERT INTO "public"."bookpublic" VALUES ('15', '1');
INSERT INTO "public"."bookpublic" VALUES ('16', '3');
INSERT INTO "public"."bookpublic" VALUES ('17', '1');
INSERT INTO "public"."bookpublic" VALUES ('18', '1');
INSERT INTO "public"."bookpublic" VALUES ('18', '3');
INSERT INTO "public"."bookpublic" VALUES ('19', '3');
INSERT INTO "public"."bookpublic" VALUES ('20', '1');
INSERT INTO "public"."bookpublic" VALUES ('20', '3');

-- ----------------------------
-- Table structure for publisher
-- ----------------------------
DROP TABLE IF EXISTS "public"."publisher";
CREATE TABLE "public"."publisher" (
"id" int4 DEFAULT nextval('publisher_id_seq'::regclass) NOT NULL,
"name" varchar(50) COLLATE "default",
"gender" varchar(10) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of publisher
-- ----------------------------
INSERT INTO "public"."publisher" VALUES ('1', 'Ronal Do', 'Male');
INSERT INTO "public"."publisher" VALUES ('2', 'Missi', 'Male');
INSERT INTO "public"."publisher" VALUES ('3', 'Angle', 'Female');

-- ----------------------------
-- Table structure for tbrole
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbrole";
CREATE TABLE "public"."tbrole" (
"id" int4 NOT NULL,
"role" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbrole
-- ----------------------------
INSERT INTO "public"."tbrole" VALUES ('1', 'ADMIN');
INSERT INTO "public"."tbrole" VALUES ('2', 'DBA');
INSERT INTO "public"."tbrole" VALUES ('3', 'USER');

-- ----------------------------
-- Table structure for tbuser
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbuser";
CREATE TABLE "public"."tbuser" (
"id" int4 NOT NULL,
"name" varchar(30) COLLATE "default",
"image" varchar(100) COLLATE "default",
"gender" varchar(10) COLLATE "default",
"password" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbuser
-- ----------------------------
INSERT INTO "public"."tbuser" VALUES ('1', 'torang', 'image', 'm', '123');
INSERT INTO "public"."tbuser" VALUES ('2', 'lyka', 'image', 'f', 'admin');
INSERT INTO "public"."tbuser" VALUES ('3', 'user', 'image', 'm', 'user');

-- ----------------------------
-- Table structure for tbuser_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbuser_role";
CREATE TABLE "public"."tbuser_role" (
"user_id" int4 NOT NULL,
"role_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbuser_role
-- ----------------------------
INSERT INTO "public"."tbuser_role" VALUES ('1', '1');
INSERT INTO "public"."tbuser_role" VALUES ('1', '2');
INSERT INTO "public"."tbuser_role" VALUES ('1', '3');
INSERT INTO "public"."tbuser_role" VALUES ('2', '2');
INSERT INTO "public"."tbuser_role" VALUES ('2', '3');
INSERT INTO "public"."tbuser_role" VALUES ('3', '3');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."book_id_seq" OWNED BY "book"."id";
ALTER SEQUENCE "public"."publisher_id_seq" OWNED BY "publisher"."id";

-- ----------------------------
-- Primary Key structure for table book
-- ----------------------------
ALTER TABLE "public"."book" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table publisher
-- ----------------------------
ALTER TABLE "public"."publisher" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tbrole
-- ----------------------------
ALTER TABLE "public"."tbrole" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tbuser
-- ----------------------------
ALTER TABLE "public"."tbuser" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."bookpublic"
-- ----------------------------
ALTER TABLE "public"."bookpublic" ADD FOREIGN KEY ("book_id") REFERENCES "public"."book" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."bookpublic" ADD FOREIGN KEY ("publisher_id") REFERENCES "public"."publisher" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;
