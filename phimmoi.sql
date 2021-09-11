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
    `time` datetime not null,
    `edit` bit(1) default 0
);

create table `Response`(
	`id` int primary key auto_increment,
	`content` text not null,
	`user_id` bigint not null,
    `comment_id` int not null,
    `phim_id` int not null,
    `time` datetime not null,
     `edit` bit(1) default 0
);
ALTER TABLE `Comment` ADD FOREIGN KEY (phim_id) REFERENCES phim(id);
ALTER TABLE `Comment` ADD FOREIGN KEY (user_id) REFERENCES `user`(id);
ALTER TABLE `Response` ADD FOREIGN KEY (comment_id) REFERENCES `comment`(id);
ALTER TABLE `Response` ADD FOREIGN KEY (user_id) REFERENCES `user`(id);
ALTER TABLE `Response` ADD FOREIGN KEY (phim_id) REFERENCES `phim`(id);

alter table phim add fulltext(title);

select `comment`.id, `comment`.content,`comment`.user_id,`comment`.`time`, `user`.`name` from `user`, `comment` where `user`.id=`comment`.user_id and `comment`.phim_id=1;
select `response`.id, `response`.content,`response`.user_id,`response`.`comment_id`, `response`.`time`,`user`.`name` from `user`, `response` where `user`.id=`response`.user_id and `response`.phim_id=1;
insert into `comment`(`content`,`user_id`,`phim_id`,`time`) values('huyền anh ngốc',958140914734886,1,'0000-00-00 19:00:00');
INSERT INTO `phimmoi`.`comment` (`id`, `content`, `user_id`, `phim_id`,`time`) VALUES ('7', 'wwwwwwwwwwwwwww', '1', '1',CURRENT_TIMESTAMP());
select count(`title`) from phim;
delete from `phim` where id=1;