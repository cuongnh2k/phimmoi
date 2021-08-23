create database PhimMoi;
use PhimMoi;

create table `Admin`(
	`account` varchar(50),
    `password` varchar(50)
);

create table Phim(
	id int auto_increment primary key,
	`type` varchar(50),
	category varchar(50),
    episode varchar(50),
    episodeURL text,
    imageURL text,
    title text,
    `view` bigint default 0,
	constraint CHK_Phim check(
		`type`='Phim bộ' or `type`='Phim hoạt hình' or `type`='Phim chiếu rạp' or `type`='Phim lẻ'
		and category='Phim hành động' or category='Phim kinh dị' or category='Phim hoạt hình' or category='Phim tình cảm'
        or category='Phim cổ trang' or category='Phim phiêu lưu' or category='Hài hước' or category='Phim hành động'
        or category='TV SHOW'
	)
);

create table `Comment`(
	id int auto_increment primary key,
    `comment` text,
    email varchar(50),
    id_phim int
);

create table Response(
	id_comment int,
    response text,
    email varchar(50)
);

alter table `Comment` add foreign key (id_phim) references Phim(id);
alter table `Response` add foreign key (id_comment) references `Comment`(id);
insert into `Admin` values('admin','123456');
----------------------------------------------------------------------------

select distinct category from phim where `type`= 'Phim hoạt hình';
select * from phim order by(`view`) desc limit 12;
select * from phim where `type`='Phim bộ'and episode = 1 or episode like '1 %' order by(id) limit 12;
update phim set episode='1' where id<482;

select * from phim where category='Phim tình cảm' group by(title) order by rand() limit 12;
select* from phim where `type`='Phim lẻ' group by(title) order by(id) desc limit 12;
select * from phim where `type`='Phim lẻ' and category='Phim cổ trang' limit 12 offset 0;
select count(distinct title) from phim where `type`='Phim lẻ' and category='Phim tình cảm';
ALTER TABLE `response` DROP FOREIGN KEY response_ibfk_1;
select count(*) from phim