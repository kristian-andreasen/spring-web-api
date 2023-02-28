

INSERT INTO franchise
VALUES (DEFAULT,'Star Wars is an American epic space opera[1] multimedia franchise created by George Lucas, which began with the eponymous 1977 film[b] and quickly became a worldwide pop culture phenomenon. The franchise has been expanded into various films and other media, including television series, video games, novels, comic books, theme park attractions, and themed areas, comprising an all-encompassing fictional universe.[c] Star Wars is one of the highest-grossing media franchises of all time.', 'Star Wars');

INSERT INTO franchise
VALUES (DEFAULT,'Indiana Jones is an American media franchise based on the adventures of Dr. Henry Walton "Indiana" Jones, Jr., a fictional professor of archaeology, that began in 1981 with the film Raiders of the Lost Ark. In 1984, a prequel, The Temple of Doom, was released, and in 1989, a sequel, The Last Crusade. A fourth film followed in 2008, titled The Kingdom of the Crystal Skull. A fifth film, titled The Dial of Destiny, is in production and is scheduled to be released in 2023. The series was created by George Lucas and stars Harrison Ford as Indiana Jones. The first four films were directed by Steven Spielberg, who worked closely with Lucas during their production.',  'Indiana Jones');

INSERT INTO franchise
VALUES (DEFAULT,'Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns Harry''s conflict with Lord Voldemort, a dark wizard who intends to become immortal, overthrow the wizard governing body known as the Ministry of Magic and subjugate all wizards and Muggles (non-magical people).','Harry Potter' );

INSERT INTO tb_movie
VALUES (DEFAULT, 'George Lucas', 'Star Wars', 'Action, Adventure, Fantasy', 'https://www.vintagemovieposters.co.uk/wp-content/uploads/2020/11/IMG_0689-scaled.jpeg','Star Wars: Episode IV - A New Hope',1977,'https://www.youtube.com/watch?v=s0oZPZCBk6E');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Irvin Kershner', 'Star Wars', 'Action, Adventure, Fantasy','' ,'Star Wars: Episode V - The Empire Strikes Back',1980,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Richard Marquand', 'Star Wars', 'Action, Adventure, Fantasy','' ,'Star Wars: Episode VI - Return of the Jedi',1983,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'George Lucas', 'Star Wars', 'Action, Adventure, Fantasy','' ,'Star Wars: Episode I - The Phantom Menace',1999,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'George Lucas', 'Star Wars', 'Action, Adventure, Fantasy', '','Star Wars: Episode II - Attack of the Clones',2002,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'George Lucas', 'Star Wars', 'Action, Adventure, Fantasy', '','Star Wars: Episode III - Revenge of the Sith',2005,'https://www.youtube.com/example');

INSERT INTO tb_movie
VALUES (DEFAULT, 'Steven Spielberg', 'Indiana Jones', 'Action, Adventure','' ,'Indiana Jones and the Raiders of the Lost Ark',1981,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Steven Spielberg', 'Indiana Jones', 'Action, Adventure','' ,'Indiana Jones and the Temple of Doom',1984,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Steven Spielberg', 'Indiana Jones', 'Action, Adventure', '','Indiana Jones and the Last Crusade',1989,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Steven Spielberg', 'Indiana Jones', 'Action, Adventure','' ,'Indiana Jones and the Kingdom of the Krystal Skull',2008,'https://www.youtube.com/example');

INSERT INTO tb_movie
VALUES (DEFAULT, 'Chris Columbus', 'Harry Potter', 'Adventure, Family, Fantasy', '','Harry Potter and the Sorcerers Stone',2001,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Chris Columbus', 'Harry Potter', 'Adventure, Family, Fantasy','' ,'Harry Potter and the Chamber of Secrets',2002,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Alfonso Cuarón', 'Harry Potter', 'Adventure, Family, Fantasy', '','Harry Potter and the Prisoner of Azkaban',2004,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'Mike Newell', 'Harry Potter', 'Adventure, Family, Fantasy', '','Harry Potter and the Goblet of Fire',2005,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'David Yates', 'Harry Potter', 'Adventure, Family, Fantasy', '','Harry Potter and the Order of Phoenix',2007,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'David Yates', 'Harry Potter', 'Adventure, Family, Fantasy', '','Harry Potter and the Half-Blood Prince',2009,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'David Yates', 'Harry Potter', 'Adventure, Family, Fantasy','' ,'Harry Potter and the Deathly Hallows part 1',2010,'https://www.youtube.com/example');
INSERT INTO tb_movie
VALUES (DEFAULT, 'David Yates', 'Harry Potter', 'Adventure, Family, Fantasy','' ,'Harry Potter and the Deathly hallows part 2',2011,'https://www.youtube.com/example');

INSERT INTO character
VALUES(DEFAULT, NULL, 'male', NULL, 'Luke Skywalker');
INSERT INTO character
VALUES(DEFAULT, NULL, 'male', NULL, 'Han Solo');
INSERT INTO character
VALUES(DEFAULT, 'Princess Leia', 'female', NULL, 'Leia Organa');
INSERT INTO character
VALUES(DEFAULT, NULL, 'male', NULL, 'Jar Jar Binks');
INSERT INTO character
VALUES(DEFAULT, NULL, 'other', NULL, 'IG-88');
INSERT INTO character
VALUES(DEFAULT, 'Anakin Skywalker', 'male', NULL, 'Darth Vader');

INSERT INTO character
VALUES(DEFAULT, NULL, 'male', NULL, 'Harry Potter');
INSERT INTO character
VALUES(DEFAULT, NULL, 'male', NULL, 'Ron Weasley');
INSERT INTO character
VALUES(DEFAULT, NULL, 'female', NULL, 'Hermione Granger');
INSERT INTO character
VALUES(DEFAULT, NULL, 'male', NULL, 'Dobby');

INSERT INTO character
VALUES(DEFAULT, 'Dr.Jones', 'male', NULL, 'Indiana Jones');
INSERT INTO character
VALUES(DEFAULT, NULL, 'female', NULL, 'Marion');
INSERT INTO character
VALUES(DEFAULT, NULL, 'male', NULL, 'Short Round');