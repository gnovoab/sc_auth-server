CREATE TABLE `gnb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE ,
  `email` varchar(255) NOT NULL UNIQUE ,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL DEFAULT 'ROLE_USER',
  `active` bit(1) NOT NULL DEFAULT b'1',
  `password_reset` bit(1) NOT NULL DEFAULT  b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into gnb_user(username, email, password) values('gnovoa', 'me@gnovoa.com','$2a$06$vwMkaBQlHs8NnRZUcGr2RusZ3lY79YxGkpNkaI3aUyjXAt1qavBna');
