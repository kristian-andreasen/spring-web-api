

INSERT INTO franchise (description, franchise_name)
VALUES ('Star Wars is an American epic space opera[1] multimedia franchise created by George Lucas, which began with the eponymous 1977 film[b] and quickly became a worldwide pop culture phenomenon. The franchise has been expanded into various films and other media, including television series, video games, novels, comic books, theme park attractions, and themed areas, comprising an all-encompassing fictional universe.[c] Star Wars is one of the highest-grossing media franchises of all time.', 'Star Wars'),
 ('Indiana Jones is an American media franchise based on the adventures of Dr. Henry Walton "Indiana" Jones, Jr., a fictional professor of archaeology, that began in 1981 with the film Raiders of the Lost Ark. In 1984, a prequel, The Temple of Doom, was released, and in 1989, a sequel, The Last Crusade. A fourth film followed in 2008, titled The Kingdom of the Crystal Skull. A fifth film, titled The Dial of Destiny, is in production and is scheduled to be released in 2023. The series was created by George Lucas and stars Harrison Ford as Indiana Jones. The first four films were directed by Steven Spielberg, who worked closely with Lucas during their production.',  'Indiana Jones'),
 ('Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns HarryNULLs conflict with Lord Voldemort, a dark wizard who intends to become immortal, overthrow the wizard governing body known as the Ministry of Magic and subjugate all wizards and Muggles (non-magical people).','Harry Potter' );

INSERT INTO tb_movie (director, genre, movie_picture, movie_title, release_year, trailer)
VALUES ('George Lucas',  'Action, Adventure, Fantasy', NULL,'Star Wars: Episode IV - A New Hope',1977,NULL),
       ( 'Irwin Kersner',  'Action, Adventure, Fantasy',NULL ,'Star Wars: Episode V - The Empire Strikes Back',1980,NULL),
       ( 'Richard Mcraund',  'Action, Adventure, Fantasy',NULL ,'Star Wars: Episode VI - Return of the Jedi',1983,NULL),
       ( 'George Lucas',  'Action, Adventure, Fantasy',NULL ,'Star Wars: Episode I - The Phantom Menace',1999,NULL),
       ( 'George Lucas',  'Action, Adventure, Fantasy', NULL,'Star Wars: Episode II - Attack of the Clones',2002,NULL),
       ('George Lucas',  'Action, Adventure, Fantasy', NULL,'Star Wars: Episode III - Revenge of the Sith',2005,NULL),
       ('Steven Spielberg',  'Action, Adventure',NULL ,'Indiana Jones and the Raiders of the Lost Ark',1981,NULL),
       ('Steven Spielberg',  'Action, Adventure',NULL ,'Indiana Jones and the Temple of Doom',1984,NULL),
       ('Steven Spielberg',  'Action, Adventure', NULL,'Indiana Jones and the Last Crusade',1989,NULL),
       ('Steven Spielberg',  'Action, Adventure',NULL ,'Indiana Jones and the Kingdom of the Krystal Skull',2008,NULL),
       ('Chris Columbus',  'Adventure, Family, Fantasy', NULL,'Harry Potter and the Sorcerers Stone',2001,NULL),
       ('Chris Columbus',  'Adventure, Family, Fantasy',NULL ,'Harry Potter and the Chamber of Secrets',2002,NULL),
       ( 'Alfonzo cuaron',  'Adventure, Family, Fantasy', NULL,'Harry Potter and the Prisoner of Azkaban',2004,NULL),
       ( 'Mike Newell',  'Adventure, Family, Fantasy', NULL,'Harry Potter and the Goblet of Fire',2005,NULL),
       ( 'David Yates',  'Adventure, Family, Fantasy', NULL,'Harry Potter and the Order of Phoenix',2007,NULL),
       ( 'David Yates',  'Adventure, Family, Fantasy', NULL,'Harry Potter and the Half-Blood Prince',2009,NULL),
       ( 'David Yates',  'Adventure, Family, Fantasy',NULL ,'Harry Potter and the Deathly Hallows part 1',2010,NULL),
       ( 'David Yates',  'Adventure, Family, Fantasy',NULL ,'Harry Potter and the Deathly hallows part 2',2011,NULL);

INSERT INTO character (alias, character_gender, character_picture, full_name)
VALUES('Anakin Skywalker', 'male', NULL, 'Darth Vader'),
(NULL, 'male', NULL, 'Dobby'),
(NULL, 'female', NULL, 'Short Round');
