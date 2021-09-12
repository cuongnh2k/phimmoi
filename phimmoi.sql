create database `PhimMoi`;
use `PhimMoi`;

create table `Admin`(
	`id` bigint auto_increment primary key,
	`account` varchar(50) not null unique,
    `password` varchar(50) not null,
    `email` varchar(50) not null unique
);

create table `Phim`(
	`id` bigint auto_increment primary key,
	`type` varchar(50) not null,
	`category` varchar(50) not null,
    `episode` varchar(50) not null,
    `episodeURL` text not null,
    `imageURL` text not null,
    `title` text not null,
    `view` bigint default 0,
    `report` bit(1) default 0,
	constraint CHK_Phim check(
		`type`='Phim bộ' or `type`='Phim hoạt hình' or `type`='Phim chiếu rạp' or `type`='Phim lẻ'
		and `category`='Phim hành động' or `category`='Phim kinh dị' or `category`='Phim hoạt hình' or `category`='Phim tình cảm'
        or `category`='Phim cổ trang' or `category`='Phim phiêu lưu' or `category`='Hài hước' or `category`='Phim hành động'
        or `category`='TV SHOW'
	)
);
create table `User`(
	`id` bigint primary key,
    `name` varchar(50) not null,
    `history` text
);

create table `Comment`(
	`id` bigint primary key auto_increment,
	`content` text not null,
	`user_id` bigint not null,
    `phim_id` bigint not null,
    `time` datetime not null,
    `edit` bit(1) default 0
);

create table `Response`(
	`id` bigint primary key auto_increment,
	`content` text not null,
	`user_id` bigint not null,
    `comment_id` bigint not null,
    `phim_id` bigint not null,
    `time` datetime not null,
     `edit` bit(1) default 0
);
ALTER TABLE `Comment` ADD FOREIGN KEY (`phim_id`) REFERENCES `phim`(`id`);
ALTER TABLE `Comment` ADD FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);
ALTER TABLE `Response` ADD FOREIGN KEY (`comment_id`) REFERENCES `comment`(`id`);
ALTER TABLE `Response` ADD FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);
ALTER TABLE `Response` ADD FOREIGN KEY (`phim_id`) REFERENCES `phim`(`id`);
alter table `phim` add fulltext(`title`);

