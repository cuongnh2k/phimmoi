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
	`email` varchar(50) not null unique,
    `verified_email` bit(1),
    `name` varchar(50) not null,
    `given_name` varchar(50),
    `family_name` varchar(50),
    `link` varchar(50),
    `picture` varchar(50)
);

create table `Comment`(
	`id` int primary key auto_increment,
	`content` text not null,
	`user_id` bigint not null,
    `phim_id` int not null
);

create table `Response`(
	`id` int primary key auto_increment,
	`content` text not null,
	`user_id` bigint not null,
    `comment_id` int not null
);
ALTER TABLE `Comment` ADD FOREIGN KEY (phim_id) REFERENCES phim(id);
ALTER TABLE `Comment` ADD FOREIGN KEY (user_id) REFERENCES `user`(id);
ALTER TABLE `Response` ADD FOREIGN KEY (comment_id) REFERENCES `comment`(id);

alter table phim add fulltext(title);

