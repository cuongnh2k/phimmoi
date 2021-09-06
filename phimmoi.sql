create database PhimMoi;
use PhimMoi;

create table `Admin`(
	`id` int auto_increment primary key,
	`account` varchar(50) not null,
    `password` varchar(50) not null,
    `email` varchar(50) not null unique
);

create table Phim(
	id int auto_increment primary key,
	`type` varchar(50) not null,
	category varchar(50) not null,
    episode varchar(50) not null,
    episodeURL text not null,
    imageURL text not null,
    title text not null,
    `view` bigint default 0,
    `report` bit(1) default 0,
	constraint CHK_Phim check(
		`type`='Phim bộ' or `type`='Phim hoạt hình' or `type`='Phim chiếu rạp' or `type`='Phim lẻ'
		and category='Phim hành động' or category='Phim kinh dị' or category='Phim hoạt hình' or category='Phim tình cảm'
        or category='Phim cổ trang' or category='Phim phiêu lưu' or category='Hài hước' or category='Phim hành động'
        or category='TV SHOW'
	)
);
create table `User`(
	`id` bigint primary key,
    `name` varchar(50) not null
);

create table `Comment`(
	`id` int primary key auto_increment,
	`content` text not null,
	`user_id` bigint not null,
    `phim_id` int not null,
    `time` datetime not null
);

create table `Response`(
	`id` int primary key auto_increment,
	`content` text not null,
	`user_id` bigint not null,
    `comment_id` int not null,
    `phim_id` int not null,
    `time` datetime not null
);
ALTER TABLE `Comment` ADD FOREIGN KEY (phim_id) REFERENCES phim(id);
ALTER TABLE `Comment` ADD FOREIGN KEY (user_id) REFERENCES `user`(id);
ALTER TABLE `Response` ADD FOREIGN KEY (comment_id) REFERENCES `comment`(id);
ALTER TABLE `Response` ADD FOREIGN KEY (user_id) REFERENCES `user`(id);
ALTER TABLE `Response` ADD FOREIGN KEY (phim_id) REFERENCES `phim`(id);

alter table phim add fulltext(title);
SELECT count(*) FROM phim WHERE MATCH(title) AGAINST("abc" IN NATURAL LANGUAGE MODE);
SELECT count(*) FROM phim WHERE MATCH(title) AGAINST("anh" WITH QUERY EXPANSION);
SELECT count(*) FROM phim WHERE MATCH(title) AGAINST("+anh -hung" IN BOOLEAN MODE);
SELECT count(*) FROM phim WHERE MATCH(title) AGAINST("anh" IN BOOLEAN MODE);
select count(distinct title) from phim ;
update `admin` set `password`='1' where `account` ='admin';
alter table `response` add column `time` datetime not null;