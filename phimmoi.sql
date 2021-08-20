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
    `view` bigint,
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
select distinct category from phim where `type`= 'Phim hoạt hình';

select * from phim order by(`view`) desc limit 12;
select * from phim where `type`='Phim bộ'and episode = 1 or episode like '1 %' order by(id) limit 12;