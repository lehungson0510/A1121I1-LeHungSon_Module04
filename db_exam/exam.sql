create database if not exists exam;
use exam;

INSERT INTO `exam`.`information` (`id`, `content`, `date`, `reporter`, `title`, `category_id`) VALUES ('1', 'a', '2022-01-01', 'a', 'a', '1');
INSERT INTO `exam`.`information` (`id`, `content`, `date`, `reporter`, `title`, `category_id`) VALUES ('2', 'b', '2000-10-01', 'b', 'b', '2');
INSERT INTO `exam`.`information` (`id`, `content`, `date`, `reporter`, `title`, `category_id`) VALUES ('3', 'c', '2000-10-05', 'c', 'c', '3');


INSERT INTO `exam`.`category` (`id`, `name`) VALUES ('1', 'Y te');
INSERT INTO `exam`.`category` (`id`, `name`) VALUES ('2', 'Khoa hoc');
INSERT INTO `exam`.`category` (`id`, `name`) VALUES ('3', 'Lich su');
