create schema VirtualArtGallery;
use VirtualArtGallery;

create table Artwork(
ArtworkID int auto_increment primary key,
Title varchar(255) not null unique,
Description varchar(255) default "No description provided",
CreationDate date not null,
Medium varchar(255),
ImageURL varchar(500) default "NO image available");

create table Artist(ArtistID int auto_increment primary key,
Name varchar(255) not null,
Biography varchar(500) default "Bio unavailable",
BirthDate Date not null,
Nationality Varchar(255),
Website varchar(500) default "website unavilable",
ContactInfromation BigInt not null);

alter table artist drop foreign key fk_artist_artwork;

alter table artwork modify column artworkid int,
add constraint fk_artwork_artist foreign key (artworkid) references artist(artistid) on delete cascade;

select * from artwork;
show create table artwork;

create table User(UserId int auto_increment primary key,
Username varchar(255)not null unique,
Password varchar(255) not null unique,
Email varchar(255) unique,
FirstName varchar(255) not null,
LastName varchar(255),
DateOfBirth Date not null,
ProfilePicture varchar(255) default "no image available");

create table FavoriteArtworks(
UserID int,
ArtworkID int,
primary key(userID,ArtworkID),
foreign key (userid) references User(userid) on delete cascade,
foreign key (artworkid) references artwork(artworkid)on delete cascade);

rename table favoriteartworks to User_Favorite_Artwork;

create table Gallery(
GalleryID int auto_increment primary key,
Name varchar(255) not null,
Description varchar(255) default "No description available",
Location varchar(255),
Curator int not null,
OpeningHours Time,
foreign key (curator) references Artist(ArtistID));

create table Artwork_Gallery(
ArtworkID int,
GalleryID int,
primary key(ArtworkID,GalleryID),
foreign key (ArtworkID) references Artwork(ArtworkID)on delete cascade,
foreign key (GalleryID) references Gallery(GalleryID) on delete cascade);

show create table artwork;
alter table artwork drop foreign key artwork_ibfk_1;

alter table artwork add column ArtistId int not null;
alter table artwork modify column ArtistId int not null,
add constraint fk_artwork_artist foreign key (ArtistId) references Artist(ArtistID) on delete cascade;

show create table gallery;
alter table Gallery drop foreign key gallery_ibfk_1;
alter table Gallery Add constraint fk_gallery_artist foreign key(Curator) references artist(artistID) on delete cascade;


show databases;
use virtualartgallery;

show tables;
describe user_favorite_artwork;
describe artist;
ALTER TABLE artist MODIFY COLUMN ContactInfromation VARCHAR(20);
ALTER TABLE artist Rename column ContactInfromation to ContactInformation;
select * from artist;
show tables;
describe artwork;
select * from artwork;
select * from artist;
describe gallery;
select * from gallery;

describe user;
select * from user;
select * from Artist;
select * from artwork;
select * from gallery;

create table admin(adminID int primary key auto_increment,
adminloginId Varchar(255),
password varchar(255));

insert into admin(adminloginID,password) values("admin","admin@1234");

select * from admin;
show tables;
select * from user_favorite_artwork;
show create table user_favorite_artwork;
delete from user_favorite_artwork where userId=4;
ALTER TABLE user_favorite_artwork DROP Primary Key;
alter table user_favorite_artwork add constraint fk_User_ArtWorkID Foreign key (ArtworkID) references artwork(ArtworkId) on delete cascade;

select * from user;
select * from artwork;
ALTER TABLE user AUTO_INCREMENT = 2;
update user set username="Ash" where username=1;
set sql_safe_updates=0;

delete from user_favorite_artwork where userID=1;
ALTER TABLE user_favorite_artwork
ADD CONSTRAINT unique_user_artwork
UNIQUE (UserId, ArtworkId);

select * from artist;
delete from artist where artistid=2;

use virtualartgallery;
show tables;
select * from user_favorite_artwork;
select * from artwork;